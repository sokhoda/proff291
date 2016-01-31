package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by v.davidenko on 29.01.2016.
 */
public class ClientServiceImpl implements ClientService {

    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {

        return true;
    }

    public List<Client> showClientsByPortion(int portionSize) {
        List<Client> list = new LinkedList<Client>();


        return list;
    }

    public List<Client> showClientsGtSum(int sum) {
        List<Client> list = new LinkedList<Client>();


        return list;
    }

    public List<Client> showClientsLastMonth() {
        List<Client> list = new LinkedList<Client>();


        return list;
    }
}
