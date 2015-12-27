package session2HomeTask;

import java.util.Date;

/**
 * Created by i.gonchar on 12/21/2015.
 */
public class User {

    private String login;
    private String password;
    private Date regDate;
    private Double rating;
    private String sex;

    public User(String login, String password, double rating, String sex, Date regDate) {

        this.login = login;
        this.password = password;
        this.sex = sex;
        this.rating = rating;
        this.regDate = regDate;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

   /* public Date getRegisterTime() {
        return registerTime;
    }*/

    public double getRating() {
        return rating;
    }

    public String getSex() {
        return sex;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }*/

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (regDate != null ? !regDate.equals(user.regDate) : user.regDate != null) return false;
        if (rating != null ? !rating.equals(user.rating) : user.rating != null) return false;
        return !(sex != null ? !sex.equals(user.sex) : user.sex != null);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                // ", registerDate=" + registrationDate +
                ", rating=" + rating +
                ", sex='" + sex + '\'' +
                '}';
    }
}
