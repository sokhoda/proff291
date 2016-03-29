package hw7.notes.service;

/**
 * Created by Пк2 on 18.03.2016.
 */
public interface NotebookService {
    Long receive(Long noteId, int amount, double price);
    Long sale(Long storeId, int amount);
}
