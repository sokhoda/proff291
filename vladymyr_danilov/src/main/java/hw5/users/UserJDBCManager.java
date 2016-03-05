package hw5.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class UserJDBCManager {
    protected String LIST_QUERY = "SELECT * FROM \"%s\"";
    protected String INSERT_QUERY = "INSERT INTO \"%1$s\" (%2$s) VALUES (%3$s)";

    private Connection connection = null;

    public UserJDBCManager() {

    }

    private void initDatabase() throws ClassNotFoundException, SQLException {
        Locale.setDefault(Locale.ENGLISH);
//        String url = "jdbc:oracle:thin:@172.16.138.128:1521:XE";
        String url = "jdbc:postgresql://178.62.245.113:5432/notebooks";


//        Class.forName("oracle.jdbc.driver.OracleDriver");
        Class.forName("org.postgresql.Driver");


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
//        System.out.println(insert);

        initDatabase();

        PreparedStatement statement = connection.prepareStatement(insert);
        int counter = 1;

        statement.setInt(counter++, user.getId());
        statement.setString(counter++, user.getName());
        statement.setString(counter++, user.getPassword());
        statement.setDate(counter, new Date(user.getDate().getTime()));
        statement.executeUpdate();
        statement.close();

        return 1;
    }

    public List<User> findAll() throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        String select = String.format(LIST_QUERY, "USERS");

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

        return list;

    }

    private Collection<String> genPlaceholders(int size, String placeholder) {
        List<String> list = new ArrayList<>();

        for ( int i = 0; i < size; i++ ) {
            list.add(placeholder);
        }

        return list;
    }


}
