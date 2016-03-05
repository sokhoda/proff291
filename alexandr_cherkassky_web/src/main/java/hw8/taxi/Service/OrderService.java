package hw8.taxi.service;

import hw8.taxi.exception.OrderException;
import hw8.taxi.domain.Client;

import java.util.List;

/**
 * Created by Пк2 on 27.02.2016.
 */
public interface OrderService {
    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);
    List showOrders(Long from, Long to);
    List showOrdersByPortion();
}
