package ynu.edu.user_service.dto;

// 错误响应DTO
public class ErrorResponseCustomer {
    private String error;

    public ErrorResponseCustomer(String error) {
        this.error = error;
    }

    public String getError() { return error; }
}
