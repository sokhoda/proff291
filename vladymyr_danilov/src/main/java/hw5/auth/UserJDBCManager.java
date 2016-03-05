package hw5.auth;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class UserJDBCManager {
    protected String SELECT_QUERY = "SELECT * FROM \"%1$s\" WHERE %2$s=? AND %3$s=?";
    protected String LIST_QUERY = "SELECT * FROM \"%s\"";
    protected String INSERT_QUERY = "INSERT INTO \"%1$s\" (%2$s) VALUES (%3$s)";

    private Connection connection = null;

    public UserJDBCManager() {

    }

    private void initDatabase() throws ClassNotFoundException, SQLException {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:oracle:thin:@172.16.138.128:1521:XE";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        try {
            connection = DriverManager.getConnection(url, "notebooks", "notebooks");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int create(User user) throws SQLException, ClassNotFoundException {
        String[] keyArray = {"ID", "NAME", "PASSWORD", "RDATE"};
        String keys = String.join(", ", keyArray);
        String values = String.join(", ", genPlaceholders(keyArray.length, "?"));
        String insert = String.format(INSERT_QUERY, "USERS", keys, values);

        try {
            initDatabase();

            PreparedStatement statement = connection.prepareStatement(insert);
            int counter = 1;

            statement.setInt(counter++, user.getId());
            statement.setString(counter++, user.getName());
            statement.setString(counter++, user.getPassword());
            statement.setDate(counter, new Date(user.getDate().getTime()));
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }


        return 1;
    }

    public List<hw5.users.User> findAll() throws SQLException, ClassNotFoundException {
        List<hw5.users.User> list = new ArrayList<>();
        String select = String.format(LIST_QUERY, "USERS");

        try {
            initDatabase();

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(select);

            while ( result.next() ) {
                User user = new User();
                user.setId(result.getInt("ID"));
                user.setName(result.getString("NAME"));
                user.setPassword(result.getString("PASSWORD"));
                user.setDate(result.getDate("RDATE"));
                list.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if ( connection != null ) {
                connection.close();
            }
        }

        return list;

    }

    public User readByNamePass(String login, String password) throws SQLException, ClassNotFoundException {
        String select = String.format(SELECT_QUERY, "USERS", "NAME", "PASSWORD");
        User user = null;

        try {
            initDatabase();

            PreparedStatement statement = connection.prepareStatement(select);
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            user = new User();
            while ( result.next() ) {
                user.setId(result.getInt("ID"));
                user.setName(result.getString("NAME"));
                user.setPassword(result.getString("PASSWORD"));
                user.setDate(result.getDate("RDATE"));
            }
            statement.close();
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if ( connection != null ) {
                connection.close();
            }
        }

        return user;

    }

    private Collection<String> genPlaceholders(int size, String placeholder) {
        List<String> list = new ArrayList<>();

        for ( int i = 0; i < size; i++ ) {
            list.add(placeholder);
        }

        return list;
    }
}
