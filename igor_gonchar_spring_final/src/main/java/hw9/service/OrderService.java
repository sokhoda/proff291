package hw9.service;

import hw9.domain.Order;

import java.util.List;

/**
 * Created by i.gonchar on 3/3/2016.
 */
public interface OrderService {
    boolean updateUser (Order order);
    boolean removeUser (Order order);
    Long createUser (Order order);
    List getAllUsers();
}
