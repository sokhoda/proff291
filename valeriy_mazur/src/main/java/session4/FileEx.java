package session4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by Valeriy on 27.12.2015.
 */
public class FileEx {
    public static void main(String[] args) {
        Path file = Paths.get("text.txt");
        SeekableByteChannel channel = null;

        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(20);
            int readed;
            while((readed = channel.read(buffer)) > 0) {
                String result = new String (buffer.array());
                System.out.println(Arrays.toString(buffer.array()));
                System.out.println(result.toString());
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
