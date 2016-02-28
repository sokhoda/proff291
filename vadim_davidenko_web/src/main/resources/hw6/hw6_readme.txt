**********************************************
Задание 6 (12-е занятие)
Справочник ноутбуков
**********************************************
- Добавить новый ноутбук
- Изменить цену ноутбука по id
- Изменить серийный номер и производителя по id
- Удалить ноутбук по id
- Удалить ноутбуки по названию модели
- Показать список ноутбуков (включая порядковый номер id)
- Получить ноутбуки по производителю
- Получить ноутбуки по цене и году выпуска
- Получить ноутбуки по цене в указанном диапазоне, меньше указанной даты выпуска и указанного производителя

1. DAO для ноутбуков
******************************
Создать DAO для таблицы ноутбуки
Таблица ноутбуки имеет следующую структуру
(id, serial, vendor, model, manufacture date, price)
domain
hw6.Notebook
dao
hw6.NotebookDao
Long create(Notebook ntb)
Notebook read(Long ig)
boolean update(Notebook ntb)
boolean delete(Notebook ntb)
List findAll()
hw6.NotebookDaoImpl

2. Заготовка справочника
********************************
Написать приложение для управления ноутбуками.
Реализовать функции:
- Добавить новый ноутбук
- Показать список ноутбуков (включая порядковый номер id)
domain
hw6.Notebook
dao
hw6.NotebookDao
Long create(Notebook notebook)
Notebook read(Long id)
boolean update(Notebook notebook)
boolean delete(Notebook notebook)
List findAll()
hw6.NotebookDaoImpl
util
hw6.HibernateUtil
service
hw6.NotebookService
Long add(Notebook notebook)
List findAll()
hw6.NotebookServiceImpl
view
hw6.Menu
main()

3. Справочник ноутбуков
*******************************
Добавить в приложение ноутбуков следующие функции:
- Удалить ноутбук по id
- Изменить цену ноутбука по id
- Изменить серийный номер и производителя по id
domain
hw6.Notebook
dao
hw6.NotebookDao
Long create(Notebook notebook)
Notebook read(Long id)
boolean update(Notebook notebook)
boolean delete(Notebook notebook)
List findAll()
hw6.NotebookDaoImpl
util
hw6.HibernateUtil
service
hw6.NotebookService
Long add(Notebook notebook)
List findAll()
void changePrice(Long id, double price)
void changeSerialVendor(Long id, String serial, String vendor)
boolean delete(Long id)
hw6.NotebookServiceImpl
view
hw6.Menu
main()
void deleteNtb(Notebook notebook)
void changePrice(Notebook notebook)
void changeSerialVendor(Notebook notebook)

4. Расширение справочника
****************************
Добавить в приложение ноутбуков следующие функции:
- Удалить ноутбуки по названию модели
- Получить ноутбуки по производителю
- Получить ноутбуки по цене и году выпуска
- Получить ноутбуки по цене в указанном диапазоне, меньше указанной даты выпуска и указанного производителя

domain
hw6.Notebook
dao
hw6.NotebookDao
List findByModel(String model)
List findByVendor(String vendor)
List findByPriceManufDate(Double price, Date date)
List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor)
hw6.NotebookDaoImpl
util
hw6.HibernateUtil
service
hw6.NotebookService
boolean deleteByModel(String model)
List findByVendor(String vendor)
List findByPriceManufDate(Double price, Date date)
List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor)
hw6.NotebookServiceImpl
view
hw6.Menu
main()
void deleteByModel()
void showByVendor()
void showByPriceManufDate(double price, Date manufDate)
void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, long vendorId)
