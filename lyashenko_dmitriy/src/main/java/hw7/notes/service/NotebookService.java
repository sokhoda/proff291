package hw7.notes.service;

/**
 * Created by Admin on 17.02.2016.
 */
public interface NotebookService {
    Long receive(Long noteId, int amount, double price);
    Long sale(Long storeId, int amount);
}
