// Orders.java
package ynu.edu.order_service.po;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.List;

@Data
public class Orders {
	@TableId
	private Integer orderId;
	private String userId;
	private Integer businessId;
	private String businessName;       // 冗余商家名称
	private String businessAddress;    // 冗余商家地址
	private Double deliveryPrice;
	private String orderDate;
	private Double orderTotal;
	private Integer daId;
	private String contactName;        // 冗余联系人
	private String contactTel;         // 冗余联系电话
	private String address;           // 冗余配送地址
	private Integer orderState;
	private List<OrderDetailet> list;
}