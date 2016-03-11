package hw9.service;

import hw9.dao.ClientDao;
import hw9.dao.OrderDao;
import hw9.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * Created by i.gonchar on 3/3/2016.
 */
@Scope("singleton")
@Service("orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired(required = true)
    private OrderDao orderDao;

    public OrderServiceImpl() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    @Transactional
    public Long createOrder(Order order) {
        if(order == null) return null;
        return orderDao.create(order);
    }

    @Override
    @Transactional
    public boolean updateOrder(Order order) {
        return orderDao.update(order);
    }

    @Override
    @Transactional
    public boolean removeOrder(Order order) {
        if(order == null) return false;
        return orderDao.delete(order);
    }
    @Override
    @Transactional(readOnly = true)
    public Order getOrderByFromToAddress(String addressFrom, String addressTo){
       return orderDao.findByAddressFromAndTo(addressFrom, addressTo);
    }

    @Override
    @Transactional(readOnly = true)
    public List getAllOrders() {
        return orderDao.findAll();
    }
}
