package hibernate.service;


import hibernate.dao.UserProcessDAO;
import hibernate.domain.UserProcess;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class UserProcessServiceImpl implements UserProcessService {

    private UserProcessDAO userDao;

    public UserProcessServiceImpl(UserProcessDAO dao) {
        userDao = dao;
    }

    @Override
    public List<UserProcess> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void addNewUser(UserProcess user) {
        userDao.create(user);
    }
}
