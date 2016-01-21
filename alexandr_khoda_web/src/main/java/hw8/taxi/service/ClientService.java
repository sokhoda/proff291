package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by s_okhoda on 20.01.2016.
 */
public class ClientService {
    private List<Client> clients = new ArrayList<Client>();
    public ClientService() {
    }



    public boolean createClient(String name, String surname, String phone,
                               String address) throws ClientException{
        if (name == null || surname == null || phone == null || address == null){
            throw  new ClientException("Client Data can not be NULL");
        }
        if (name.trim().length() == 0 || surname.trim().length() == 0 ||
                phone.trim().length() == 0){
            throw new ClientException("Client Data can not have ZERO LENGTH");
        }

        clients.add(new Client(name, surname, phone, address));
        return true;
    }

    public List showClientsByPortion(int portionSize){
        List<Client> list = new ArrayList<Client> ();
        if (portionSize == 0) return null;

        return clients;
    }
    public List showClientsGtSum(int sum){
        List<Client> list = new ArrayList<Client> ();

        return clients;
    }
    public List showClientsLastMonth(){
        List<Client> list = new ArrayList<Client> ();

        return clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
