// DeliveryAddressController.java
package ynu.edu.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import ynu.edu.user_service.po.DeliveryAddress;
import ynu.edu.user_service.service.DeliveryAddressService;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/address")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @GetMapping("/listByUserId/{userId}")
    public List<DeliveryAddress> listDeliveryAddressByUserId(@PathVariable String userId) {
        return deliveryAddressService.listDeliveryAddressByUserId(userId);
    }

    @GetMapping("/getById/{daId}")
    public DeliveryAddress getDeliveryAddressById(@PathVariable Integer daId) {
        return deliveryAddressService.getDeliveryAddressById(daId);
    }

    @PostMapping("/save")
    public int saveDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
        return deliveryAddressService.saveDeliveryAddress(deliveryAddress);
    }

    @PutMapping("/update")
    public int updateDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
        return deliveryAddressService.updateDeliveryAddress(deliveryAddress);
    }

    @DeleteMapping("/remove/{daId}")
    public int removeDeliveryAddress(@PathVariable Integer daId) {
        return deliveryAddressService.removeDeliveryAddress(daId);
    }
}