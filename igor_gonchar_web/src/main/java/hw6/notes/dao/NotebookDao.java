package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by i.gonchar on 2/10/2016.
 */
public interface NotebookDao {

    public Long create(Notebook ntb);
    public Notebook read(Long id);
    public boolean update(Notebook ntb);
    public boolean delete(Notebook ntb);

}
