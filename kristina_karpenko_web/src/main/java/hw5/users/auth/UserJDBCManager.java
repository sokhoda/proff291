package hw5.users.auth;

import hw5.users.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserJDBCManager {
    public int create(User user) throws ClassNotFoundException, SQLException {

        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application is started...");
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try {
            conn = DriverManager.getConnection(url, "NOTEBOOKS", "SYS");
            Statement stnt = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("insert into USERS values(?,?,?,?)");

            ps.setInt(1, user.getId());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
            ps.setDate(4, user.getDateRegistration());
            System.out.println(user.getDateRegistration());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Connection is failed");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }

        }
        return user.getId();
    }

    public List findAll() throws ClassNotFoundException, SQLException{
        List subUsers = new ArrayList<>();
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application is started...");
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try {
            conn = DriverManager.getConnection(url, "NOTEBOOKES", "SYS");
            Statement stnt = conn.createStatement();
            ResultSet rs = stnt.executeQuery("SELECT * FROM USERS");
            while (rs.next()) {
                subUsers.add(new User(rs.getInt("ID"), rs.getString("USER_NAME"), rs.getString("PASSWORD"), rs.getDate("DATE_REGISTER")));
                System.out.printf("\n%20s %20s %20s %20s", rs.getInt("ID"), rs.getString("USER_NAME"), rs.getString("PASSWORD"), rs.getDate("DATE_REGISTER"));
            }
        } catch (SQLException e) {
            System.out.println("Connection is failed");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }

        }
        return subUsers;
    }

    public User readByNamePass(String login, String pass) throws ClassNotFoundException, SQLException{
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application is started...");
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        User newUs = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try {
            conn = DriverManager.getConnection(url, "NOTEBOOKS", "SYS");
            Statement stnt = conn.createStatement();
            ResultSet rs = stnt.executeQuery("SELECT * FROM USERS");

                while (rs.next()) {
                    if (login.contains(rs.getString("USER_NAME")) && pass.contains(rs.getString("PASSWORD"))) {
                        newUs = new User(rs.getInt("ID"), rs.getString("USER_NAME"), rs.getString("PASSWORD"), rs.getDate("DATE_REGISTER"));
                        findAll();
            } else {
                System.out.printf("Неправильный логин или пароль");
                        return null;
            }
        }
        } catch (SQLException e) {
            System.out.println("Connection is failed");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }

        }
    return newUs;
    }
}
