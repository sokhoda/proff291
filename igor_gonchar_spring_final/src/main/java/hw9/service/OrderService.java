package hw9.service;

import hw9.domain.Order;

import java.util.List;

/**
 * Created by i.gonchar on 3/3/2016.
 */
public interface OrderService {
    boolean updateOrder(Order order);
    boolean removeOrder(Order order);
    Long createOrder(Order order);
    Order getOrderByFromToAddress(String addressFrom, String addressTo);
    List getAllOrders();
}
