package taxi.Action;

/**
 * Created by Юлия on 22.01.2016.
 */
class Authentification {
    Registration registration=new Registration();
    public boolean isClientExist(String login){
        return registration.isExist(login);
    }
    public boolean isAuthentified(String login, String password){
        if (registration.isExist(login)) {
            String [] data= registration.getClientsData(login);
            if(data[0].equals(password)){
                return true;
            }
            return true;
        }
        return false;
    }

}


