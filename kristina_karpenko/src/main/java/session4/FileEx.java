package session4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//читать из файла. вывести в масив байтов на экран
//вывести в виде строки на экран

public class FileEx {
    public static void main(String[] args) {
        Path file = Paths.get("file.txt");
        SeekableByteChannel channel = null;
        byte[] list;
        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(10);
           // int readed;
            while ((channel.read(buffer)) > 0) {
                list =  buffer.array();
                System.out.println(Arrays.toString(list));
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
