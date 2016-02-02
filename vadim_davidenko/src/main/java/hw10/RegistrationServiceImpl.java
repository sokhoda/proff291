package hw10;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Вадим on 02.02.2016.
 */
public class RegistrationServiceImpl implements RegistrationService {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_LOGIN = "notebooks";
    private static String DB_PASSWORD = "notebooks";

    public void createUser(User user) throws SQLException {
        String query = "insert into USERS \n" +
                "(USER_ID, FIRST_NAME, LAST_NAME, ADDRESS, USER_LOGIN, USER_PASSWORD)\n" +
                "values\n" +
                "(SEQ_USERS.nextval, 'Vadim', 'Davidenko', 'Kiev', 'vadim', '12345')";

        Locale.setDefault(Locale.ENGLISH);
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                conn.close();
            }
        }
    }

    public boolean authorizationUser(String login, String password) throws SQLException {
        String query = "select USER_LOGIN, USER_PASSWORD from USERS where USER_LOGIN = login and USER_PASSWORD = password";

        Locale.setDefault(Locale.ENGLISH);
        Connection conn = null;
        boolean isAuthorized = false;
        try{
            conn = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            isAuthorized = res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                conn.close();
            }
        }
        return isAuthorized;
    }

    public List<User> getUserList() throws SQLException {
        List<User> users = new LinkedList<User>();
        String query = "select * from USERS";

        Locale.setDefault(Locale.ENGLISH);
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while (res.next()) {
                User user = new User();
                user.setName(res.getString("FIRST_NAME"));
                user.setSurname(res.getString("LAST_NAME"));
                user.setAddress(res.getString("ADDRESS"));
                user.setLogin(res.getString("USER_LOGIN"));
                user.setPassword(res.getString("USER_PASSWORD"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                conn.close();
            }
        }
        return users;
    }

    public static void main(String[] args) throws SQLException {
        RegistrationServiceImpl reg = new RegistrationServiceImpl();
        List<User> users = new LinkedList<User>();
//        User newUser = new User();
//        reg.createUser(newUser);

        users = reg.getUserList();
        if (!users.isEmpty()) {
            for (User user : users) {
                System.out.println(user.getName() + "\t" + user.getSurname());
            }
        }
    }
}
