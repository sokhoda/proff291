package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by s_okhoda on 09.02.2016.
 */
public class NotebookServiceImpl implements NotebookService{
    NotebookDao noteDao;

    public NotebookServiceImpl(NotebookDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    public Long add(Notebook notebook) {
        return noteDao.create(notebook);
    }

    @Override
    public List findAll() {
        return noteDao.findAll();
    }
}
