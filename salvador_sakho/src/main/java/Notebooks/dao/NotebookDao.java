package Notebooks.dao;

import Notebooks.domain.Notebook;

import java.util.List;

/**
 * Created by User on 08.02.2016.
 */
public interface NotebookDao {

    Long createNote(Notebook notebook);

    Notebook read(Long id);

    boolean delete(Long id);

    void update(Notebook notebook);

    void delete(Notebook notebook);

    List<Notebook> findAll();

//    List<Notebook> findMonyGT(long amount);
}
