package ynu.edu.order_service.service;

import ynu.edu.order_service.po.Orders;

import java.util.List;
public interface OrdersService {
    public int createOrders(Orders orders);
    public Orders getOrdersById(Integer orderId);
    public List<Orders> listOrdersByUserId(String userId);
}