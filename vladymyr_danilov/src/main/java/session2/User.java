package session2;

import java.time.LocalDate;

public class User implements Comparable<User> {
    private String login;
    private String password;
    private Integer rank;
    private boolean sex;
    private LocalDate registrationDate;

    public User() {}

    public User(String login, String password) {
        setLogin(login);
        setPassword(password);
        this.registrationDate = LocalDate.now();
    }

    public User(String login, String password, Integer rank, boolean sex) {
        setLogin(login);
        setPassword(password);
        setRank(rank);
        setSex(sex);
        this.registrationDate = LocalDate.now();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getRank() {
        return this.rank;
    }

    public boolean getSex() {
        return sex;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object user) {
        if ( this == user ) {
            return true;
        }
        if ( user == null ) {
            return false;
        }
        if ( getClass() != user.getClass() ) {
            return false;
        }

        User secondUser = (User)user;
        if ( getLogin().equals(secondUser.getLogin())
                && getPassword().equals(secondUser.getPassword())
                && getRank() == secondUser.getRank()
                && getSex() == secondUser.getSex()
                && getRegistrationDate().equals(secondUser.getRegistrationDate())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int sameNumber = 42;

        return sameNumber + getLogin().hashCode() + getPassword().hashCode() + getRank()
                + getRegistrationDate().hashCode();
    }

    @Override
    public int compareTo(User user) {
        return user.getPassword().compareTo(this.password);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User("1", "2", 13, false);
        User user3 = new User("2", "2");

        User user2 = new User("1", "2");
        user2.setRegistrationDate(user1.getRegistrationDate());

        System.out.println(user1.equals(user1));
        System.out.println(user1.equals(user3));


        System.out.println(user1.getRegistrationDate());
    }

}
