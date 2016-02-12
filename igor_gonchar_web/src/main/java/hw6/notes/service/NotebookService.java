package hw6.notes.service;

import java.util.Date;
import java.util.List;

/**
 * Created by i.gonchar on 2/10/2016.
 */
public interface NotebookService {
    boolean deleteByModel(String model);
    List findByVendor(String vendor);
    List findByPriceManufDate(Double price, Date date);
    List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
}
