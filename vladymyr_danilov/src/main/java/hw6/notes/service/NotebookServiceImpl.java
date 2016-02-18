package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.domain.Notebook;

import java.util.List;

public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao;

    public NotebookServiceImpl(NotebookDao notebookDao) {
        this.notebookDao = notebookDao;
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return (List<Notebook>) notebookDao.findAll();
    }
}
