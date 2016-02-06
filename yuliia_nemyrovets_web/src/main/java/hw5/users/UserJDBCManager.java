package hw5.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Юлия on 05.02.2016.
 */
public class UserJDBCManager {
    public UserJDBCManager() {

    }

    public Connection connection() {
        Locale.setDefault(Locale.ENGLISH);

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";

        try {
            conn = DriverManager.getConnection(url, "user", "user");


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
        return conn;
    }

    public int create(User user) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = connection();
            stmt = conn.createStatement();
            CallableStatement pt = conn.prepareCall("{? = call getUserByName(?)}");
  //         PreparedStatement pt = conn.prepareStatement(" INSERT INTO USER_TABLE USER_NAME,USER_ID,USER_PASSWORD,USER_DATE VALUES (?,?,?,?)");
            pt.setString(1, user.getName());
            pt.setInt(2, user.getId());
            pt.setString(3, user.getPassword());
            pt.setDate(4,new Date(user.getDate().getTime()));

            pt.executeQuery();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return 1;
    }

    public List findAll() {

        List<User> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        User users = new User();
        try {
            conn = connection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT* FROM USER_TABLE ");
            while (rs.next()) {
                users.setName(rs.getString("USER_NAME"));
                users.setId(rs.getInt("USER_ID"));
                users.setPassword(rs.getString("USER_PASSWORD"));
                users.setDate(rs.getDate("USER_DATE"));
                list.add(users);
            }


        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return list;
    }
}