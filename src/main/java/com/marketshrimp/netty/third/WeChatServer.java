package com.marketshrimp.netty.third;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 聊天客户端
 * @date: 2019/5/4
 */
public class WeChatServer {
    private int port;
    public WeChatServer(int port) {
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
                .childHandler(new WeChatServerFilter());
        try {
            // 绑定端口, 同步管道(管道就是连接)
            ChannelFuture channelFuture = server.bind(port).sync();
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
        new WeChatServer(8080).run();
    }
}
