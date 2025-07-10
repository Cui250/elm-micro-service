package ynu.edu.business_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ynu.edu.business_service.mapper.FoodMapper;
import ynu.edu.business_service.po.Food;
import ynu.edu.business_service.service.FoodService;

import java.util.List;
@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodMapper foodMapper;
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        return foodMapper.listFoodByBusinessId(businessId);
    }

    @Override
    public Food getFoodById(Integer id) {
        return foodMapper.getFoodById(id);
    }
}