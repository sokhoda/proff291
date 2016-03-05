package hw5.auth;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Solyk on 02.02.2016.
 */
public class User {

    private Long id;
    private String login;
    private String password;
    private Date dateOfRegistration;
    private SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public SimpleDateFormat getFormatDate() {

        return formatDate;
    }

    public void setFormatDate(SimpleDateFormat formatDate) {
        this.formatDate = formatDate;
    }



    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.dateOfRegistration = new Date();
    }


}
