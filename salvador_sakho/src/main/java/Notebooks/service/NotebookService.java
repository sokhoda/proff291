package Notebooks.service;

import Notebooks.domain.Notebook;

import java.util.List;

/**
 * Created by User on 08.02.2016.
 */
public interface NotebookService {
    List<Notebook> getAllNotes();

    void addNewNote(Notebook note);
}
