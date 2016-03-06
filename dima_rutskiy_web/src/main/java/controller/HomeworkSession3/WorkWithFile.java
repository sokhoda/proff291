package controller.HomeworkSession3;

import java.io.*;
import java.util.*;

/**
 * Created by Rrr on 22.01.2016.
 */
public class WorkWithFile {
    public static void write(String fileName, String text) {
        //Определяем файл
        File file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                out.print(text);


            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String read(String fileName) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        exists(fileName);

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( fileName));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();

    }

    public static void update(String nameFile, String newText) throws FileNotFoundException {
        exists(fileName);
        StringBuilder sb = new StringBuilder();
        String oldFile = read(fileName);
        sb.append(oldFile);
        sb.append(System.getProperty("line.separator"));
        sb.append(newText);
        write(nameFile, sb.toString());

    }
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

   static Map<String,String> usersMap=new HashMap<String,String>();
    public static Map<String, String> stringToMap(String nameFile) throws FileNotFoundException {
        exists(fileName);

        String ourFile = read(fileName);

        StringTokenizer st = new StringTokenizer(ourFile, "\n");
        StringTokenizer st2;
        while (st.hasMoreTokens()) {

            st2 = new StringTokenizer(st.nextToken(), " ");
            while (st2.hasMoreTokens()) {
                String log = st2.nextToken();
                String pas = st2.nextToken();

                usersMap.put(log, pas);
            }
        }

        return usersMap;
    }

    private static String text = "This new"+System.getProperty("line.separator")+
            "Th text2"+System.getProperty("line.separator")     ;
    private static String fileName = "C://a.txt";

    public static void main(String[] args) throws FileNotFoundException {

        //Запись в файл
        //WorkWithFile.write(fileName, text);

        //WorkWithFile.stringToMap(fileName);

        String usersList=WorkWithFile.read(fileName);
        Map<String, String> m=WorkWithFile.stringToMap(usersList);
        System.out.println(m);

    }
}
