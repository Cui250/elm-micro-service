package ynu.edu.order_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import ynu.edu.order_service.po.Cart;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    List<Cart> listCart(Cart cart);

    @Insert("INSERT INTO cart(cart_id, food_id, food_name, food_img, food_price, business_id, business_name, user_id, quantity) " +
            "VALUES(null, #{foodId}, #{foodName}, #{foodImg}, #{foodPrice}, #{businessId}, #{businessName}, #{userId}, #{quantity})")
    int saveCart(Cart cart);

    @Update("UPDATE cart SET quantity=#{quantity} WHERE food_id=#{foodId} AND business_id=#{businessId} AND user_id=#{userId}")
    int updateCartQuantity(Cart cart);

    int removeCart(Cart cart);
}