package session8HomeTask;

import javafx.fxml.FXML;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                result = stmt.executeQuery("INSERT INTO OPERATORS (ID, LOGIN, PASSWORD) VALUES (OPERATORS_SEQ.nextval, " + "'" + login + "', '" + password + "')");


                result = stmt.executeQuery("SELECT * FROM OPERATORS ORDER BY ID");
                while (result.next()) {
                    String temp = String.format("%-20s %-20s %-20s" + "\n", result.getString("ID"), result.getString("LOGIN"), result.getString("PASSWORD"));
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
}