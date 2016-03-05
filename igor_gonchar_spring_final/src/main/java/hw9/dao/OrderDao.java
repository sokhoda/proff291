package hw9.dao;

import hw9.domain.Order;

import java.util.List;

/**
 * Created by i.gonchar on 3/3/2016.
 */
public interface OrderDao {
    long create(Order order);
    boolean update(Order order);
    boolean delete(Order order);
    Order read(Long id);
    List findAll();
}
