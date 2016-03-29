//package DeptsPage.locationDao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * Created by Пк2 on 06.03.2016.
// */
//public class LocationDaoImpl implements LocationDao {
//    @Autowired
//    SessionFactory factory;
//    @Override
//    public Location getLocationById(Long id) {
//        Session session=factory.getCurrentSession();
//        Location thisLocation=null;
//        try{
//            thisLocation=(Location)session.get(Location.class, id);
//        }catch(Exception e){
//            e.printStackTrace();
//        } finally{
//            session.close();
//        }
//        return null;
//    }
//}
