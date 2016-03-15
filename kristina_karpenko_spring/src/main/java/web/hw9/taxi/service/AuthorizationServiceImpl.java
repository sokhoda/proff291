package web.hw9.taxi.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import web.hw9.taxi.dao.UserDao;
import web.hw9.taxi.dao.UserDaoImpl;
import web.hw9.taxi.domain.User;
import web.hw9.taxi.exception.AuthenticationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    User user;
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao = new UserDaoImpl();

    public AuthorizationServiceImpl() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    @Transactional
    public boolean register(String login, String id, String pass) {
        if (userDao.isLogin(login)) {
            user = new User(login, pass, id);
            userDao.create(user);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean isLogin(String login){
        if(userDao.isLogin(login)){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean isUser(String login, String pass) {
        if(userDao.isUser(login,pass)){
            return true;
        }
        return false;
    }


}
