package hw6.notes.dao;

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
public interface NotebookDao {

    Long create(Notebook notebook);

    Notebook read(Long ig);

    boolean update(Notebook notebook);

    boolean delete(Notebook notebook);

    List findAll();

    List findByModel(String model);

    List findByVendor(String vendor);

    List findByPriceManufDate(Double price, Date date);

    List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
}
