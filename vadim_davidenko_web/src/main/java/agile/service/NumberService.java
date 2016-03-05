package agile.service;

/**
 * Created by Вадим on 05.03.2016.
 */
public interface NumberService {
    Double calculateSum(String numbers) throws NumberFormatException;

    String reverse(String numbers);

    String shuffle(String numbers);

}
