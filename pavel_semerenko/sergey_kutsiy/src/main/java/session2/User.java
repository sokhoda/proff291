package session2;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.12.15
 */
public class User implements Comparable<User> {
    private String login;
    private String pass;

    public User() {
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return !(pass != null ? !pass.equals(user.pass) : user.pass != null);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(User user) {
        return user.getPass().length() - this.pass.length();
    }

    @Override
    public String toString() {
        return "User{" +
                "pass='" + pass + '\'' +
                '}';
    }
}
