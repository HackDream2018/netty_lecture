package com.marketshrimp.netty.socket.hearbeat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/12
 */
public class IdleEventFilter extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 超过5秒未读到Socket流管道中的数据则执行空闲状态处理器
        pipeline.addLast(new IdleStateHandler(5 , 5, 0, TimeUnit.SECONDS));
        // 处理器责任链, 单线程执行
        pipeline.addLast(new IdleEventHandler());
    }
}
