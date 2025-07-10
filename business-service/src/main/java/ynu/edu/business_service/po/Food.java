package ynu.edu.business_service.po;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data


public class Food {
	@TableId
	private Integer foodId;
	private String foodName;
	private String foodExplain;
	private String foodImg;
	private Double foodPrice;
	private Integer businessId;
	private String remarks;


	public Integer getBusinessId() {
		return businessId;
	}
}
