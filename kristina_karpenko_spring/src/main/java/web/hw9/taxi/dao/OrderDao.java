package web.hw9.taxi.dao;

import org.aspectj.weaver.ast.Or;
import web.hw9.taxi.domain.Order;

import java.util.List;


public interface OrderDao {
    Long create(Order order);
    Order read(Long id);
    boolean update(Order order);
    boolean delete(Order order);
    List findAll();
    List showOrdersSum(double min, double max);
    List showOrdersByPortion(int page, int portionSize) ;
}
