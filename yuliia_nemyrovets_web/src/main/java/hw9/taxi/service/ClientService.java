package hw9.taxi.service;

import hw9.taxi.exception.ClientException;

import java.util.List;

/**
 * Created by Юлия on 02.03.2016.
 */
public interface ClientService {

    boolean createClient(String name, String surname, String phone, String address) throws ClientException;

    List ShowClientsByPortion(int portionsize);

    List ShowClientsGtSum(int sum);

    List ShowClientsLastMonth();
}
