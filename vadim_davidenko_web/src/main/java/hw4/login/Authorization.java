package hw4.login;

/**
 * Created by Вадим on 17.01.2016.
 */
public class Authorization {

    private Registration usersBase = new Registration();

    public boolean isLoginCorrect(String userLogin) {
        return usersBase.isUserExist(userLogin);
    }

    public boolean isAuthorized(String userLogin, String password) {
        if(usersBase.isUserExist(userLogin)) {
            String[] userData = usersBase.getUserData(userLogin);
            if(userData[0].equals(password)){
                return true;
            }
        }
        return false;
    }

}
