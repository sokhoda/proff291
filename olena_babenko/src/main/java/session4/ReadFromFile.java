package session4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 27.09.15
 *
 *
 *Задание 1: необходимо создать файл, который содержит строчку Hello и необходимо прочитать данные с файла и вывести на экран в виде массива байт.
  Задание 2: вывести в виде строки на экран.
 *
 *
 *
 */
public class ReadFromFile {
    public static void main(String[] args) {
        Path file = Paths.get("Hello");
        SeekableByteChannel channel = null;

        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(20);
            int readed;
            while ((readed = channel.read(buffer)) > 0) {
                // print data from buffer
                System.out.println(Arrays.toString(buffer.array()));

                String str = new String(buffer.array(), 0, readed); //считывает ненулевые байты - ??
                System.out.println(str);
                buffer.rewind();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
