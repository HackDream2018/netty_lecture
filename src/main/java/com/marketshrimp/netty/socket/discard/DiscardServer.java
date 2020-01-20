package com.marketshrimp.netty.socket.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 服务端收到消息后丢弃且不响应
 * 客户端: telnet模式
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws Exception{
        // bossGroup 主线程(Selector选择器, Netty采用线程池方式监听客户端的事件)- 接收请求且分派任务到工作线程执行;
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // workerGroup 工作线程- 执行任务
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup)
                    // 主线程监听通道
                    .channel(NioServerSocketChannel.class)
                    // 定义工作线程的handler链，责任链模式
                    .childHandler(new DiscardServerFilter())
                    .option(ChannelOption.SO_BACKLOG, 1) // socket队列长度: 队列满后客户端连接将被拒绝
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // TCP心跳包, 检查TCP连接的存活性

            // 绑定端口
            ChannelFuture f = server.bind(port).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args)throws Exception {
        new DiscardServer(8080).run();
    }
}