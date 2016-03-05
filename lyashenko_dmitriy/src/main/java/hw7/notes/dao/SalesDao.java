package hw7.notes.dao;

import java.util.List;
import java.util.Map;

import hw7.notes.domain.Sales;

/**
 * Created by Admin on 17.02.2016.
 */
public interface SalesDao {
    Long create(Sales sales);
    Sales read(Long ig);
    boolean update(Sales sales);
    boolean delete(Sales sales);
    List findAll();
    Map getSalesByDays();
}
