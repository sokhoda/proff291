package web.hw9.taxi.dao;

import web.hw9.taxi.domain.Client;

import java.util.List;

public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    boolean update(Client client);
    boolean delete(Client client);
    List findAll();
    boolean isPresent(String name,String surName);
    List showClientsByPortion(int page,int portionSize);
    List showClientsGtSum(double sum);
    List showClientsLastMonth();
    Client findClientByPhone(String phone);
}
