package hw9.taxi.service;

import hw9.taxi.exception.AuthenticationException;

/**
 * Created by Solyk on 01.03.2016.
 */
public interface AuthorizationService {

    boolean register(String login, String id, String pass) throws AuthenticationException;
}
