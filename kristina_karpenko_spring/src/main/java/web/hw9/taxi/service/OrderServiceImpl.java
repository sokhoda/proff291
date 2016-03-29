package web.hw9.taxi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.hw9.taxi.dao.OrderDao;
import web.hw9.taxi.domain.*;
import web.hw9.taxi.exception.OrderException;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier("orderDao")
    protected OrderDao orderDao;

    @Autowired
    @Qualifier("clientService")
    protected ClientService clientService;

    @Transactional
    @Override
    public boolean createOrder(Client client, Double amount, String addressFrom, String addressTo) throws OrderException {
        orderDao.create(new Order(client,amount,addressFrom,addressTo));
        client.plusSum(amount);
        return true;
    }

    @Override
    @Transactional
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
    Order order = orderDao.read(id);
        clientService.addAmount(order.getClient(),order.getAmount()*-1);
        order.setClient(client);
        order.setAddressTo(addressTo);
        order.setAddressFrom(addressFrom);
        order.setAmount(Double.parseDouble(amount));
        clientService.addAmount(client,Double.parseDouble(amount));
        orderDao.update(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List showOrdersSum(double min, double max) {
        return orderDao.showOrdersSum(min, max);
    }

    @Override
    @Transactional(readOnly = true)
    public List showOrdersByPortion(int page, int portionSize) {
        return orderDao.showOrdersByPortion(page,portionSize);
    }
}

