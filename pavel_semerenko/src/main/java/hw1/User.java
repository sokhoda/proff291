
public class User {
    private String name;
    private String surname;
    private long regDate;
    private double rating;
    private boolean sex;

    public User() {
    }

    public User(String name, String surname, long regDate) {
        this.name = name;
        this.surname = surname;
        this.regDate = regDate;
    }

    public User(String name, String surname, long regDate, double rating, boolean sex) {
        this.name = name;
        this.surname = surname;
        this.regDate = regDate;
        this.rating = rating;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getRegDate() {
        return regDate;
    }

    public void setRegDate(long regDate) {
        this.regDate = regDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        User user = (User) obj;
        if (!name.equals(user.getName())) return false;
        if (!surname.equals(user.getSurname())) return false;
        if (regDate != user.getRegDate()) return false;
        if (Double.compare(rating, user.getRating()) != 0) return false;
        if (sex != user.getSex()) return false;
        return true;
    }

    @Override
    public int hashCode(){
        return 7 * ((name != null) ? name.hashCode() : 0)
                + ((surname != null) ? surname.hashCode() : 0)
                + (int) regDate
                + (int) Double.doubleToLongBits(rating)
                + (sex ? 1 : 0);
    }
}
