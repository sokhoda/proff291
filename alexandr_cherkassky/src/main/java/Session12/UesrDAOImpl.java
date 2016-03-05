package Session12;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Пк2 on 07.02.2016.
 */
public class UesrDAOImpl  implements UsersDAO{
    //private static Logger log = Logger.getLogger(ClientHibernateDaoImpl.class);
    private SessionFactory factory;

    public UesrDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> selecAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Users u");
        return query.list();
    }


    }



