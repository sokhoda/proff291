package hw8.taxi.domain.servise;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.domain.exception.OrderException;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

/*- оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
- отредактировать заказ (поменять свойства заказа)
- вывести список заказов на сумму в указанном диапазоне
- вывести список всех заказов порциями по 5 штук*/
public class OrderServiceImpl implements OrderService {
    static List<Order> orders = new ArrayList<>();

    public List getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        if (!ClientServiceImpl.clients.contains(client)) return false;
        else {
            orders.add(new Order(id, client, amount, addressFrom, addressTo));
            return true;
        }
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
        for (Order cl : orders) {
            if (id.equals(cl.getDateOrder())) {
                cl.setClient(client);
                cl.setAmount(amount);
                cl.setAddressFrom(addressFrom);
                cl.setAddressTo(addressTo);
            }
        }
    }

    @Override
    public List showOrders(Long from, Long to) {
        List<Order> subOrder = new ArrayList<>();
        for (Order or : orders) {
            if (Integer.parseInt(or.getAmount()) >= from && Integer.parseInt(or.getAmount()) <= to) {
                subOrder.add(or);
            }
        }
        return subOrder;
    }

    @Override
    public List showOrdersByPortion() {
        List<Order> subOrder = new ArrayList<>();
        return null;
    }
}
