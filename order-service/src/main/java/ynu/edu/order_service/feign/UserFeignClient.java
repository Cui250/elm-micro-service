// UserFeignClient.java
package ynu.edu.order_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ynu.edu.user_service.po.DeliveryAddress;
import ynu.edu.user_service.po.User;

@FeignClient(name = "user-service", path = "")
public interface UserFeignClient {

    @GetMapping("/address/getById/{daId}")
    DeliveryAddress getDeliveryAddressById(@PathVariable Integer daId);

    @GetMapping("/user/getUserById/{userId}")
    User getUserById(@PathVariable String userId);
}