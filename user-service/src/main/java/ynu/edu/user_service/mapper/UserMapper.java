package ynu.edu.user_service.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ynu.edu.user_service.po.User;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where user_id=#{userId} and password=#{password}")
    public User getUserByIdByPass(User user);

    @Select("select count(*) from user where user_id=#{userId}")
    public int getUserById(String userId);

    @Insert("insert into user values(#{userId},#{password},#{userName},#{userSex},null,0)")
    public int saveUser(User user);
}