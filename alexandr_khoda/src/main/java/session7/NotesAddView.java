package session7;

import com.sun.deploy.model.Resource;
import com.sun.deploy.security.ValidationState;
import oracle.jdbc.*;
import oracle.jdbc.driver.*;
import oracle.jdbc.oracore.OracleType;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by s_okhoda on 31.01.2016.
 */
public class NotesAddView {
    private static final int StrWidth = 20;
    private static String [] MENU = {"1. INSERT", "2. UPDATE", "3. DELETE",
            "4. EXIT"};

    public static int printTable(Connection conn, String tabName){
        int cnt = 0;
        if(conn == null){
            return -1;
        }
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabName +
                    " ORDER BY NAME");

            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            String formatStr ="%" + StrWidth + "s ";

            System.out.println();
            for (int i = 0; i < columns; i++) {
                System.out.printf(formatStr, rsmd.getColumnName(i + 1));
            }

            while (rs.next()) {
                System.out.println();
                for (int i = 0; i < columns; i++) {
                    System.out.printf(formatStr, rs.getString(i + 1));
                }
                cnt++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return cnt;
    }
    public static void printMenu(){
        System.out.println();
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(MENU[i]);
        }
    return;
    }

    public static void callSF(Connection conn){
        String formatStr ="%" + StrWidth + "s ";

        try {

        CallableStatement cs = conn.prepareCall("{call SELECT_WITH_PAR(?, ?)}");

            cs.setString(1, "19");
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);

            while(rs.next()){
                System.out.println(rs.getString("ID") + " " + rs.getString
                        ("NAME"));
            }



//            while (hadResult){
//                ResultSet rs = cs.getResultSet();
//
//                ResultSetMetaData rsmd = rs.getMetaData();
//                int columns = rsmd.getColumnCount();
//
//                while (rs.next()) {
//                    System.out.println();
//                    for (int i = 0; i < columns; i++) {
//                        System.out.printf(formatStr, rs.getString(i + 1));
//                    }
//                }
//
//                hadResult = cs.getMoreResults();
//            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Scanner scan = new Scanner(System.in);
        int menuID = 0;

        Connection conn = null;

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String tabName = "NOTES";
        try{
            conn = DriverManager.getConnection(url, "notebooks", "notebooks");

            System.out.println("callSF:");
            callSF(conn);

            Statement stmt = conn.createStatement();
            while (menuID != 4) {

                printMenu();
                System.out.println("Select Action:");
                menuID = scan.nextInt();

                if (menuID == 1){
                    System.out.println("\nВведите имя ноута:");
                    String note = scan.next();
                    if (note.length() > 0) {
                        stmt.executeUpdate("INSERT INTO " +
                                tabName +" Values  (NOTE_SEQ.NextVal ,  '" + note + "' )");
                    }
                        printTable(conn, tabName );
                }
                if (menuID == 2){
                    System.out.println("\nВведите индекс ноута:");
                    int noteID = scan.nextInt();
                    System.out.println("\nВведите новое имя ноута:");
                    String name = scan.next();

                    stmt.executeUpdate("UPDATE " + tabName + " set NAME = '" +
                            name + "' where ID = " + noteID);
                    printTable(conn, tabName );
                }
                if (menuID == 3){
                    System.out.println("\nВведите индекс ноута:");
                    int noteID = scan.nextInt();

                    stmt.executeUpdate("DELETE " + tabName + " where ID = " + noteID);
                    printTable(conn, tabName );
                }
            }
        }
        catch (SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        finally {
            if (conn != null){
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
