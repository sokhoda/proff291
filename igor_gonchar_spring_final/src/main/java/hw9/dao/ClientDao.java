package hw9.dao;

import hw9.domain.Client;

import java.util.List;

/**
 * Created by i.gonchar on 3/3/2016.
 */
public interface ClientDao {
    long create(Client client);
    boolean update(Client client);
    boolean delete(Client client);
    Client read(Long id);
    List findAll();
    Client findByNameAndPhone(String name, String phone);
}
