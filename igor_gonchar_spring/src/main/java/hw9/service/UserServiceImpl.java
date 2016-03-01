package hw9.service;

import hw7.dao.CPUDao;
import hw9.dao.UserDao;
import hw9.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * Created by i.gonchar on 2/29/2016.
 */
@Scope("singleton")
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = true)
    private UserDao userDao;

    public UserServiceImpl() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        if (user == null) return false;
        return userDao.update(user);
    }

    @Override
    @Transactional
    public boolean removeUser(User user) {
        if (user == null) return false;
        return userDao.delete(user);
    }

    @Override
    @Transactional
    public Long createUser(User user) {
        if (user == null) return null;
        return userDao.createUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List getAllUsers() {
        return userDao.findAll();
    }
}
