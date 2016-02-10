package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Pavel on 10.02.2016.
 */
public interface NotebookDao {
    Long create(Notebook ntb);
    Notebook read(Long id);
    boolean delete(Notebook ntb);
    boolean update(Notebook ntb);
    List<Notebook> findAll();
}
