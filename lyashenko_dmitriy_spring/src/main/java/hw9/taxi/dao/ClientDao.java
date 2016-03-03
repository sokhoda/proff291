package hw9.taxi.dao;

import hw9.taxi.domain.Client;

import java.util.List;

/**
 * Created by Solyk on 02.03.2016.
 */
public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    boolean update(Client client);
    boolean delete(Client client);
    List findAll();
}
