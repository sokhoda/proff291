package hw9.taxi.service;

import hw9.taxi.exception.AuthenticationException;

/**
 * Created by s_okhoda on 03.03.2016.
 */
public class AuthorizationServiceImpl implements AuthorizationService {
    @Override
    public boolean register(String login, String id, String pass) throws AuthenticationException {
        return false;
    }
}
