package ynu.edu.business_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ynu.edu.business_service.po.Business;

import java.util.List;
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {
    @Select("select * from business where business.order_type_id=#{orderTypeId} order by business_id")
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    @Select("select * from business where business_id=#{businessId}")
    public Business getBusinessById(Integer businessId);
}