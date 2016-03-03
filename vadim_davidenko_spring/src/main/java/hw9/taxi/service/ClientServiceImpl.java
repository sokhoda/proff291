package hw9.taxi.service;

import hw9.taxi.dao.ClientDao;
import hw9.taxi.domain.User;
import hw9.taxi.exception.AuthenticationException;
import hw9.taxi.exception.ClientException;
import hw9.taxi.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * Created by Вадим on 28.02.2016.
 */

@Service
@Scope("singleton")
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    private static int pageCounter = -1;

    public ClientServiceImpl() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @SuppressWarnings("unchecked")
    public boolean createClient(String name, String surname, String phone, String address)
            throws ClientException {
        Client newClient = new Client(name, surname, phone, address);
        List<Client> clients = (List<Client>) clientDao.findAll();

        if (clients.contains(newClient)) {
            throw new ClientException("Client with such data already exists");
        } else {
            if (!clientDao.create(newClient).equals(0L)) return true;
        }
        return false;
    }

    @Transactional (readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Client> showClientsByPortion(int portionSize) {
        if (portionSize == 0) {
            pageCounter = -1;
            return null;
        } if (portionSize < 0) {
            if (pageCounter > 0) pageCounter--;
        } else {
            pageCounter++;
        }
        return clientDao.findByPortion(pageCounter, Math.abs(portionSize));
    }

    @Transactional (readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Client> showClientsGtSum(int sum) {
        return clientDao.findGtSum(sum);
    }

    @Transactional (readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Client> showClientsLastMonth() {
        return clientDao.findLastMonth();
    }

    @Transactional (readOnly = true)
    public Client findClientById(Long id) {
        return clientDao.read(id);
    }

    @Transactional (readOnly = true)
    public List findAllClients() {
        return clientDao.findAll();
    }
}
