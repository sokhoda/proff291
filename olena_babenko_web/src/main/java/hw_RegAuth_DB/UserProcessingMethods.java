package hw_RegAuth_DB;

import java.io.IOException;
import java.sql.*;
import java.util.Locale;

/**
 * Created by lenchi on 05.02.16.
 */
public class UserProcessingMethods {
    public Connection conn = null;

    //-----------Registration and Authentication methods--------------------------------------------------------

    public int Authentication(String login, String password) {
        int authenticationOK = 0;
        try {
            conn = getConnect();

            if (!verifyUserExisting(login, conn)) {
                authenticationOK = 1;
            } else if (!verifyUserCredentials(login, password)) {
                authenticationOK = 2;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }

        return authenticationOK;
    }

    public boolean Registration(String login, String password) {
        boolean registrationOK = true;
        try {
            conn = getConnect();

            if (verifyUserExisting(login, conn)) {
                registrationOK = false;
            } else {
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery("INSERT INTO users (ID, USER_NAME, USER_PASS) VALUES (NOTE_SEC.nextval, '" + login + "', '" + password + "')");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }

        return registrationOK;
    }

    //----------Other methods-----------------------------------------------------------------------------------

    public boolean verifyUserExisting(String login, Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM users WHERE USER_NAME = '" + login + "'");

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyUserCredentials(String login, String password) {
        boolean userIsCorrect = false;

        try {
            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery("SELECT USER_NAME, USER_PASS FROM users WHERE USER_NAME = '" + login + "'");
            while (rs.next()) {
                if (rs.getString("USER_NAME").equals(login) && rs.getString("USER_PASS").equals(password)) {
                    userIsCorrect = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userIsCorrect;
    }

    public Connection getConnect() {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, "notebooks", "notebooks");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
}



