package hw8.taxi.Service;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Пк2 on 23.01.2016.
 * Функции:
 * - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 * - вывести всех клиентов порциями по 10 человек
 * - вывести всех клиентов наездивших на сумму больше указанной
 * - вывести всех клиентов, делавших заказы за последний месяц
 *
 */
public class ClientServiceImpl implements ClientService {
    private int startIndx=0;
    private List<Client> clients;

    public ClientServiceImpl() {
        clients = new ArrayList<Client>();
    }
    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException{
        if (name == null || surname == null || phone == null || address == null) {
            throw new ClientException("fields must not be null");
        }

        if (name.length() == 0 || surname.length() == 0 || phone.length() == 0 || address.length() == 0) {
            throw new ClientException("fields must not have zero length");
        }

        if(clients.add( new Client(name, surname, phone, address))){
            return true;
        } else return false;
    }

    @Override
    public List showClientsByPortion(int portionSize){
        List<Client> clientsByPortion= new ArrayList<Client>();
        if(clients.isEmpty()){
            return null;
        } else {
            int left = clients.size() - startIndx;
            if (left > 0) {
                if (left > portionSize) {
                    for (int i = 0; i < portionSize; i++) {
                        clientsByPortion.add(clients.get(startIndx + i));
                    }
                    startIndx = startIndx + portionSize;
                } else {
                    for (int i = 0; i < left; i++) {
                        clientsByPortion.add(clients.get(startIndx + i));
                    }
                }
            }
            return clientsByPortion;
        }
    }

    @Override
    public List showClientsGtSum(int sum){
        if(clients.isEmpty()){
            return null;
        } else {
            List<Client> clientsBySum = new ArrayList<Client>();
            int index = 0;
            for (Client client : clients) {
                if (client.getOrderCost() >= sum) {
                    clientsBySum.add(client);
                }
            }
            //        while(index<clients.size()){
//            Client tmp=clients.get(index);
//            if(tmp.getOrderCost()>=sum){
//                clientsBySum.add(tmp);
//            }
//            index++;
//        }
            if(clientsBySum.isEmpty()){
                return null;
            } else {
                return clientsBySum;
            }
        }
    }

    @Override
    public List showClientsLastMonth(){
        if(clients.isEmpty()){
            return null;
        } else {
            List<Client> clientsByLastMonth = new ArrayList<Client>();
            GregorianCalendar curDate = new GregorianCalendar();
            for (Client client : clients) {
                if (client.getLastOrderDate().MONTH == curDate.MONTH && client.getLastOrderDate().YEAR == curDate.YEAR)
                    clientsByLastMonth.add(client);
            }
            if(clientsByLastMonth.isEmpty()){
                return null;
            } else {
                return clientsByLastMonth;
            }

        }
    }




}
