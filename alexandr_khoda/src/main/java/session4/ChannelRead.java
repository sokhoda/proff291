package session4;



import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by s_okhoda on 27.12.2015.
 */
public class ChannelRead {
    public static void main(String[] args) {
//        Path file = Paths.get("E:\\IdeaProjects\\proff29\\alexandr_khoda\\Text.txt");
        Path file = Paths.get("Text2.txt");
        SeekableByteChannel channel = null;

        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(20);
            int readed;

            while((readed = channel.read(buffer)) > 0) {
                // print data from buffer
                byte [] byteArr = buffer.array();
//                for (int i = 0; i < byteArr.length ; i++) {
//                    System.out.println((int) byteArr[i]);
//                }
//                System.out.println(Arrays.toString(byteArr));
//                System.out.println(new String (byteArr, Charset.defaultCharset()));
                System.out.println(new String (buffer.array(), 0,readed) +  " " + Integer.toString(readed));
                //buffer.rewind();

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
