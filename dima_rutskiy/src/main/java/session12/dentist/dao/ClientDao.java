package session12.dentist.dao;



import session12.dentist.domain.Client;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public interface ClientDao {
    Long create(Client user);
    Client read(Long id);
    void update(Client client);
    void delete(Client client);
    List<Client> findAll();
    List<Client> findMonyGT(long amount);
}
