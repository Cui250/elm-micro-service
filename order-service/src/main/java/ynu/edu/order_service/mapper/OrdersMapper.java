package ynu.edu.order_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import ynu.edu.order_service.po.Orders;

import java.util.List;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    @Select("SELECT * FROM orders WHERE order_id = #{orderId}")
    @ResultMap("ordersResultMap")
    Orders getOrdersById(@Param("orderId") Integer orderId);

    @Select("SELECT * FROM orders WHERE user_id = #{userId} ORDER BY order_id")
    @ResultMap("ordersResultMap")
    List<Orders> listOrdersByUserId(@Param("userId") String userId);
    // 根据用户ID查询订单列表，并按照订单ID排序

    @Insert("INSERT INTO orders(user_id, business_id, business_name, business_address, delivery_price, " +
            "order_date, order_total, da_id, contact_name, contact_tel, address, order_state) " +
            "VALUES(#{userId}, #{businessId}, #{businessName}, #{businessAddress}, #{deliveryPrice}," +
            "#{orderDate}, #{orderTotal}, #{daId}, #{contactName}, #{contactTel}, #{address}, #{orderState})")
    @Options(useGeneratedKeys = true, keyProperty = "orderId")
    int saveOrders(Orders orders);
}