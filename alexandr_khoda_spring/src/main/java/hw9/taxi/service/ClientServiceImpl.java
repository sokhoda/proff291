package hw9.taxi.service;

import hw9.taxi.exception.OrderException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * Created by s_okhoda on 20.01.2016.
 */
@Transactional
@Service
public class ClientServiceImpl implements ClientService{
    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException {
        return false;
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
}
