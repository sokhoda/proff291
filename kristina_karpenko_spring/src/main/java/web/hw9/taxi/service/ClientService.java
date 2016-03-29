package web.hw9.taxi.service;

import web.hw9.taxi.domain.Client;
import web.hw9.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by Администратор on 11.03.2016.
 */
public interface ClientService {
    boolean createClient(String name, String surname, String phone, String address) throws OrderException;

    List showClientsByPortion(int size, int portionSize);

    List showClientsGtSum(double sum);

    List showClientsLastMonth();

    Client findClientByPhone(String phone);

    boolean addAmount(Client client, double sum);
}
