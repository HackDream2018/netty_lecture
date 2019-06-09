package com.marketshrimp.netty.protobuf.com.example.tutorial;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/9
 */
public class Server {

    private int port;
    public Server(int port) {
        this.port = port;
    }
    public void run() {
        // 主线程组, 用于接收请求注册
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // 工作线程组, 监听管道事件
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        // 服务端启动类
        ServerBootstrap server = new ServerBootstrap()
                .group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO)) // 主工作组加入日志
                .childHandler(new ServerFilter());
        try {
            // 绑定端口, 同步管道
            ChannelFuture channelFuture = server.bind(new InetSocketAddress(port)).sync();
            // 关闭管道监听
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 关闭线程组
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) {
        new Server(8080).run();
    }

}
