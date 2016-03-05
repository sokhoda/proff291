package hw7.notes.dao;


import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Kris on 15.02.2016.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List findAll();
}
