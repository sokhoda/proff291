package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by v.davidenko on 29.01.2016.
 */
public class OrderServiceImpl implements OrderService {

    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {


        return true;
    }

    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {

    }

    public List showOrders(Long from, Long to) {
        List<Order> list = new LinkedList<>();


        return list;
    }

    public List showOrdersByPortion() {
        List<Order> list = new LinkedList<>();


        return list;
    }
}
