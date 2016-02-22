package session15;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

/**
 * Created by Сергей on 21.02.2016.
 */
public class EmployeeDao {

    private SessionFactory sf;

    public SessionFactory getSf() {
        return sf;
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    public void getAllEmployees () {
        Session session = null;

        try {
            session = sf.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee");
            List<Employee> users = query.list();
            for (int i=0;i<users.size();i++) {
                System.out.println(users.get(i));
            }

        } catch (HibernateException e) {
            if (session!=null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            sf.close();
        }

    }
}
