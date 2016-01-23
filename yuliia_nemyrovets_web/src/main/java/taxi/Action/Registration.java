package taxi.Action;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Юлия on 22.01.2016.
 */
public class Registration {
    private Map<String, String[]> clients = new HashMap<>();


    public boolean addClients(String login, String[] data) {
        if (clients.containsKey(login)) {
            return false;
        } else {
            clients.put(login, data);
            wtiteToDataBase(login, data);
            return true;
        }

    }

    public String[] getClientsData(String login) {
        if (clients.containsKey(login)) {
            return clients.get(login);
        }
        return null;
    }

    public boolean isExist(String login) {
        return clients.containsKey(login);

    }

    public Map<String, String[]> getClients() {
        return clients;
    }

    public void wtiteToDataBase(String login, String[] data) {
        File file = new File("D:\file.txt" );
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            writer.println();
            if (!clients.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder(login);
                for (String str : data) {
                    stringBuilder.append(str).append("\t");
                }
                stringBuilder.append("\n");
                writer.print(stringBuilder.toString());
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromDataBase(String login, String[] data) {
        File file = new File("D:\file.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String str = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            while ((str = bufferedReader.readLine()) != null) {

                String[] values = str.split("\t");
                login = values[0];
                data = Arrays.copyOfRange(values, 1, values.length);
                bufferedReader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
