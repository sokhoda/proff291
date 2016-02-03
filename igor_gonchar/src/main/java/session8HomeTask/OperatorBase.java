package session8HomeTask;

import javafx.fxml.FXML;
import sun.java2d.pipe.SpanShapeRenderer;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Home on 31.01.2016.
 */
public class OperatorBase extends RegistrationBase {

    @Override
    public StringBuilder addUser(String login, String password) {

        try {
            StringBuilder resultS = new StringBuilder();
            connectToBase();
            Statement stmt = super.conn.createStatement();

            ResultSet result = stmt.executeQuery("SELECT ID, LOGIN, PASSWORD FROM OPERATORS WHERE LOGIN='" + login + "' AND PASSWORD ='" + password + "'");

            int usersCount = 0;
            while (result.next()) {
                usersCount++;
            }
            if (usersCount == 0) {
                java.util.Date date = new java.util.Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String updatedDate = sdf.format(date);


                result = stmt.executeQuery("INSERT INTO OPERATORS (ID, LOGIN, PASSWORD, REGISTER_DATE) VALUES (OPERATORS_SEQ.nextval, " + "'" + login
                        + "', '" + password + "', TO_DATE('" + updatedDate + "', 'dd/MM/yyyy'))");


                result = stmt.executeQuery("SELECT * FROM OPERATORS ORDER BY ID");
                while (result.next()) {
                    String temp = String.format("%-20s %-20s %-20s %-20s" + "\n", result.getString("ID"), result.getString("LOGIN"),
                            result.getString("PASSWORD"), result.getString("REGISTER_DATE").substring(0,10));
                    resultS.append(temp);
                }
                return resultS;

            } else {
                // System.out.println("Such user already exists");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean userAuthorization(String login, String password) {
        connectToBase();
        Statement stmt = null;

        try {
            stmt = super.conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT ID, LOGIN, PASSWORD FROM OPERATORS WHERE LOGIN='" + login + "' AND PASSWORD ='" + password + "'");

            int usersCount = 0;
            while (result.next()) {
                usersCount++;
            }
            if (usersCount == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    @Override
    public void emptyBase() {
        connectToBase();
        Statement stmt = null;
        try {
            stmt = super.conn.createStatement();
            ResultSet result = stmt.executeQuery("DELETE FROM OPERATORS");
            System.out.println("All data was deleted from DB");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public StringBuilder showUsers () {
        StringBuilder resultS = new StringBuilder();

        connectToBase();
        Statement stmt = null;
        try {
            stmt = super.conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM OPERATORS ORDER BY ID");

            while (result.next()) {
                String temp = String.format("%-20s %-20s %-20s %-20s" + "\n", result.getString("ID"), result.getString("LOGIN"),
                        result.getString("PASSWORD"), result.getString("REGISTER_DATE").substring(0,10));
                resultS.append(temp);
            }
            return resultS;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
}
