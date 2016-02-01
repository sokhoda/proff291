package session8HomeTask;

/**
 * Created by Home on 31.01.2016.
 */
public class OperatorBase extends RegistrationBase {

    @Override
    public void addUser(String login, String password) {
        try {
            connectToBase();




        } finally {
            closeConnection();
        }
    }
}


  //  insert into OPERATORS (ID, LOGIN, PASSWORD)
 //   VALUES (OPERATORS_SEQ.nextval, 'bbb', 'bbb')