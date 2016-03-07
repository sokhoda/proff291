package hw6.notes.service;


import hw6.notes.dao.NotebookDao;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by Rrr on 09.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao;

    public NotebookServiceImpl(NotebookDao dao) {
        notebookDao = dao;
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDao.findAll();
    }

    @Override
    public Long add(Notebook ntb) {
       return notebookDao.create(ntb);
    }
}