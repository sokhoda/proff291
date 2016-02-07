package session12.dentist;

import org.hibernate.SessionFactory;
import session12.dentist.dao.ClientDao;
import session12.dentist.dao.ClientHibernateDaoImpl;
import session12.dentist.service.ClientService;
import session12.dentist.service.ClientServiceImpl;
import session12.dentist.utils.HibernateUtil;
import session12.dentist.view.Menu;


/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class Main {
    public static void main(String[] args) {
        // !! IMPORTANT !! this is only example of structure
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        ClientDao clientDao = new ClientHibernateDaoImpl(sessionFactory);
        ClientService clientService = new ClientServiceImpl(clientDao);

        Menu menu = new Menu(clientService);
        menu.main();
    }
}
