package session4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by Юра on 27.12.2015.
 */
public class TaskFileChanel {

    public static void main(String[] args) {
//        Path file = Paths.get("src/main/resources/session4/text");
        Path file = Paths.get("Mytext");
        SeekableByteChannel channel = null;

        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(20);
            int readed;
            while((readed = channel.read(buffer)) > 0) {
//                buffer.getChar();

                System.out.println("Output...");
                Arrays.toString(buffer.array());
                System.out.println(Arrays.toString(buffer.array()));
                System.out.println(new String(buffer.array(),0,readed));
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
