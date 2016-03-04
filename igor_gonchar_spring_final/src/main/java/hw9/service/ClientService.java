package hw9.service;

import hw9.domain.Client;

import java.util.List;

/**
 * Created by i.gonchar on 3/3/2016.
 */
public interface ClientService {
    boolean updateClient(Client client);
    boolean removeClient(Client client);
    Long createClient(Client client);
    List getAllClients();
    Client getClientByNameAndPhone(String name, String phone);
}
