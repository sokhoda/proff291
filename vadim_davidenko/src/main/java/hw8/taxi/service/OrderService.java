package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;
import java.util.List;

/**
 * Created by v.davidenko on 29.01.2016.
 *
 * Методы:
 * - оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 * - отредактировать заказ (поменять свойства заказа)
 * - вывести список заказов на сумму в указанном диапазоне
 * - вывести список всех заказов порциями по 5 штук
 */
public interface OrderService {

    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;

    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);

    public List showOrders(Long from, Long to);

    public List showOrdersByPortion();

}
