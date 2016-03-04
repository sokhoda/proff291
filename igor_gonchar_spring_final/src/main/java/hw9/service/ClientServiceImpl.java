package hw9.service;

import hw9.dao.ClientDao;
import hw9.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * Created by i.gonchar on 3/3/2016.
 */
@Scope("singleton")
@Service("clientService")
public class ClientServiceImpl implements ClientService{

    @Autowired(required = true)
    private ClientDao clientDao;

    public ClientServiceImpl() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    @Transactional
    public Long createClient(Client client) {
        if(client == null) return null;
        return clientDao.create(client);
    }

    @Override
    @Transactional
    public boolean updateClient(Client client) {
        if(client == null) return false;
        return clientDao.update(client);
    }

    @Override
    @Transactional
    public boolean removeClient(Client client) {
        if(client == null) return false;
        return clientDao.delete(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List getAllClients() {
        return clientDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClientByNameAndPhone(String name, String phone) {
        return clientDao.findByNameAndPhone(name, phone);
    }
}
