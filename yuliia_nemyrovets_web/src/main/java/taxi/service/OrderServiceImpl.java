package taxi.service;

import taxi.domain.Client;
import taxi.domain.Order;
import taxi.exception.OrderException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юлия on 19.01.2016.
 * Добавить функции работы с заказами такси.
 * Функции:
 * - оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 * - отредактировать заказ (поменять свойства заказа)
 * - вывести список заказов на сумму в указанном диапазоне
 * - вывести список всех заказов порциями по 5 штук
 */
public class OrderServiceImpl implements OrderService {
    List<Order> orders = new ArrayList<>();

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        if (id == 0 || client == null || amount == null || addressFrom == null || addressTo == null) {
            throw new OrderException("Please, repaet the procedure of order creating again");
        }
        orders.add(new Order(id, client, amount, addressFrom, addressTo));
        return true;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {

    }

    @Override
    public List showOrders(Long from, Long to) {
        List<Client> list = new ArrayList<>();

        return null;
    }

    @Override
    public List showOrdersByPortion() {
        return null;
    }
}