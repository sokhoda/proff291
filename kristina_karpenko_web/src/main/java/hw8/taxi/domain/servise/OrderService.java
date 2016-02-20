package hw8.taxi.domain.servise;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.exception.OrderException;

import java.util.List;

/**
 * Created by Администратор on 17.01.2016.
 */
public interface OrderService {
    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);
    List showOrders(Long from, Long to);
    List showOrdersByPortion();

}
