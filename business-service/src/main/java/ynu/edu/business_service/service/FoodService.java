package ynu.edu.business_service.service;

import ynu.edu.business_service.po.Food;

import java.util.List;
public interface FoodService {
    public List<Food> listFoodByBusinessId(Integer businessId);

    Food getFoodById(Integer id);
}