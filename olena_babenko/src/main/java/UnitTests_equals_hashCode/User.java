package UnitTests_equals_hashCode;

/**
 * Created by lenchi on 22.12.15.
 *
 * Class with one User credentials and overriden equals and hashCode methods
 */

public class User {

    private String login;
    private String password;
    private Double regdate;
    private int rating;
    private boolean sex;

    //getter ana setter for each private param
    public String getLogin(){
        return login;}

    public String getPassword() {
        return password;
    }

    public Double getDate() {
        return regdate;
    }

    public Double getRegdate() {
        return regdate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegdate(Double regdate) {
        this.regdate = regdate;
    }
    //equals overriding
    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        if (this==o) return true;

        User user = (User) o;
        if (this.getLogin() != null && this.getPassword() != null && this.getDate() != null
                && login.equals(user.login)
                && password.equals(user.password)
                && Double.compare(user.regdate,regdate)==0
                && rating == user.rating
                && sex == user.sex) {return true;}
        return false;
        }

    //hashCode overriding
    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + regdate.hashCode();
        result = 31 * result + rating;
        result = 31 * result + (sex ? 1 : 0);
        return result;
    }


}