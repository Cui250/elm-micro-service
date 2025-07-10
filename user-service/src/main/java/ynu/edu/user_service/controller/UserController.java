// UserController.java (添加@RefreshScope和调整路径)
package ynu.edu.user_service.controller;

import com.alibaba.nacos.api.remote.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynu.edu.user_service.dto.ErrorResponseCustomer;
import ynu.edu.user_service.dto.LoginResponse;
import ynu.edu.user_service.po.User;
import ynu.edu.user_service.service.UserService;


@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/getUserByIdByPass")
    public User getUserByIdByPass(@RequestBody User user) {
        return userService.getUserByIdByPass(user);

    }

    @GetMapping("/getUserById/{userId}")
    public int getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/saveUser")
    public int saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}