package session12.dentist.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/18/13
 */
public interface GenericDao<T, PK extends Serializable> {
    PK create(T persistentObject);

    T get(PK id);

    List<T> getAll();

    void update(T persistentObject);

    void createOrUpdate(T persistentObject);

    void delete(T persistentObject);
}
