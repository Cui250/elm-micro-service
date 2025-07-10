package ynu.edu.user_service.service;
import ynu.edu.user_service.po.User;
public interface UserService {
    public User getUserByIdByPass(User user);
    public int getUserById(String userId);
    public int saveUser(User user);
}