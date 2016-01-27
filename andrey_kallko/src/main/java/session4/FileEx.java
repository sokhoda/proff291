package session4;

/**
 * Created by elenabugercuk on 27.12.15.
 */

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
public class FileEx  {
    byte  massa[]=new byte[10];

    public FileEx(){}



    public static void main(String[] args)throws Exception {
        FileEx proba = new FileEx();
        Path file = Paths.get("textHellow.txt");
        SeekableByteChannel channel = null;


        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(10);
           // System.out.println(" start Pos=" + buffer.position() + " Cap=" + buffer.capacity() + " lim=" + buffer.limit() + " Rem=" + buffer.remaining());

            int readed;
            while((readed = channel.read(buffer)) > 0) {


                proba.massa = buffer.array();

                if (readed !=buffer.capacity()){
                    Arrays.fill(proba.massa, buffer.position(), buffer.limit(),(byte) 0);
                }




                String rex = new String(proba.massa);
                System.out.print(rex);
                buffer.flip();

                Arrays.fill(proba.massa, (byte) 0);// Важно!!! обнуляет массив байтов, чтобы в последней строчке не выпал мусор из предпоследней.

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
