package hw9.taxi.service;

import hw9.taxi.domain.Client;
import taxi.exception.OrderException;

/**
 * Created by Юлия on 02.03.2016.
 */
public interface OrderService {

    boolean createOrder(Client client, Double amount, String addressFrom, String addressTo) throws OrderException;

    void editOrder(Long id,String amount,String addressFrom, String addressTo);
}
