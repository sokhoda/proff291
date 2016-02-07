package session12.dentist.service;



import session12.dentist.domain.Client;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 25.05.13
 */
public interface ClientService {
    List<Client> getAllUsers();
    void addNewUser(Client user);
}
