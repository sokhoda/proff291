package hw7.springnotes.dao;

import org.springframework.dao.DataIntegrityViolationException;

import java.util.Collection;

/**
 * Created by v.davidenko on 22.02.2016.
 */
public interface GeneralDao {
    <T> void freeObject(Object o);

    <T> Collection<T> getAll(Class<T> clazz);

    <T> T getObject(Class<T> clazz, Long id);

    void saveOrUpdate(Object object) throws DataIntegrityViolationException;

    void update(Object object) throws DataIntegrityViolationException;

    void insert(Object object) throws DataIntegrityViolationException;

    void flush() throws DataIntegrityViolationException;

    void persist(Object object) throws DataIntegrityViolationException;

    <T> void deleteObject(Class<T> clazz, Long objectId);

    void deleteObject(Object o);
}
