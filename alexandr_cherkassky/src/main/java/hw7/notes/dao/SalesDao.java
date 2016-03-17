package hw7.notes.dao;

import hw7.notes.domain.Sales;

import java.util.List;

/**
 * Created by Пк2 on 17.03.2016.
 */
public interface SalesDao {
    Long create(Sales sales);
    Sales read(Long ig);
    boolean update(Sales sales);
    boolean delete(Sales sales);
    List findAll();
}
