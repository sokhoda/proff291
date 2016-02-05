package hw5.users;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private String password;
    private Date date;

    public User() {

    }

    public User(Integer id, String name, String password, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.date = date;
    }

    @Override
    public boolean equals(Object user) {
        if ( this == user ) {
            return true;
        }
        if ( user == null ) {
            return false;
        }
        if (getClass() != user.getClass() ) {
            return false;
        }
        User secondUser = (User) user;
        if ( getId().equals(secondUser.getId())
                && getName().equals(secondUser.getName())
                && getPassword().equals(secondUser.getPassword())
                && getDate().equals(secondUser.getDate()) ) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int someNumber = 31;

        return someNumber + getName().hashCode() + getId().hashCode() + getPassword().hashCode() + getDate().hashCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
