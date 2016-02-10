package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by s_okhoda on 09.02.2016.
 */
public interface NotebookService {
    Long add(Notebook notebook);
    List findAll();
}
