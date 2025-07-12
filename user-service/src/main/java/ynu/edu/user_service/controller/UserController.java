// UserController.java (添加@RefreshScope和调整路径)
package ynu.edu.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynu.edu.user_service.dto.ErrorResponseCustomer;
import ynu.edu.user_service.dto.LoginResponse;
import ynu.edu.user_service.po.User;
import ynu.edu.user_service.service.UserService;
import ynu.edu.user_service.utils.JwtUtil;


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
        // 验证用户名和密码是否正确
        User authenticatedUser = userService.getUserByIdByPass(user);

        if (authenticatedUser != null) {
            // 生成JWT token
            String token = jwtUtil.generateToken(authenticatedUser.getUserId());

            // 返回登录成功响应，包含token
            return ResponseEntity.ok(new LoginResponse("登录成功", token, authenticatedUser));
        } else {
            // 返回登录失败响应
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponseCustomer("用户名或密码错误"));
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