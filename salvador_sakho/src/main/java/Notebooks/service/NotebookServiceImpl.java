package Notebooks.service;

import Notebooks.dao.NotebookDao;
import Notebooks.domain.Notebook;

import java.util.List;

/**
 * Created by User on 08.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDao noteDao;

    public NotebookServiceImpl(NotebookDao dao) {
        noteDao = dao;
    }

    @Override
    public List<Notebook> getAllNotes() {
        return noteDao.findAll();
    }

    @Override
    public void addNewNote(Notebook note) {
        System.out.println("Note preparing added to DB, my congratulations Salva");
        noteDao.createNote(note);
        System.out.println("Note added to DB, my congratulations Salva");
    }

}
