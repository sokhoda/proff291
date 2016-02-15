package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Вадим on 07.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {

    private NotebookDao notebookDao;

    public NotebookServiceImpl(NotebookDao notebookDao) {
        this.notebookDao = notebookDao;
    }

    public NotebookServiceImpl() {
        notebookDao = new NotebookDaoImpl();
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook note = notebookDao.read(id);
        if (note != null) {
            note.setPrice(price);
            notebookDao.update(note);
        }
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook note = notebookDao.read(id);
        if (note != null) {
            note.setSerial(serial);
            note.setVendor(vendor);
            notebookDao.update(note);
        }
    }


    @Override
    public boolean delete(Long id){
        Notebook note = notebookDao.read(id);
        boolean isDeleted = false;
        if (note != null) {
            isDeleted = notebookDao.delete(note);
        }
        return isDeleted;
    }

    @Override
    public boolean deleteByModel(String model) {
        List<Notebook> notes = notebookDao.findByModel(model);
        boolean isDeleted = false;
        if (notes != null && !notes.isEmpty()) {
            for (Notebook note : notes) {
                isDeleted = notebookDao.delete(note);
                if (!isDeleted) break;
            }
        }
        return isDeleted;
    }


    @Override
    public List<Notebook> findAll() {
        return notebookDao.findAll();
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return notebookDao.findByVendor(vendor);
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return notebookDao.findByPriceManufDate(price, date);
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return notebookDao.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
    }
}
