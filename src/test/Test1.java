package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test1 {

    public static void main(String[] args) throws IOException {


        RandomAccessFile aFile = new RandomAccessFile("D:/temp/test.txt","rw");

        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("READ" + bytesRead);
            buf.flip();
        }

        while (buf.hasRemaining()) {
            System.out.println((char) buf.get());
        }

        buf.clear();
        bytesRead = inChannel.read(buf);
        aFile.close();


    }
}


