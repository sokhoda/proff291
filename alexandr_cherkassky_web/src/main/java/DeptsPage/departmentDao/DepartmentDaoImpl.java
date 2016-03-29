//package DeptsPage.departmentDao;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
///**
// * Created by Пк2 on 06.03.2016.
// */
//public class DepartmentDaoImpl implements DepartmentDao {
//    @Autowired
//    SessionFactory factory;
//
//    @Override
//    public List<Department> findDepts(int firstRes, int maxRes) {
//        Session session=factory.getCurrentSession();
//        List<Department> depts=null;
//        try{
//            Query query=session.createQuery("from Department");
//            query.setFirstResult(firstRes);
//            query.setMaxResults(maxRes);
//            depts=query.list();
//        } catch(Exception e){
//            e.printStackTrace();
//        } finally{
//            session.close();
//        }
//        return depts;
//    }
//
//    @Override
//    public void setDeptLocation(Department aDept, Location location) {
//        aDept.setCityName(location.getCityName);
//        aDept.setStreetAdress(location.getStreetAdress);
//    }
//
//    @Override
//    public void setdeptManager() {
//
//    }
//
//
//}
