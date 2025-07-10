// Cart.java
package ynu.edu.order_service.po;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Cart {
	@TableId
	private Integer cartId;
	private Integer foodId;
	private String foodName;          // 冗余食品名称
	private String foodImg;           // 冗余食品图片
	private Double foodPrice;         // 冗余食品价格
	private Integer businessId;
	private String businessName;      // 冗余商家名称
	private String userId;
	private Integer quantity;
}