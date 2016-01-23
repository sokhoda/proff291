package hw8.taxi.domain.servise;

import hw8.taxi.domain.exception.ClientException;
import java.util.*;

public interface ClientService {
     boolean createClient(String name, String surname, String phone, String address) throws ClientException;

    List showClientsByPortion(int portionSize);

    List showClientsGtSum(int sum);

    List showClientsLastMonth();
}



