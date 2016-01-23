package taxi.service;

import taxi.domain.Client;
import taxi.exception.ClientException;

import java.util.*;

/**
 * Created by Юлия on 19.01.2016.
 * <p>
 * Учёт клиентов службы такси.
 * <p>
 * Функции:
 * - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 * - вывести всех клиентов порциями по 10 человек
 * - вывести всех клиентов наездивших на сумму больше указанной
 * - вывести всех клиентов, делавших заказы за последний месяц
 */
public class ClientServiceImpl implements ClientService {

    private List<Client> clients = new ArrayList<>();

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        if (name == null || surname == null || address == null || phone == null) {
            throw new ClientException("Your client was created uncorrect");
        }
        List<Client> list = new ArrayList<>();
        clients.add(new Client(name, surname, phone, address));
        return true;
    }

    @Override
    public List showClientsByPortion(int portionSize) {
        List<Client> list = new ArrayList<>();
        if (portionSize <= 0) {
            return null;
        }
        int count = 0;
        while (clients.size() != portionSize) {
            list.add(clients.get(count++));
        }
        return clients;
    }

    @Override
    public List showClientsGtSum(int sum) {
        List<Client> list = new ArrayList<>();
        for (Client client : clients) {
            if (client.getSumm() >= sum) {
                list.add(client);
            }
        }

        return list;
    }

    @Override
    public List showClientsLastMonth() {
        Date date = new Date();
        List<Client> list = new ArrayList<>();
        for (Client client : clients) {
            if (client.getDate().equals(date)) {
                list.add(client);
            }
        }


        return list;
    }
}
