package hw9.taxi.service;

import hw9.taxi.dao.OrderDao;
import hw9.taxi.domain.Client;
import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Вадим on 28.02.2016.
 */

@Service
@Scope("singleton")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    private static int pageCounter = -1;

    public OrderServiceImpl() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @SuppressWarnings("unchecked")
    public boolean createOrder(Client client, Double amount, String addressFrom, String addressTo)
            throws OrderException {
        Order newOrder = new Order(client, new Date(), amount, addressFrom, addressTo);
        List<Order> orders = (List<Order>) orderDao.findAll();

        if (orders.contains(newOrder)) {
            throw new OrderException("Order with such data already exists");
        } else {
            if (!orderDao.create(newOrder).equals(0L)) return true;
        }
        return false;
    }

    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
        //Order order = orderDao.read(id);
        Order order = new Order();
        order.setId(id);
        order.setClient(client);
        order.setAmount(Double.parseDouble(amount));
        order.setAddressFrom(addressFrom);
        order.setAddressTo(addressTo);

        orderDao.update(order);
    }

    @Transactional (readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Order> showOrdersBetweenSumRange(int sumFrom, int sumTo) {
        return orderDao.findBetweenSumRange(sumFrom, sumTo);
    }

    @Transactional (readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Order> showOrdersByPortion(int portionSize) {
        if (portionSize == 0) {
            pageCounter = -1;
            return null;
        } if (portionSize < 0) {
            if (pageCounter > 0) pageCounter--;
        } else {
            pageCounter++;
        }
        return orderDao.findByPortion(pageCounter, Math.abs(portionSize));
    }
}
