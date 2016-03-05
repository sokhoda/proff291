package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

/**
 * Created by Solyk on 03.03.2016.
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public boolean createOrder(Client client, Double amount, String addressFrom, String addressTo) throws OrderException {
        return false;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {

    }
}
