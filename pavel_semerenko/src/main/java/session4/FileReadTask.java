package session4;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by Pavel on 27.12.2015.
 */
public class FileReadTask {
    public static void main(String[] args) {
        Path file = Paths.get(new File("").getAbsolutePath() + "//pavel_semerenko//src//main//resources//text.txt");
        SeekableByteChannel channel = null;

        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(20);

            int readed = 0;
            while ((readed = channel.read(buffer)) > 0){
                System.out.println(Arrays.toString(buffer.array()));
                System.out.println(new String(buffer.array(), 0, readed));
                buffer.rewind();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
