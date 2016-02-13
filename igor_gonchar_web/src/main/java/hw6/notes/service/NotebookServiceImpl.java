package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by i.gonchar on 2/10/2016.
 */
public class NotebookServiceImpl implements NotebookService {

    private NotebookDao notebookDao;

    public NotebookServiceImpl(NotebookDao notebookDao){
        this.notebookDao = notebookDao;
    }


    @Override
    public boolean deleteByModel(String model) {
        Notebook notebook = new Notebook();
        return notebookDao.delete(notebook);
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
