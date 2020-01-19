package com.marketshrimp.netty.socket.wechatonetomore;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/12
 */
public class WechatClient {
    private int port;
    private String address;
    public WechatClient(int port, String address) {
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
                .handler(new WeChatClientFilter());
        try {
            Channel channel = client.connect(address, port).sync().channel();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                channel.writeAndFlush(br.readLine() + "\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) {
        new WechatClient(8080, "127.0.0.1").run();
    }

}
