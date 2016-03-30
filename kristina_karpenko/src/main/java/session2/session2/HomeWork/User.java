package session2.session2.HomeWork;

import java.util.HashSet;
import java.util.Set;

/**
 * Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 * Поля класса пользователь:
 * 1. Логин
 * 2. Пароль
 * 3. Дата регистрации
 * 4. Рейтинг (вещественное число)
 * 5. Пол
 */
public class User {
    Set<User> users = new HashSet<>();
    private String login;
    private String password;
    private String dateRegistration;
    private double rating;//рейтинг
    private boolean sex;

    public User(){}
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String dateRegistration, double rating, boolean sex) {
        this(login, password);
        this.dateRegistration = dateRegistration;
        this.rating = rating;
        this.sex = sex;
    }
    public void setUsers(Set<User> user) {
        this.users.addAll(user);
    }
    public Set<User> getUsers() {//вернуть всех юзеров
        return users;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateRegistration(String dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDateRegistration() {
        return dateRegistration;
    }

    public double getRating() {
        return rating;
    }

    public boolean getSex() {
        return sex;
    }


    @Override
    public int hashCode() {
        return login.hashCode() + password.hashCode() + dateRegistration.hashCode() + (int) (Double.doubleToLongBits(rating) -
                (Double.doubleToLongBits(rating) >>> 32)) + (int) (sex ? 0 : 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other =(User)obj;
               if (login == other.getLogin() && password == other.getPassword() && dateRegistration == other.getDateRegistration() &&
                    rating == other.getRating() && sex == other.getSex()) {
                return true;
            }
        return false;
    }

    @Override
    public String toString() {
        return  "\n"  +  "Логин: " + login + "  Пароль:  " + password + "  Дата регистрации: " + dateRegistration +
                "  Рейтинг:" + rating + "  Пол:  " + sex+ "\n" ;
    }
}
