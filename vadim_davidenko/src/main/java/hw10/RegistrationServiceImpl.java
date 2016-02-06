package hw10;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Вадим on 02.02.2016.
 */
public class RegistrationServiceImpl implements RegistrationService {

    public void createUser(User user) throws SQLException {
        String query =
                "insert into CLIENTS \n" +
                "(ID, FIRSTNAME, LASTNAME, DEPARTMENT, SALARY, LOGIN, PSW)\n" +
                "values\n" +
                "(SEQ_CLIENTS.nextval" +
                ",'" + user.getName() +
                "','" + user.getSurname() +
                "','" + user.getDepartment() +
                "'," + String.valueOf(user.getSalary()) +
                ",'" + user.getLogin() +
                "','" + user.getPassword() + "')";

        Connection conn = null;
        try{
            conn = connectToDB();
            Statement stat = conn.createStatement();
            stat.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                conn.close();
            }
        }
    }

    public boolean authorization(String login, String password) throws SQLException {
        String query =
                "select LOGIN, PSW \n" +
                        "from CLIENTS \n" +
                        "where LOGIN = '" + login + "' and PSW = '" + password + "'";

        Connection conn = null;
        boolean isExist = false;
        try{
            conn = connectToDB();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            isExist = res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                conn.close();
            }
        }
        return isExist;
    }



    public List<User> getUserList() throws SQLException {
        String query = "select * from CLIENTS";

        List<User> users = new LinkedList<User>();
        Connection conn = null;
        try {
            conn = connectToDB();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);

            while (res.next()) {
                User user = new User();
                user.setName(res.getString("FIRSTNAME"));
                user.setSurname(res.getString("LASTNAME"));
                user.setDepartment(res.getString("DEPARTMENT"));
                user.setSalary(res.getInt("SALARY"));
                user.setLogin(res.getString("LOGIN"));
                user.setPassword(res.getString("PSW"));
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

    public Connection connectToDB() throws SQLException {
        final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
        final String DB_LOGIN = "notebooks";
        final String DB_PASSWORD = "notebooks";

        Locale.setDefault(Locale.ENGLISH);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws SQLException {
        RegistrationServiceImpl regService = new RegistrationServiceImpl();
        User newUser = new User("Vadim", "Davidenko", "IT", 800, "vadim4", "12345");
        regService.createUser(newUser);

        List<User> users = regService.getUserList();
        if (!users.isEmpty()) {
            for (User user : users) {
                System.out.println(user.toString()) ;
            }
        }
        boolean isExist = regService.authorization("vadim", "12345");
        System.out.println("\n" + isExist);
    }
}
