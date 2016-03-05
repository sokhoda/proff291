package hw9.service;

import hw9.dao.ClientDao;
import hw9.dao.OrderDao;
import hw9.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
    public Long createUser(Order order) {
        if(order == null) return null;
        return orderDao.create(order);
    }

    @Override
    public boolean updateUser(Order order) {
        return orderDao.update(order);
    }

    @Override
    public boolean removeUser(Order order) {
        if(order == null) return false;
        return orderDao.delete(order);
    }

    @Override
    public List getAllUsers() {
        return orderDao.findAll();
    }
}
