package com.marketshrimp.io.nio.channel.filechannel;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/1/14
 */
public class FileChannelTest {

    @Test
    public void copyContent()throws Exception {
        String sourceFilePath = "C:\\Users\\alw\\Desktop\\二期运营平台\\NIO\\data.txt";
        String destFilePath = "C:\\Users\\alw\\Desktop\\二期运营平台\\NIO\\data2.txt";
        FileChannel sourceFileChannel = new RandomAccessFile(sourceFilePath, "rw").getChannel();
        FileChannel destFileChannel = new RandomAccessFile(destFilePath, "rw").getChannel();

        //缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 流管道中的数据读到缓冲区
        sourceFileChannel.force(true);
        sourceFileChannel.read(byteBuffer);
        // 将缓冲区的读模式改为写模式
        byteBuffer.flip();
        // 缓冲区数据写到流管道
        destFileChannel.write(byteBuffer);
        // 初始化缓冲区(清空缓冲区&&模式重置为读)
        byteBuffer.clear();
    }


    /**
     * 流管道数据分散到多个缓冲区
     */
    @Test
    public void scatter()throws Exception {
        String sourceFilePath = "C:\\Users\\alw\\Desktop\\二期运营平台\\NIO\\data.txt";
        String destFilePath = "C:\\Users\\alw\\Desktop\\二期运营平台\\NIO\\data2.txt";
        FileChannel sourceFileChannel = new RandomAccessFile(sourceFilePath, "rw").getChannel();
        FileChannel destFileChannel = new RandomAccessFile(destFilePath, "rw").getChannel();

        //缓冲区
        ByteBuffer header = ByteBuffer.allocate(1);
        ByteBuffer body = ByteBuffer.allocate(2);
        ByteBuffer[] byteBufferArrays = {header, body};
        // 流管道中的数据读到缓冲区(先读满header, 再读满body)
        sourceFileChannel.read(byteBufferArrays);
        for(ByteBuffer buffer : byteBufferArrays) {
            // 将缓冲区的读模式改为写模式
            buffer.flip();
            // 缓冲区数据写到流管道
            destFileChannel.write(buffer);
            // 初始化缓冲区(清空缓冲区&&模式重置为读)
            buffer.clear();
        }
    }

    /**
     * 多个缓冲区数据聚集到流管道
     */
    @Test
    public void gather()throws Exception {
        String sourceFilePath = "C:\\Users\\alw\\Desktop\\二期运营平台\\NIO\\data.txt";
        String destFilePath = "C:\\Users\\alw\\Desktop\\二期运营平台\\NIO\\data2.txt";
        FileChannel sourceFileChannel = new RandomAccessFile(sourceFilePath, "rw").getChannel();
        FileChannel destFileChannel = new RandomAccessFile(destFilePath, "rw").getChannel();

        //缓冲区
        ByteBuffer header = ByteBuffer.allocate(1);
        ByteBuffer body = ByteBuffer.allocate(2);
        ByteBuffer[] byteBufferArrays = {header, body};
        // 流管道中的数据读到缓冲区(先读满header, 再读满body)
        sourceFileChannel.read(byteBufferArrays);
        for(ByteBuffer buffer : byteBufferArrays) {
            // 将缓冲区的读模式改为写模式
            buffer.flip();
        }
        destFileChannel.write(byteBufferArrays);
        for(ByteBuffer buffer : byteBufferArrays) {
            // 初始化缓冲区(清空缓冲区&&模式重置为读)
            buffer.clear();
        }
    }

}
