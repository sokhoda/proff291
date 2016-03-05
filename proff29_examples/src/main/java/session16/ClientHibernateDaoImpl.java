//package session16;
//
//import org.apache.log4j.Logger;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * User: al1
// * Date: 18.05.13
// */
////@Repository
////@Transactional
////public class ClientHibernateDaoImpl implements ClientDao {
////    private static Logger log = Logger.getLogger(ClientHibernateDaoImpl.class);
////
////    @Autowired
////    private SessionFactory factory;
////
////    public ClientHibernateDaoImpl() {
////    }
////
////    @Override
////    public void create(Client client) {
////        factory.getCurrentSession().save(client);
////    }
////
////    @Override
////    @Transactional(readOnly = true)
//    public Client read(Long id) {
//        return (Client)factory.getCurrentSession().get(Client.class, id);
//    }
//
//    @Override
//    public void update(Client client) {
//        factory.getCurrentSession().save(client);
//    }
//
//    @Override
//    public void delete(Client client) {
//        factory.getCurrentSession().save(client);
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public List<Client> findAll() {
//        Session session = factory.getCurrentSession();
//        Query query = session.createQuery("from Client");
//        return query.list();
//    }
//
//    @Override
//    public List<Client> findMonyGT(long amount) {
//        return null;
//    }
//}
