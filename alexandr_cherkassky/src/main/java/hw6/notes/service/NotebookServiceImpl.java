package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.domain.Notebook;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Пк2 on 11.02.2016.
 */
public class NotebookServiceImpl implements NotebookService  {

    private NotebookDao noteDao=null;

    public NotebookServiceImpl(){};
    public NotebookServiceImpl(NotebookDao noteDao){
        this.noteDao=noteDao;
    }


    @Override
    public Long add(Notebook notebook) {
       return noteDao.create(notebook);
    }


    @Override
    public List findAll() {
        return noteDao.findAll();
    }

    @Override
    public boolean delete(Long id) {
        Notebook note=noteDao.read(id);
        boolean deleted=false;
        if(note!=null){
            deleted=noteDao.delete(note);
            return deleted;
        } else return deleted;
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook aNotebook=noteDao.read(id);
        aNotebook.setPrice(price);
        noteDao.update(aNotebook);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook aNotebook=noteDao.read(id);
        aNotebook.setSerial(serial);
        aNotebook.setVendor(vendor);
        noteDao.update(aNotebook);
    }

    @Override
    public boolean deleteByModel(String model) {
        List<Notebook> notes=noteDao.findByModel(model);
        if(notes!=null && !notes.isEmpty()) {
//            ListIterator<Notebook> iter = notes.listIterator();
//            while(iter.hasNext()){
//                noteDao.delete(iter.next());
//            }
            for(Notebook note:notes){
                noteDao.delete(note);
            }
            return true;
        }
        else return false;

    }

    @Override
    public List findByVendor(String vendor) {
        return noteDao.findByVendor(vendor);
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        return noteDao.findByPriceManufDate(price,date);
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return noteDao.findBetweenPriceLtDateByVendor(priceFrom,priceTo,date,vendor);
    }

    public Notebook getNoteById(Long Id){
        return noteDao.read(Id);
    }


}
