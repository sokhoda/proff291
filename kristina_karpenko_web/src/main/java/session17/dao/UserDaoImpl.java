package session17.dao;

import hw9.taxi.dao.UserDao;
import hw9.taxi.domain.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.dao.NotebookDaoImpl;

import java.util.List;

//@Repository("userDao")
@Repository
public class UserDaoImpl implements UserDao  {
    @Autowired(required = true)
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public UserDaoImpl(){}
    public UserDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;}

    protected Session getSession(){
        return factory.getCurrentSession();
    }

    @Override
    public Long create(User user) {
        return (Long) getSession().save(user);
    }

    @Override
    public User read(Long id) {
        return (User)getSession().get(User.class,id);
    }

    @Override
    public boolean update(User user) {
         getSession().update(user);
        return true;
    }

    @Override
    public boolean delete(User user) {
         getSession().delete(user);
        return true;
    }

    @Override
    public List findAll() {
        return (List<User>)getSession().createQuery("from hw9.taxi.domain.User u");
    }

    @Override
    public boolean isLogin(String login) {
        if(getSession().createQuery("from User u where u.login= :login").setParameter("login",login).uniqueResult()==null){
            return false;//если с таким логином нет в базе
        }
        return true;
    }
}
