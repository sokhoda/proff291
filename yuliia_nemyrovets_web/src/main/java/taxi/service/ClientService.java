package taxi.service;

import taxi.exception.ClientException;

import java.util.List;

/**
 * Created by Юлия on 19.01.2016.
 */
public interface ClientService {

    boolean createClient(String name, String surname, String phone, String address) throws ClientException;

    List showClientsByPortion(int portionSize);

    List showClientsGtSum(int sum);

    List showClientsLastMonth();
}

