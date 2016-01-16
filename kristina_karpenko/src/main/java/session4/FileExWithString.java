package session4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by Администратор on 27.12.2015.
 */
public class FileExWithString {
    public static void main(String[] args) {
        Path file = Paths.get("file.txt");
        SeekableByteChannel channel = null;
        byte[] list;
        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(10);
            int readed;
            while ((readed = channel.read(buffer)) > 0) {
               // list = (byte[]) buffer.array();
                System.out.println(new String(buffer.array(),1,readed));
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
