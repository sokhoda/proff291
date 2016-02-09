package hw_jdbc;

/**
 * Created by Pavel on 31.01.2016.
 */
public class Users_DAO {
    long id;
    String first_name;
    String last_name;
    String pass;

    public Users_DAO() {
    }

    public Users_DAO(long id, String first_name, String last_name, String pass) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
