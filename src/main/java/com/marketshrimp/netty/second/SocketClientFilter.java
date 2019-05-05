package com.marketshrimp.netty.second;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/4
 */
public class SocketClientFilter extends ChannelInitializer<SocketChannel> {

    /**
     * 管道建立执行
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 单线程来操作管道处理器, 是ChannelHandler的容器
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 编解码
        pipeline.addLast("lengthFieldBasedFrameDecoder"
                , new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
        pipeline.addLast("lengthFieldPrepender", new LengthFieldPrepender(4));
        // 字符串解码和编码
        pipeline.addLast("stringDecoder", new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast("stringEncoder", new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast("socketClientHandler", new SocketClientHandler());
    }
}
