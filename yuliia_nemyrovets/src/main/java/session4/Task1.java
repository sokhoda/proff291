package session4;


import javassist.bytecode.ByteArray;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by Юлия on 27.12.2015.
 */
public class Task1 {
    public static void main(String[] args) {

        Path file = Paths.get("text.txt");
        SeekableByteChannel channel = null;

        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(5);

            int readed;
            while ((readed = channel.read(buffer)) > 0) {

                byte[] bt = (byte[]) buffer.array();
                System.out.println(Arrays.toString(bt));
                // System.out.println(new String(bt));
                System.out.println(new String(buffer.array(), 0, readed));
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


