package ynu.edu.order_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ynu.edu.business_service.po.Business;
import ynu.edu.business_service.po.Food;
import ynu.edu.order_service.feign.BusinessFeignClient;
import ynu.edu.order_service.mapper.CartMapper;
import ynu.edu.order_service.po.Cart;
import ynu.edu.order_service.service.CartService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    @Autowired
    private CartMapper cartMapper;
    private final BusinessFeignClient businessFeignClient;

    @Override
    public List<Cart> listCart(Cart cart) {
        return cartMapper.listCart(cart);
    }

    @Override
    @Transactional
    public int saveCart(Cart cart) {
        // 1. 获取食品详情
        Food food = businessFeignClient.getFoodById(cart.getFoodId());

        // 2. 获取商家详情
        Business business = businessFeignClient.getBusinessById(cart.getBusinessId());

        // 设置冗余字段
        cart.setFoodName(food.getFoodName());
        cart.setFoodImg(food.getFoodImg());
        cart.setFoodPrice(food.getFoodPrice());
        cart.setBusinessName(business.getBusinessName());

        cart.setQuantity(1);

        // 4. 保存到数据库
        return cartMapper.saveCart(cart);
    }

    @Override
    public int updateCart(Cart cart) {
        return cartMapper.updateCartQuantity(cart);
    }

    @Override
    public int removeCart(Cart cart) {
        return cartMapper.removeCart(cart);
    }
}