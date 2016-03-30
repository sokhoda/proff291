package soundProgs.Service;

/**
 * Created by ${BIM} on 19.02.2016.
 */

import soundProgs.domain.InterfaceInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class SoudSelection {

    private Connection con;
    private ResultSet rs;
    private String server = "DELTA";
    private String database = "max";
    private String port = "1433";
    private String user = "oktellrecords";
    private String password = "oktellrecords12345";
    private String jdbcUrl = "jdbc:sqlserver://" + server + ": " + port + " ;user=" + user + ";password=" + password + "" + ";databaseName=" + database;
    private ObservableList<InterfaceInfo> interfaceInfoData = FXCollections.observableArrayList();

    public ObservableList<InterfaceInfo> getInterfaceInfoData() {
        return interfaceInfoData;
    }

    public void sqlProcudure(int lid, String dateStart, String dateEnd) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(jdbcUrl);
            PreparedStatement pstmt = con.prepareStatement("{call SoundListnerProcedure(?, ?, ?)}");
            pstmt.setInt(1, lid);
            pstmt.setString(2, dateStart);
            pstmt.setString(3, dateEnd);
            rs = pstmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                interfaceInfoData.add(i, new InterfaceInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11)));
                i++;
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sqlProcudureDate(String dateStart, String dateEnd) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(jdbcUrl);
            PreparedStatement pstmt = con.prepareStatement("{call SoundListnerProcedure(?, ?, ?)}");
            pstmt.setInt(1, 0);
            pstmt.setString(2, dateStart);
            pstmt.setString(3, dateEnd);
            rs = pstmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                interfaceInfoData.add(i, new InterfaceInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11)));
                i++;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sqlProcudureLid(int lid) {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
          //  DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            con = DriverManager.getConnection(jdbcUrl);
            PreparedStatement pstmt = con.prepareStatement("{call SoundListnerProcedure(?,?,?)}");
            pstmt.setInt(1, lid);
            pstmt.setString(2, null);
            pstmt.setString(3, null);
            rs = pstmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                interfaceInfoData.add(i, new InterfaceInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11)));
                i++;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();

        }*/ catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
