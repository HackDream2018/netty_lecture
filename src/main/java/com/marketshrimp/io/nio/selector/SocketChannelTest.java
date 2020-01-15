package com.marketshrimp.io.nio.selector;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/1/15
 */
public class SocketChannelTest {

    @Test
    public void client()throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",80));
        // 循环发送
        for(int i = 0; i < 100; i++) {
            String sendData = "content: " + System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.wrap(sendData.getBytes("utf-8"));
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
            Thread.sleep(1000 * 2);
        }
        socketChannel.close();
    }

    @Test
    public void server()throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        // 为Socket连接绑定处理的IO的流管道
        serverSocketChannel.socket().bind(new InetSocketAddress(80));
        // 将Socket流管道绑定监听事件后注册进Selector组件
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        
        while(true) {
            // Socket轮询器里, 4秒内没可读的Socket重新轮询
           if(selector.select(1000 * 4) == 0) {
                System.out.println("服务器在等待");
                continue;
           }
           // 遍历Socket轮询器里的Socket流管道
            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
            while(selectionKeys.hasNext()) {
                SelectionKey socketKey = selectionKeys.next();
                // 取出服务器接收的新Socket连接
                if(socketKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    Socket socket = socketChannel.socket();
                    System.out.println("connected to : " + socket.getRemoteSocketAddress());
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }

                // 取出可读的Socket流管道
                if(socketKey.isReadable()) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    SocketChannel socketChannel = (SocketChannel)socketKey.channel();
                    int readCount = socketChannel.read(byteBuffer);
                    // 如果没数据则关闭
                    if(readCount == -1) {
                        socketChannel.close();
                        socketKey.cancel();
                        return;
                    }
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit(), "utf-8"));
                    byteBuffer.clear();
                }
            }
            selectionKeys.remove();
        }
    }

}
