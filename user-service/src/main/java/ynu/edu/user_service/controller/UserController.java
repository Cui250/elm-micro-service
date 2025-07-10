// UserController.java (添加@RefreshScope和调整路径)
package ynu.edu.user_service.controller;

import com.alibaba.nacos.api.remote.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynu.edu.common.utils.JwtUtil;
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

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/getUserByIdByPass")
    public ResponseEntity<?> getUserByIdByPass(@RequestBody User user) {
        User authenticatedUser = userService.getUserByIdByPass(user);
        if (authenticatedUser != null) {
            // 生成Token，这里使用用户ID作为subject
            String token = jwtUtil.generateToken(authenticatedUser.getUserId());
            return ResponseEntity.ok()
                    .body(new LoginResponse("登录成功", token));
        } else {
            return ResponseEntity.status(401)
                    .body(new ErrorResponseCustomer("用户名或密码错误"));
        }
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