package hw7.dao;

import hw7.domain.Notebook;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public interface NotebookDao {
    public Long create(Notebook notebook);

    public Notebook read(Long id);

    public boolean update(Notebook notebook);

    public boolean delete(Notebook notebook);

    public List findAll();
}
