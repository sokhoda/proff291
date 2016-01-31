package hw8.taxi.service;

import hw8.taxi.exception.ClientException;
import java.util.List;

/**
 * Created by v.davidenko on 29.01.2016.
 *
 * Методы:
 * - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 * - вывести всех клиентов порциями по 10 человек
 * - вывести всех клиентов наездивших на сумму больше указанной
 * - вывести всех клиентов, делавших заказы за последний месяц
 */
public interface ClientService {

    public boolean createClient(String name, String surname, String phone, String address) throws ClientException;

    public List showClientsByPortion(int portionSize);

    public List showClientsGtSum(int sum);

    public List showClientsLastMonth();

}
