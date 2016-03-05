package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

/**
 * Created by Solyk on 03.03.2016.
 */

public interface OrderService {
    boolean createOrder(Client client, Double amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);
}
