package hw7.notes.dao;

import hw7.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Пк2 on 17.03.2016.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List findAll();
}
