package session4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEx {
    public static void main(String[] args) {
        Path file = Paths.get("text.txt");
        SeekableByteChannel cannel = null;

        try {
            cannel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(20);

            int readed;
            while ((readed = cannel.read(buffer)) > 0) {
                System.out.println(new String(buffer.array(), 0, readed));

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cannel != null) {
                try {
                    cannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
