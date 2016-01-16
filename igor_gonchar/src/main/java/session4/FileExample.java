package session4;

import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Home on 27.12.2015.
 */
public class FileExample {
    public static void main(String[] args) {

        Path file = Paths.get("D:\\Pragramming\\Java\\Intelij Projects\\proff29\\igor_gonchar\\src\\main\\resources\\session4\\Hello.txt");
        SeekableByteChannel channel = null;

        try {

            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(10);
            int readed;

            while ((readed = channel.read(buffer)) > 0) {

                //System.out.println(new String(buffer.array()));
                System.out.println(new String(buffer.array(), 0, readed));
                buffer.rewind();

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
