package hw9.taxi.service;

import hw9.taxi.dao.UserDao;
import hw9.taxi.exception.AuthentificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;

/**
 * Created by Юлия on 02.03.2016.
 */
@Service("auth")
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService{

    @Autowired
    private UserDao userDao;

    @Override
    public boolean register(String login, String id, String pass) throws AuthenticationException {
        return false;
    }
}
