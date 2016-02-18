package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.List;

public interface NotebookService {
    public Long add(Notebook notebook);
    public List<Notebook> findAll();
}
