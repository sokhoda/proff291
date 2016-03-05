package session8;

import java.sql.*;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/12/13
 */
public class ConnectEx {
    public static void main(String[] args)  {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");


        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/notes";
        try {
            conn = DriverManager.getConnection(url, "root", "Faerton1976");
            System.out.println("Connection complete.");
            Statement st = conn.createStatement();//Готовим запрос
            ResultSet rs = st.executeQuery("SELECT * from `cars` where id >= 1;");//Выполняем запрос к БД, результат в переменной rs
            while(rs.next()) {
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString(2) + " ");
                System.out.print(rs.getString(3)+ " ");
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Что то здесь не так!!!");
                }
            }
        }
    }
}
