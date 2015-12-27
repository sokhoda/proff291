package hw2.hash;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by v.davidenko on 21.12.2015.
 */
public class User {

    private String password;
    private String login;
    private Double rate;
    private Boolean sex;
    private Date regDate = new Date();

    // Constructors
    public User(String login, String password, Date regDate, Double rate, Boolean sex) {
        this.login = login;
        this.password = password;
        this.regDate = regDate;
        this.rate = rate;
        this.sex = sex;
    }

    public User() {
        password = "password";
        login = "login";
        rate = 0.0;
        sex = true;
    }

    // Getters and setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Boolean isSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (rate != null ? !rate.equals(user.rate) : user.rate != null) return false;
        if (!regDate.equals(user.regDate)) return false;
        if (sex != user.sex) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = password != null ? password.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        return "User:" +
                "\npassword = '" + password + "'" +
                "\nlogin = '" + login + "'" +
                "\nregDate = " + df.format(regDate) +
                "\nrate = " + rate +
                "\nsex = " + (sex ? "man" : "woman") +
                "\n";
    }

}
