package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

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
public interface NotebookService {

    Long add(Notebook notebook);

    void changePrice(Long id, double price);

    void changeSerialVendor(Long id, String serial, String vendor);


    boolean delete(Long id);

    boolean deleteByModel(String model);


    List findAll();

    List findByVendor(String vendor);

    List findByPriceManufDate(Double price, Date date);

    List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
}
