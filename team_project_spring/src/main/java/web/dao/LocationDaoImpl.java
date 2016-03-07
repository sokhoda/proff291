package web.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import web.domain.Location;
import java.util.List;

/**
 * Created by lenchi on 06.03.16.
 */
public class LocationDaoImpl implements  LocationDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public List<Location> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Location.class).list();
    }

    @Override
    public List findByPortion(int page, int size) {
            Session session = factory.getCurrentSession();
            Query query = session.createQuery("from Location");
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return (List<Location>)query.list();
    }
}
