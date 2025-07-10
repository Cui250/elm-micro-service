package ynu.edu.order_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ynu.edu.business_service.po.Business;
import ynu.edu.business_service.po.Food;

// BusinessFeignClient.java
@FeignClient(name = "business-service")
public interface BusinessFeignClient {
    @GetMapping("/business/getById/{businessId}")
    Business getBusinessById(@PathVariable Integer businessId);

    @GetMapping("/food/getById/{foodId}")
    Food getFoodById(@PathVariable Integer foodId);
}