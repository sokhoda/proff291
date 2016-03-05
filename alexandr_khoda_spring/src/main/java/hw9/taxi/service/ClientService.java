package hw9.taxi.service;

import hw9.taxi.exception.OrderException;

import java.util.*;

/**
 * Created by s_okhoda on 20.01.2016.
 */
public interface ClientService {

    boolean createClient(String name, String surname, String phone, String
            address) throws OrderException;
    List showClientsByPortion(int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();

}
