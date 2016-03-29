package web.hw9.taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.hw9.taxi.dao.ClientDao;
import web.hw9.taxi.domain.Client;
import web.hw9.taxi.exception.OrderException;

import java.util.List;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    @Qualifier("clientDao")
    ClientDao clientDao;

    @Override
    @Transactional
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException {
        if(!clientDao.isPresent(name,surname)){return false;}
        else{
            clientDao.create(new Client(name,surname,address,phone));
            return true;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List showClientsByPortion(int size, int portionSize) {
        return clientDao.showClientsByPortion(size,portionSize);
    }

    @Override
    @Transactional(readOnly = true)
    public List showClientsGtSum(double sum) {
        return clientDao.showClientsGtSum(sum);
    }

    @Override
    @Transactional(readOnly = true)
    public List showClientsLastMonth() {
        return clientDao.showClientsLastMonth();
    }

    @Override
    @Transactional(readOnly = true)
    public Client findClientByPhone(String phone) {
        return clientDao.findClientByPhone(phone);
    }

    @Override
    @Transactional
    public boolean addAmount(Client client, double sum) {
        client.plusSum(sum);
        return clientDao.update(client);
    }
}
