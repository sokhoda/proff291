package hibernate;

import java.util.List;

/**
 * Created by Pavel on 07.02.2016.
 */
public interface UserDAO {
     void insert();
     void create();
     void read();
     void delete();
     List<User> findAll();
     List<Object[]> findExceptOne(String name, String pass);
     List<User> findUsersByPortion(int startWith, int portionSize);
     long findCountAll();
}
