package com.marketshrimp.netty.protobuf.com.example.tutorial;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/4
 */
public class Client {
    private int port;
    private String address;
    public Client(int port, String address) {
        this.port = port;
        this.address = address;
    }
    public void run() {
        // 主线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // 客户端启动类
        Bootstrap client = new Bootstrap()
                .group(bossGroup)
                .channel(NioSocketChannel.class)
                .handler(new ClientFilter());
        try {
            ChannelFuture channelFuture = client.connect(address, port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) {
        new Client(8080, "127.0.0.1").run();
    }
}
