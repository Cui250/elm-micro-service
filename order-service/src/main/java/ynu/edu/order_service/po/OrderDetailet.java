// OrderDetailet.java
package ynu.edu.order_service.po;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class OrderDetailet {
	@TableId
	private Integer odId;
	private Integer orderId;
	private Integer foodId;
	private String foodName;          // 冗余食品名称
	private String foodImg;           // 冗余食品图片
	private Double foodPrice;         // 冗余食品价格
	private Integer quantity;
}