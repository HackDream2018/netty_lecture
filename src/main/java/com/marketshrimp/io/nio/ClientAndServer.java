package com.marketshrimp.io.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/1/15
 */
public class ClientAndServer {

    // 本地字符集
    private static final String LocalCharSetName = "UTF-8";

    // 本地服务器监听的端口
    private static final int Listenning_Port = 80;

    // 缓冲区大小
    private static final int Buffer_Size = 1024;

    // 超时时间,单位毫秒
    private static final int TimeOut = 3000;

    @Test
    public void client()throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",Listenning_Port));
        // 循环发送
        for(int i = 0; i < 100; i++) {
            String sendData = "content: " + System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.wrap(sendData.getBytes(LocalCharSetName));
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
            Thread.sleep(1000 * 2);
        }
        socketChannel.close();
    }

    @Test
    public void server() throws Exception {
        // 创建TCP通道并监听
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 非阻塞通道
        serverSocketChannel.configureBlocking(false);
        // 配置终端Port
        serverSocketChannel.bind(new InetSocketAddress(Listenning_Port));
        System.out.println("非阻塞服务端启动!");
        // 创建独立的线程, 用于轮询多路复用器Selector [start]
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); // 将TCP通道绑定"新加入的客户事件(注册Key)"后注册多路复用器
        while (true) {
            // 主线程轮询多路复用器注册的Key事件, 得到就绪通道
            int hasChannel = selector.select(TimeOut);
            if (0 == hasChannel) {
                System.out.println("此次轮询没有就绪通道!");
                continue;
            }
            // 监听到有就绪通道, 说明有客户请求了;
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                // 根据key事件的不同做IO处理
                if (key.isAcceptable()) { // 新到客户端加入, 调用accept()接收客户端请求
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = channel.accept();
                    // 绑定新通道参数: 如非阻塞, 缓冲区 并将其继续注册到Selector上
                    clientChannel.configureBlocking(false);
                    // 通过Selector监听通道时获取读事件通道
                    clientChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(Buffer_Size));
                } else if (key.isReadable()) { // 读事件通道
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    // 得到SelectionKey的附加信息
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    long bytesRead = clientChannel.read(buffer);
                    if (-1 == bytesRead) {
                        // 通道中没有数据可读
                        clientChannel.close();
                    } else {
                        // 将缓冲区的读模式转成写
                        buffer.flip();
                        // 对数据进行解码
                        String receivedStr = Charset.forName(LocalCharSetName).newDecoder().decode(buffer).toString();
                        System.out.println(String.format("收到客户端信息: %s", receivedStr));
                        // 数组数据存入缓冲区
                        String sendStr = "客户端, 服务端已经收到你的消息!" + receivedStr;
                        buffer = ByteBuffer.wrap(sendStr.getBytes(LocalCharSetName));
                        clientChannel.write(buffer);
                    }
                }
                // 处理完后从Selector中移除
                keyIterator.remove();
            }
        }

    }
}
