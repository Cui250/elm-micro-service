package ynu.edu.user_service.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ynu.edu.user_service.mapper.UserMapper;
import ynu.edu.user_service.po.User;
import ynu.edu.user_service.service.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByIdByPass(User user) {
        return userMapper.getUserByIdByPass(user);
    }

    @Override
    public int getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }
}