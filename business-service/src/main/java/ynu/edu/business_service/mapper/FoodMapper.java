package ynu.edu.business_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ynu.edu.business_service.po.Food;

import java.util.List;
@Mapper
public interface FoodMapper extends BaseMapper<Food> {
    @Select("select * from food where business_id=#{businessId} order by food_id")
    public List<Food> listFoodByBusinessId(Integer businessId);

    @Select("select * from food where food_id=#{foodId}")
    public Food getFoodById(Integer foodId);
}