package ynu.edu.user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import ynu.edu.user_service.po.DeliveryAddress;

import java.util.List;
@Mapper
public interface DeliveryAddressMapper extends BaseMapper<DeliveryAddress> {
    @Select("select * from delivery_address where user_id=#{userId} order by da_id")
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);

    @Select("select * from delivery_address where da_id=#{daId}")
    public DeliveryAddress getDeliveryAddressById(Integer daId);

    @Insert("insert into delivery_address values(null,#{contactName},#{contactSex},#{contactTel},#{address},#{userId})")
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress);

    @Update("update delivery_address set contact_name=#{contactName},contact_sex=#{contactSex},contact_tel=#{contactTel},address=#{address} where da_id=#{daId}")
            public int updateDeliveryAddress(DeliveryAddress deliveryAddress);

    @Delete("delete from delivery_address where da_id=#{daId}")
    public int removeDeliveryAddress(Integer daId);
}