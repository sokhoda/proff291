package hw9.taxi.service;

import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;
import hw9.taxi.domain.Client;

import java.util.List;

/**
 * Created by Вадим on 28.02.2016.
 *
 * Функции:
 * - оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 * - отредактировать заказ (поменять свойства заказа)
 * - вывести список заказов на сумму в указанном диапазоне
 * - вывести список всех заказов порциями по 5 штук
 *
 */
public interface OrderService {

    boolean createOrder(Client client, Double amount, String addressFrom, String addressTo) throws OrderException;

    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);

    List showOrdersBetweenSumRange(int sumFrom, int sumTo);

    List showOrdersByPortion(int portionSize);

    Order findOrderById(Long id);
}
