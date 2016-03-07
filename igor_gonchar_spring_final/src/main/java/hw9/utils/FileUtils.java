package hw9.utils;

import hw9.domain.Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by i.gonchar on 3/7/2016.
 */
public class FileUtils {

    static public boolean fileEmptyCheck(File file) {
        if (file.length() == 0) {
            System.out.println("File is empty");
            return false;
        }
        return true;
    }

    public static List<Client> clientMassEditResult(String filePath) {
        File file = new File("D:\\Java\\Projects\\proff29\\igor_gonchar_spring_final\\src\\main\\resources\\cleintFiles\\" + filePath + ".txt");

        if (file.exists()) {
            List<Client> clients = new ArrayList<>();
            BufferedReader read = null;
            String line;

            try {
                read = new BufferedReader(new FileReader(file));
                if (FileUtils.fileEmptyCheck(file)) {

                    while ((line = read.readLine()) != null) {
                        String[] values = line.split("\t");
                        String name = values[0];
                        String surname = values[1];
                        String phone = values[2];
                        String address = values[3];

                        Client client = new Client(name, surname, phone, address);
                        clients.add(client);
                    }
                }

            } catch (IOException e) {
                System.out.println("Nothing to read");
            } finally {
                try {
                    read.close();
                    return clients;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println("File does not exist");
        return null;
    }
}
