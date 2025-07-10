package ynu.edu.user_service.dto;

// 登录响应DTO
public class LoginResponse {
    private String message;
    private String token;

    public LoginResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    // getters
    public String getMessage() { return message; }
    public String getToken() { return token; }
}

