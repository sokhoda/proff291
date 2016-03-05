package hw9.taxi.service;

import hw9.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by Solyk on 02.03.2016.
 */
public interface ClientService {
    boolean createClient(String name, String surname, String phone, String address) throws OrderException;
    List showClientsByPortion(int portionSize);
    List showClientsGtSum(int sum);
    List showClientsLastMonth();

}
