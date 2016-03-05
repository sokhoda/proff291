package hw9.taxi.service;

import javax.naming.AuthenticationException;

/**
 * Created by Юлия on 02.03.2016.
 */
public interface AuthorizationService {
    boolean register(String login, String id,String pass) throws AuthenticationException;

}
