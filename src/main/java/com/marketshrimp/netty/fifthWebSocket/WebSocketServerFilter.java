package com.marketshrimp.netty.fifthWebSocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/12
 */
public class WebSocketServerFilter extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 管道责任链(单线程)
        ChannelPipeline pipeline = socketChannel.pipeline();
        // http编码和解码的处理器
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        // 以块的方式写入的处理器
        pipeline.addLast("chunkedWriteHandler", new ChunkedWriteHandler());
        // http聚合处理器(netty会将http数据分成多个块后处理, http聚合处理器能将多个块聚合成一个大块载体内容长度为8192)
        pipeline.addLast("httpObjectAggregator", new HttpObjectAggregator(8192));
        // websocket的访问格式 ws://serverAddress:port/content_path(websocketPath是上下文开头)
        pipeline.addLast("webSocketServerProtocolHandler", new WebSocketServerProtocolHandler("/ws"));

        pipeline.addLast("webSocketServerHandler", new WebSocketServerTextHandler());
    }
}
