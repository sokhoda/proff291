package session12.dao;

import session11.User;

import java.util.List;

/**
 * Created by s_okhoda on 07.02.2016.
 */
public interface UserDAO  {
    List findUserExceptThis(String login, String pass);
    long count(long id);
    List finUserByPortion(int startInx, int portionSize);


}
