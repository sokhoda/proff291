package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Solyk on 08.02.2016.
 */
public class NotebookServiceImpl implements NotebookService{

    private NotebookDao notebookDao = new NotebookDaoImpl();

    public NotebookServiceImpl(){

    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public List findAll() {
        return notebookDao.findAll();
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook tmp = notebookDao.read(id);
        tmp.setPrice(price);
        notebookDao.update(tmp);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook tmp = notebookDao.read(id);
        tmp.setSerialNumber(serial);
        tmp.setVendor(vendor);
        notebookDao.update(tmp);
    }

    @Override
    public boolean delete(Long id) {
        return notebookDao.delete(notebookDao.read(id));
    }

    @Override
    public boolean deleteByModel(String model) {

        List<Notebook> tmp = notebookDao.findByModel(model);
        if(tmp != null) {
            for (int i = 0; i < tmp.size(); i++) {
                notebookDao.delete(tmp.get(i));
            }
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List findByVendor(String vendor) {
                return notebookDao.findByVendor(vendor);
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        return notebookDao.findByPriceManufDate(price,date);
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return notebookDao.findBetweenPriceLtDateByVendor(priceFrom,priceTo,date,vendor);
    }

    public NotebookDao getNotebookDao() {
        return notebookDao;
    }
}
