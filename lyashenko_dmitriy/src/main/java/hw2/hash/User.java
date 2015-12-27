package hw2.hash;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Solyk on 21.12.2015.
 */

/**
 * Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 Поля класса пользователь:
 1. Логин
 2. Пароль
 3. Дата регистрации
 4. Рейтинг (вещественное число)
 5. Пол

 Класс задания hw2.hash.User
 */
public class User {

    private String login;
    private String password;
    private Date dateOfRegistration;
    private Integer rating;
    private boolean sex;
    private GregorianCalendar forDate;

    public User(){

    }
    public User(String login, String password,int year, int month,int day, boolean sex) {
        forDate = new GregorianCalendar(year,month,day);
        this.login = login;
        this.password = password;
        this.dateOfRegistration = forDate.getTime();
        this.rating = Math.abs((int)(new Date().getTime() - this.dateOfRegistration.getTime())/864000);
        this.sex = sex;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        User user = (User) obj;

        if (sex != user.sex){
            return false;
        }
        if (login != null ? !login.equals(user.login) : user.login != null) {
            return false;
        }
        if (password != null ? !password.equals(user.password) : user.password != null){
            return false;
        }
        if (dateOfRegistration != null ? !dateOfRegistration.equals(user.dateOfRegistration) : user.dateOfRegistration != null) {
            return false;
        }
        return rating != null ? rating.equals(user.rating) : user.rating == null;

    }

    @Override
    public int hashCode() {

        int result = 0;

        if(login != null){
            result = login.hashCode();
        } else {
            result = 0;
        }
        if(password != null){
            result += password.hashCode();
        } else {
            result += 0;
        }
        if(dateOfRegistration != null){
            result += dateOfRegistration.hashCode();
        } else {
            result += 0;
        }
        if(rating != null){
            result += rating;
        } else {
            result += 0;
        }
        if(sex == true){
            result += 1;
        } else {
            result += 0;
        }

        return result;
    }

    @Override
    public String toString() {

        String tmp = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

        if(this.isSex() == true){
            tmp += "Man";
        } else {
            tmp += "Woman";
        }

        return "User " + "\n" +
                 "\t" + login + '\n' +
                "\t" +  password + '\n' +
                "\t" + "dateOfRegistration " + dateFormat.format(dateOfRegistration) + "\n" +
                "\t" + "rating " + rating + "\n" +
                 "\t" + tmp ;
    }

    public static void main(String[] args) {
       // User us1 = new User();
      //  us1.setDateOfRegistration(new Date());
       // System.out.println(us1.getDateOfRegistration().hashCode());
        User us2 = new User("Dfyz", "op56hj",2012, 10 - 1, 23, true);
        System.out.println( us2.toString());
        System.out.println(us2.hashCode());

        User us3 = new User("Dfyz", "op56hj",2012, 10 - 1, 23, true);
        System.out.println( us3.toString());
        System.out.println(us3.hashCode());

        User us4 = new User("Jipoi", "fkkfkf",2010, 8 - 1, 8, false);
        System.out.println( us4.toString());
        System.out.println(us4.hashCode());

        System.out.println(us2.equals(us3));
        System.out.println(us2.hashCode() + "\t" + us3.hashCode());
        System.out.println(us2.equals(us4));
    }

}
