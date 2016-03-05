package hw7.notes.dao;


import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by Admin on 17.02.2016.
 */
public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List findAll();

}
