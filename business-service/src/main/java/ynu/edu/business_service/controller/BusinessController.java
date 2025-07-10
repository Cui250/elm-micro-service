// BusinessController.java
package ynu.edu.business_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import ynu.edu.business_service.po.Business;
import ynu.edu.business_service.service.BusinessService;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/listByOrderType/{orderTypeId}")
    public List<Business> listBusinessByOrderTypeId(@PathVariable Integer orderTypeId) {
        return businessService.listBusinessByOrderTypeId(orderTypeId);
    }

    @GetMapping("/getById/{businessId}")
    public Business getBusinessById(@PathVariable Integer businessId) {
        return businessService.getBusinessById(businessId);
    }
}