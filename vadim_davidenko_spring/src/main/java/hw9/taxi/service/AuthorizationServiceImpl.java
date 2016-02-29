package hw9.taxi.service;

import hw9.taxi.dao.UserDao;
import hw9.taxi.domain.User;
import hw9.taxi.exception.AuthenticationException;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * Created by Вадим on 28.02.2016.
 */

@Service
@Scope("singleton")
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private UserDao userDao;

    public AuthorizationServiceImpl() {
        Locale.setDefault(Locale.ENGLISH);
    }

    public boolean register(String login, String id, String pass)
            throws AuthenticationException {
        if (userDao.findByLogin(login) != null) {
            throw new AuthenticationException("User with such login already exists");
        } else {
            User newUser = new User(login, id, pass);
            if (!userDao.create(newUser).equals(0L)) return true;
        }
        return false;
    }
}
