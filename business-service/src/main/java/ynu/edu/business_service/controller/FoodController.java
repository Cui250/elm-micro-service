// FoodController.java
package ynu.edu.business_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import ynu.edu.business_service.po.Food;
import ynu.edu.business_service.service.FoodService;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/listByBusiness/{businessId}")
    public List<Food> listFoodByBusinessId(@PathVariable Integer businessId) {
        return foodService.listFoodByBusinessId(businessId);
    }
    @GetMapping("/getById/{id}")
    public Food getFoodById(@PathVariable Integer id) {
        return foodService.getFoodById(id);
    }
}