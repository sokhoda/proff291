package session12;

import java.util.List;
import session11.Users;


    public interface ClientDao {
        Long create(Users user);
        Users read(Long id);
        void update(Users client);
        void delete(Users client);
        List<Users> findAll(String login, String pass);
        List<Users> findAllUsersByPortion(Long id);
       // List<Users> findMonyGT(long amount);
    }


