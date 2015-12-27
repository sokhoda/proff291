package arhiv;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import java.util.GregorianCalendar;

public class User {
    private String login;
    private String pass;
    private GregorianCalendar registred;
    private double rate;
    private boolean sex;

    public User() {
    }

    public User(String login, String pass, GregorianCalendar registred, double rate, boolean sex) {
        this.login = login;
        this.pass = pass;
        this.registred = registred;
        this.rate = rate;
        this.sex = sex;
    }

    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public GregorianCalendar getRegistred() {
        return this.registred;
    }

    public void setRegistred(GregorianCalendar registred) {
        this.registred = registred;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isSex() {
        return this.sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String toString() {
        return "User{login=\'" + this.login + '\'' + ", pass=\'" + this.pass + '\'' + ", registred=" + this.registred + ", rate=" + this.rate + ", sex=" + this.sex + '}';
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            User user = (User)o;
            if(Double.compare(user.rate, this.rate) != 0) {
                return false;
            } else if(this.sex != user.sex) {
                return false;
            } else {
                label52: {
                    if(this.login != null) {
                        if(this.login.equals(user.login)) {
                            break label52;
                        }
                    } else if(user.login == null) {
                        break label52;
                    }

                    return false;
                }

                if(this.pass != null) {
                    if(!this.pass.equals(user.pass)) {
                        return false;
                    }
                } else if(user.pass != null) {
                    return false;
                }

                boolean var10000;
                label75: {
                    if(this.registred != null) {
                        if(!this.registred.equals(user.registred)) {
                            break label75;
                        }
                    } else if(user.registred != null) {
                        break label75;
                    }

                    var10000 = true;
                    return var10000;
                }

                var10000 = false;
                return var10000;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.login != null?this.login.hashCode():0;
        result = 31 * result + (this.pass != null?this.pass.hashCode():0);
        result = 31 * result + (this.registred != null?this.registred.hashCode():0);
        long temp = Double.doubleToLongBits(this.rate);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        result = 31 * result + (this.sex?1:0);
        return result;
    }
}
