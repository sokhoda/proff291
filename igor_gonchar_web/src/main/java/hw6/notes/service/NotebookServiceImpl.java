package hw6.notes.service;

import java.util.Date;
import java.util.List;

/**
 * Created by i.gonchar on 2/10/2016.
 */
public class NotebookServiceImpl implements NotebookService {
    @Override
    public boolean deleteByModel(String model) {
        return false;
    }

    @Override
    public List findByVendor(String vendor) {
        return null;
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        return null;
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return null;
    }
}
