package hw8.taxi.service;

import hw8.taxi.domain.Order;
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

    public List showClientsByPortion(int portionSize) {
        List<Order> list = new LinkedList<>();


        return list;
    }

    public List showClientsGtSum(int sum) {
        List<Order> list = new LinkedList<>();


        return list;
    }

    public List showClientsLastMonth() {
        List<Order> list = new LinkedList<>();


        return list;
    }
}
