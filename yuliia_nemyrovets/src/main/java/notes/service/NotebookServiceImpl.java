package notes.service;

import notes.dao.NotebookDao;
import notes.domain.Notebook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by Юлия on 12.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {

    NotebookDao ndao;
    Notebook notebook;

    public NotebookServiceImpl(NotebookDao ndao) {

        this.ndao = ndao;
    }

    @Override
    public Long create(Notebook notebook) {
        return ndao.create(notebook);
    }

    @Override
    public List findAll() {
        return ndao.findAll();
    }

    @Override
    public void changePrice(Long id, double price) {
        notebook = ndao.read(id);
        if (notebook != null) {
            notebook.setPrice(price);
            ndao.update(notebook);
        }
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        notebook = ndao.read(id);
        if (notebook != null) {
            notebook.setSerial(serial);
            notebook.setVendor(vendor);
            ndao.update(notebook);
        }
    }

    @Override
    public boolean delete(Long id) {
        notebook = ndao.read(id);
        if (notebook != null) {

            return ndao.delete(notebook);
        }
        return false;
    }

    @Override
    public boolean deleteByModel(String model) {
        List<Notebook> list = ndao.findByModel(model);
        if (list != null || !list.isEmpty()) {
            for (Notebook notebook : list) {
                return ndao.delete(notebook);
            }
            return true;
        }

        return false;
    }

    @Override
    public List findByVendor(String vendor) {
        return ndao.findByVendor(vendor);
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        return ndao.findByPriceManufDate(price, date);
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return ndao.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
    }
}