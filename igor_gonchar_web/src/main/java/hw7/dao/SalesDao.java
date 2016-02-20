package hw7.dao;

import hw7.domain.Sales;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public interface SalesDao {
    public Long create(Sales sales);

    public Sales read(Long id);

    public boolean update(Sales sales);

    public boolean delete(Sales sales);

    public List findall();
};
