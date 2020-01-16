package com.marketshrimp.netty.http.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 *      注册连接后会执行初始化管道, 管道链来管理多个管道处理器;
 * @date: 2019/5/4
 */
public class HTTPServerFilter extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 单线程来操作管道处理器, 是ChannelHandler的容器
        ChannelPipeline pipeline = socketChannel.pipeline();
        // addLast(别名, 处理器)
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        // 在管道链中加入自定义管道处理器
        pipeline.addLast("httpServerHandler", new HTTPServerHandler());
    }
}
