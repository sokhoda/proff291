package hw9.taxi.service;


import hw9.taxi.exception.ClientException;

import java.util.List;

/**
 * Created by Юлия on 02.03.2016.
 */
public class ClientServiceImpl implements ClientService  {
    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        return false;
    }

    @Override
    public List ShowClientsByPortion(int portionsize) {
        return null;
    }

    @Override
    public List ShowClientsGtSum(int sum) {
        return null;
    }

    @Override
    public List ShowClientsLastMonth() {
        return null;
    }
}
