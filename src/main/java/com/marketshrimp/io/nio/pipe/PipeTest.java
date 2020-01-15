package com.marketshrimp.io.nio.pipe;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/1/15
 */
public class PipeTest {

    @Test
    public void client() throws Exception {
        // 创建Pipe管道
        Pipe pipe = Pipe.open();
        // 将缓冲区数据写入Pipe管道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        byteBuffer1.put("ABC".getBytes());
        byteBuffer1.flip();
        sinkChannel.write(byteBuffer1);
        // 从Pipe管道里读数据到缓冲区
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        Pipe.SourceChannel sourceChannel = pipe.source();
        sourceChannel.read(byteBuffer2);
        System.out.println(new String(byteBuffer2.array()));
    }

}
