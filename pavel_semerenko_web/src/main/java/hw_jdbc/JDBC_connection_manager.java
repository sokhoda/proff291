package hw_jdbc;

import java.sql.*;
import java.util.Locale;

/**
 * Created by Pavel on 31.01.2016.
 */
public class JDBC_connection_manager {
    private Connection connection;
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String schema = "notebooks";
    String pass = "notebooks";

    public JDBC_connection_manager(){
        Locale.setDefault(Locale.ENGLISH);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }

        try {
            connection = DriverManager.getConnection(url, schema, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet execQuery(String query){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean execSQL(String sqlSring) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            return statement.execute(sqlSring) && this.connection.createStatement().execute("commit;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void closeConnection(){
        try {
            if(this.connection != null){
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
