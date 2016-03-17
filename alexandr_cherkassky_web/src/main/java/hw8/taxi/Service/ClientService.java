package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пк2 on 26.02.2016.
 */
public interface ClientService {
    boolean createClient(String name, String surname, String phone, String address) throws ClientException;
    List showClientsByPortion(int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();
    ArrayList<Client> showAllClients();
}
