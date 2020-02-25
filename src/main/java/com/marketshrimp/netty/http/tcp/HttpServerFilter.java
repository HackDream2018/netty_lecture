package com.marketshrimp.netty.http.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/12
 */
public class HttpServerFilter extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 管道责任链(单线程)
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new ServerHandler());
    }
}
