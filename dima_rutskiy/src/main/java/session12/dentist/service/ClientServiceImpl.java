package session12.dentist.service;


import session12.dentist.dao.ClientDao;
import session12.dentist.domain.Client;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class ClientServiceImpl implements ClientService {
    private ClientDao userDao;

    public ClientServiceImpl(ClientDao dao) {
        userDao = dao;
    }

    @Override
    public List<Client> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void addNewUser(Client user) {
        userDao.create(user);
    }
}
