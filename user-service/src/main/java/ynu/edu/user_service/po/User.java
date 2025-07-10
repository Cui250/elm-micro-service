package ynu.edu.user_service.po;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data

public class User {
	@TableId
	private String userId;
	private String password;
	private String userName;
	private Integer userSex;
	private String userImg;
	private Integer delTag;


	public String getUserId() {
		return userId;
	}
}
