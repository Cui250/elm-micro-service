package ynu.edu.user_service.dto;

import ynu.edu.user_service.po.User;

// 登录响应DTO
public class LoginResponse {
    private String message;
    private String token;
    private User user;

    public LoginResponse(String message, String token, User user) {
        this.message = message;
        this.token = token;
        this.user = user;
    }

    // getters
    public String getMessage() { return message; }
    public String getToken() { return token; }
    public User getUser() { return user; }
}

