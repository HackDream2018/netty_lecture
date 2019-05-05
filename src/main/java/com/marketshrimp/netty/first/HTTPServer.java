package com.marketshrimp.netty.first;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: HTTP服务端(请求响应)
 * @date: 2019/5/4
 */
public class HTTPServer {
    private int port;
    public HTTPServer(int port) {
        this.port = port;
    }
    public void run() {
        // 主线程组, 接收客户端请求的连接, 轮询注册key
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 工作线程组, 处理接收的数据, IO操作
        EventLoopGroup workGroup = new NioEventLoopGroup();

        // 服务器启动类
        ServerBootstrap server = new ServerBootstrap().group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new HTTPServerFilter());
        try {
            // 同步处理管道
            ChannelFuture channelFuture = server.bind(port).sync();
            // 关闭管道监听
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭线程组
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) {
        new HTTPServer(8080).run();
    }

}
