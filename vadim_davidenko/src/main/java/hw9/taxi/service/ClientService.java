package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.ClientException;

import java.util.List;

/**
 * Created by Вадим on 28.02.2016.
 *
 * Функции:
 * - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 * - вывести всех клиентов порциями по 10 человек
 * - вывести всех клиентов наездивших на сумму больше указанной
 * - вывести всех клиентов, делавших заказы за последний месяц
 *
 */
public interface ClientService {

    boolean createClient(String name, String surname, String phone, String address) throws ClientException;

    void updateClient(Client client);

    List showClientsByPortion(int portionSize);

    List showClientsGtSum(int sum);

    List showClientsLastMonth();

    Client findClientById(Long id);

    List findAllClients();
}
