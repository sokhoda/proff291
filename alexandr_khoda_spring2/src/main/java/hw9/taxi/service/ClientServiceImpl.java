package hw9.taxi.service;

import hw9.taxi.dao.ClientDao;
import hw9.taxi.domain.Client;
import hw9.taxi.exception.ClientException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by s_okhoda on 20.01.2016.
 */
@Transactional
@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private SessionFactory factory;
    @Autowired
    private ClientDao clientDao;

    public ClientServiceImpl() {
    }

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        Session session = factory.getCurrentSession();
        Client client = new Client(name, surname, phone, address);
        if (clientDao.checkExist(client)){
            throw new ClientException("Client \n" + client + "\n exists in DB" +
                    ".");
        }
        else {
            clientDao.create(client);
            return true;
        }

    }

    @Override
    public Client read(Long id) {
        return clientDao.read(id);
    }

    @Override
    public List showClientsByPortion(int portionSize) {
        return null;
    }

    @Override
    public List showClientsGtSum(int sum) {
        return null;
    }

    @Override
    public List showClientsLastMonth() {
        return null;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
}
