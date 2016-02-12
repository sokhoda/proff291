***************************************
Регистрация заказов и клиентов такси
****************************************

Функции:
-------------------
- оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
- отредактировать заказ (поменять свойства заказа)
- вывести список заказов на сумму в указанном диапазоне
- вывести список всех заказов порциями по 5 штук

- зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
- вывести всех клиентов порциями по 10 человек
- вывести всех клиентов наездивших на сумму больше указанной
- вывести всех клиентов, делавших заказы за последний месяц

Пакеты.классы:
-------------------
hw8.taxi.domain.Order
hw8.taxi.domain.Client

hw8.taxi.service.OrderServiceImpl
hw8.taxi.service.ClientServiceImpl

hw8.taxi.action.OrderServlet
hw8.taxi.action.ClientServlet

hw8.taxi.exception.OrderException
hw8.taxi.exception.ClientException

Интерфейсы:
--------------------
OrderService
	boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException
	void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo)
	List showOrders(Long from, Long to)
	List showOrdersByPortion()

ClientService
	boolean createClient(String name, String surname, String phone, String address) throws ClientException
	List showClientsByPortion(int portionSize)
	List showClientsGtSum(int sum)
	List showClientsLastMonth()

webapp
--------------------
index.jsp
dashboard.jsp - страница со списком функций (доступна после аутентификации)
order.jsp - форма оформления/редактирования заказа
registerClient.jsp - форма создания клиента
orders.jsp - список заказов
clients.jsp - список клиентов

