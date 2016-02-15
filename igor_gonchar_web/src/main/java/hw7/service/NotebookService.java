package hw7.service;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public interface NotebookService {
    public Long receive(Long noteId, int amount, double price);

    public Long sale(Long storeId, int amount);
}
