package hw6.notes.view;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.util.HibernateUtil;

import java.util.Date;

/**
 * Created by Вадим on 07.02.2016.
 *
 * - Добавить новый ноутбук
 * - Показать список ноутбуков (включая порядковый номер id)
 * - Удалить ноутбук по id
 * - Изменить цену ноутбука по id
 * - Изменить серийный номер и производителя по id
 * - Удалить ноутбуки по названию модели
 * - Получить ноутбуки по производителю
 * - Получить ноутбуки по цене и году выпуска
 * - Получить ноутбуки по цене в указанном диапазоне,
 *      меньше указанной даты выпуска и указанного производителя
 */

public class Menu {

    private NotebookService noteService;

    public Menu(NotebookService noteService) {
        this();
        this.noteService = noteService;
    }

    public Menu() {
        noteService = new NotebookServiceImpl(new NotebookDaoImpl(HibernateUtil.getSessionFactory()));
    }

    public void main() {

    }

    ////////////////////////////////////////////////////////////

    public void deleteNtb(Notebook notebook) {

    }

    public void changePrice(Notebook notebook) {

    }

    public void changeSerialVendor(Notebook notebook) {

    }

    public void deleteByModel() {

    }

    public void showByVendor() {

    }

    public void showByPriceManufDate(double price, Date manufDate) {

    }

    public void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, long vendorId) {

    }
}
