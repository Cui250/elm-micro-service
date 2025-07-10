package ynu.edu.order_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ynu.edu.order_service.po.OrderDetailet;

import java.util.List;

@Mapper
public interface OrderDetailetMapper extends BaseMapper<OrderDetailet> {
    int saveOrderDetailetBatch(List<OrderDetailet> list);

    List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId);
}