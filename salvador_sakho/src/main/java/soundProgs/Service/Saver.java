package soundProgs.Service;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by ${BIM} on 24.02.2016.
 */
public class Saver {

    public Saver() {
    }

    public static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;

        sourceChannel = new FileInputStream(source).getChannel();///Из этого файла
        destChannel = new FileOutputStream(dest).getChannel();///В этот файл
        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

        sourceChannel.close();
        destChannel.close();
    }

}