package session3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/*
Из файла прочитать строку и вывести в виде массива и строки
 */
public class Task1 {
    public static void main(String[] args) {
        Path file = Paths.get("D:\\text.txt");
        SeekableByteChannel channel = null;

        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(5);
            int readed;
            byte[] arr = new byte[10];

            while((readed = channel.read(buffer)) > 0) {
                buffer.flip();
                arr=buffer.array();
                System.out.println(Arrays.toString(arr));
                System.out.println(new String(arr, 0, readed));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
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
