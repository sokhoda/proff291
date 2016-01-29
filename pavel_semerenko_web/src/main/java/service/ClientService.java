package service;

import models.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 21.01.2016.
 */
public class ClientService {
    List<Client> clientsList;

    public ClientService() {
        clientsList = new ArrayList<Client>();
        clientsList.add(new Client("name", "surname", "05023", "tar 2", 90, new Date(System.currentTimeMillis())));
    }

    List showClientsByPortion(int portionSize){
        List<Client> result = null;

        return result;
    }
    List showClientsGtSum(int sum){
        List<Client> result = null;

        return result;
    }
    List showClientsLastMonth(){
        List<Client> result = null;

        return result;
    }
}
