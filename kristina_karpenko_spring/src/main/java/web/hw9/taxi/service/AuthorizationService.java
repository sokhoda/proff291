package web.hw9.taxi.service;

import web.hw9.taxi.exception.AuthenticationException;

/**
 * Created by Администратор on 01.03.2016.
 */
public interface AuthorizationService {

    boolean register(String login, String id, String pass) throws AuthenticationException ;
}
