package hw4.login;

/**
 * Created by Вадим on 17.01.2016.
 */
public class Authorization {

    public boolean isLoginCorrect(String userLogin) {
        return Registration.isUserExist(userLogin);
    }

    public boolean isAuthorized(String userLogin, String password) {
        if(Registration.isUserExist(userLogin)) {
            String[] userData = Registration.getUserData(userLogin);
            if(userData[0].equals(password)){
                return true;
            }
        }
        return false;
    }

}
