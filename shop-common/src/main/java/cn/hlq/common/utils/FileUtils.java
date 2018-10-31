package cn.hlq.common.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class FileUtils {
    public static void nioCopyFile(String resource,String destination) throws IOException {
        FileInputStream fin = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);
        FileChannel readChannel = fin.getChannel();
        FileChannel writeChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true)
        {
            buffer.clear();
            int len = readChannel.read(buffer);
            if(len==-1){
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }



}
