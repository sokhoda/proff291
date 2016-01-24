package taxi.service;

import taxi.domain.Client;
import taxi.exception.OrderException;

import java.util.List;

/**
 * Created by Юлия on 19.01.2016.
 */
public interface OrderService {

    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;

    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);

    List showOrders(Long from, Long to);

    List showOrdersByPortion();
}

