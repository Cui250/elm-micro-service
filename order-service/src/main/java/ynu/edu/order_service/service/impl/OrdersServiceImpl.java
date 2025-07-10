package ynu.edu.order_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ynu.edu.business_service.po.Business;
import ynu.edu.business_service.po.Food;
import ynu.edu.order_service.feign.BusinessFeignClient;
import ynu.edu.order_service.feign.UserFeignClient;
import ynu.edu.order_service.mapper.CartMapper;
import ynu.edu.order_service.mapper.OrderDetailetMapper;
import ynu.edu.order_service.mapper.OrdersMapper;
import ynu.edu.order_service.po.Cart;
import ynu.edu.order_service.po.OrderDetailet;
import ynu.edu.order_service.po.Orders;
import ynu.edu.order_service.service.OrdersService;
import ynu.edu.order_service.util.CommonUtil;
import ynu.edu.user_service.po.DeliveryAddress;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailetMapper orderDetailetMapper;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private BusinessFeignClient businessFeignClient;

    @Override
    @Transactional
    public int createOrders(Orders orders) {
        // 1. 获取配送地址信息
        DeliveryAddress address = userFeignClient.getDeliveryAddressById(orders.getDaId());
        if (address == null) {
            throw new RuntimeException("配送地址不存在");
        }

        // 2. 获取商家信息
        Business business = businessFeignClient.getBusinessById(orders.getBusinessId());
        if (business == null) {
            throw new RuntimeException("商家不存在");
        }

        // 3. 填充冗余字段
        orders.setBusinessName(business.getBusinessName());
        orders.setBusinessAddress(business.getBusinessAddress());
        orders.setContactName(address.getContactName());
        orders.setContactTel(address.getContactTel());
        orders.setAddress(address.getAddress());
        orders.setOrderDate(CommonUtil.getCurrentDate());
        orders.setOrderState(0);

        // 4. 查询购物车商品
        Cart cart = new Cart();
        cart.setUserId(orders.getUserId());
        cart.setBusinessId(orders.getBusinessId());
        List<Cart> cartList = cartMapper.listCart(cart);

        // 5. 计算订单总金额并设置
        orders.setDeliveryPrice(business.getDeliveryPrice());
        double orderTotal = calculateOrderTotal(cartList);
        orderTotal += business.getDeliveryPrice();
        orders.setOrderTotal(orderTotal);

        // 6. 保存订单主表
        ordersMapper.saveOrders(orders);
        int orderId = orders.getOrderId();

        // 7. 保存订单明细
        List<OrderDetailet> orderDetails = buildOrderDetails(cartList, orderId);
        orderDetailetMapper.saveOrderDetailetBatch(orderDetails);

        // 8. 清空购物车
        cartMapper.removeCart(cart);

        return orderId;
    }

    private double calculateOrderTotal(List<Cart> cartItems) {
        return cartItems.stream()
                .mapToDouble(cart -> {
                    Food food = businessFeignClient.getFoodById(cart.getFoodId());
                    return food.getFoodPrice() * cart.getQuantity();
                })
                .sum();
    }

    private List<OrderDetailet> buildOrderDetails(List<Cart> cartItems, int orderId) {
        List<OrderDetailet> details = new ArrayList<>();
        for (Cart cart : cartItems) {
            Food food = businessFeignClient.getFoodById(cart.getFoodId());

            OrderDetailet detail = new OrderDetailet();
            detail.setOrderId(orderId);
            detail.setFoodId(food.getFoodId());
            detail.setFoodName(food.getFoodName());
            detail.setFoodImg(food.getFoodImg());
            detail.setFoodPrice(food.getFoodPrice());
            detail.setQuantity(cart.getQuantity());

            details.add(detail);
        }
        return details;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return ordersMapper.getOrdersById(orderId);
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        return ordersMapper.listOrdersByUserId(userId);
    }
}