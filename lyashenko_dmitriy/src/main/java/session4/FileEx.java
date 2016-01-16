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
 */
public class FileEx {
    public static void main(String[] args) {
        Path file = Paths.get("C:\\Users\\Solyk\\IdiaProjects\\Proff29\\proff29\\lyashenko_dmitriy\\src\\main\\resources\\Text.txt");
        SeekableByteChannel channel = null;

        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(20);
            int readed;
            while((readed = channel.read(buffer)) > 0) {

                System.out.println(Arrays.toString(buffer.array()));

                System.out.println(new String(buffer.array(), 0, readed));
                buffer.rewind();
                // print data from buffer
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
