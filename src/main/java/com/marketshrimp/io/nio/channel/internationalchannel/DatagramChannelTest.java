package com.marketshrimp.io.nio.channel.internationalchannel;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/1/13
 */
public class DatagramChannelTest {


    @Test
    public void send()throws Exception {
        String sendData = "content " + System.currentTimeMillis();
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.clear();
        byteBuffer.put(sendData.getBytes());
        byteBuffer.flip();
        datagramChannel.send(byteBuffer, new InetSocketAddress("127.0.0.1", 80));
        datagramChannel.close();
    }

    @Test
    public void receive()throws Exception {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        datagramChannel.bind(new InetSocketAddress("127.0.0.1", 80));
        // 将处理Socket的流管道注册到Selector组件
        Selector selector = Selector.open();
        datagramChannel.register(selector, SelectionKey.OP_READ);
        while(selector.select() > 0) {
            Iterator<SelectionKey> socketKeysIterator = selector.selectedKeys().iterator();
            while (socketKeysIterator.hasNext()) {
                SelectionKey socketKey = socketKeysIterator.next();
                if(socketKey.isReadable()) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    datagramChannel.receive(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit(), "utf-8"));
                    byteBuffer.clear();
                }
            }
            socketKeysIterator.remove();
        }
    }
}
