package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Пк2 on 11.02.2016.
 */
public interface NotebookService {
    public  Long add(Notebook notebook);
    public List findAll();
    public boolean delete(Long id);
    public void changePrice(Long id, double price);
    public void changeSerialVendor(Long id, String serial, String vendor);
    boolean deleteByModel(String model);
    List findByVendor(String vendor);
    List findByPriceManufDate(Double price, Date date);
    List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
    Notebook getNoteById(Long Id);
}
