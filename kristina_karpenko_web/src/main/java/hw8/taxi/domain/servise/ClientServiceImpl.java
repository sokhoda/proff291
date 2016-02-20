package hw8.taxi.domain.servise;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.exception.ClientException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    protected static List<Client> clients  = new ArrayList<>();

    public static List getClients() {
        return new ArrayList<>(clients);
    }

    //- зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
    public boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        if (clients != null) {
            for (Client cl : clients) {
                if (cl.getName().equals(name) && cl.equals(surname) && cl.getAddress().equals(address)) {
                    return false;
                } else {
                    clients.add(new Client(name, surname, phone, address));
                    return true;
                }
            }
        }
        clients.add(new Client(name, surname, phone, address));
        return true;

    }

    // - вывести всех клиентов порциями по 10 человек
    public List showClientsByPortion(int portionSize) {
        if(clients.size() == 0){
            return null;
        }
        List<Client> subClients = new ArrayList<>();
        System.arraycopy(clients, 0, subClients,0, portionSize-1);
      //  subClients.addAll(clients);
        return subClients;
    }

    //- вывести всех клиентов наездивших на сумму больше указанной
    public List showClientsGtSum(int sum) {
        List<Client> subClients = new ArrayList<>();
        Client client = new Client();
        if (client.getSum() >= sum) {
            subClients.add(client);
        }
        return subClients;
    }

    //- вывести всех клиентов, делавших заказы за последний месяц
    public List showClientsLastMonth() {
        Client client = new Client();
        List<Client> subClients = new ArrayList<>();

        LocalDate curr = LocalDate.now();
        LocalDate lastMonth = curr.minusDays(30);

        Iterator<Client> iter = clients.iterator();
        while (iter.hasNext()) {
            if (client.getDateLastOrder().isAfter(lastMonth)) {
                subClients.add(client);
            }
            iter.next();
        }
        return subClients;
    }
}
