package web.hw9.taxi.service;

import web.hw9.taxi.dao.UserDao;
import web.hw9.taxi.dao.UserDaoImpl;
import web.hw9.taxi.domain.User;
import web.hw9.taxi.exception.AuthenticationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
//@SessionAttributes("id")
public class AuthorizationServiceImpl implements AuthorizationService {
    public static final Logger log = Logger.getLogger(AuthorizationService.class);
    User user;
    @Autowired
    private UserDao userDao = new UserDaoImpl();

    public AuthorizationServiceImpl() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    public boolean register(String login, String id, String pass) throws AuthenticationException {
        if(!userDao.isLogin(login)){
        user = new User(login, pass, id);
        userDao.create(user);
        return true;
    }
        return false;
    }


}
