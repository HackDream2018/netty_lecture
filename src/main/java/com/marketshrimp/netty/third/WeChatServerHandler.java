package com.marketshrimp.netty.third;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/4
 */
public class WeChatServerHandler extends ChannelInboundHandlerAdapter {

    // 管道组, 用于存储多个管道
    private ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 监听处理器加入后执行
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 遍历所有管道组里的管道(服务端广播客户端管道)
        channelGroup.writeAndFlush("[server] -" + channel.remoteAddress() + "join\n");
        // 将新加入的管道加入到管道组
        channelGroup.add(channel);
    }

    /**
     * 监听处理器移除后执行
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 遍历所有管道组里的管道(服务端广播客户端管道)
        channelGroup.writeAndFlush("[server] -" + channel.remoteAddress() + "leave\n");
        // netty会自动将断开的处理器从管道组中移除
    }

    /**
     * 监听管道建立
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "online");
    }


    /**
     * 监听管道断开
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "disconnect");
    }

    /**
     * 监听处理管道
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        // 发送消息的客户端的地址要区别开(广播管道组的管道)
        channelGroup.forEach(item -> {
            if(channel != item) {
                ctx.writeAndFlush(String.format("[%s]send content: %s \n", channel.remoteAddress(), msg));
            }else {
                ctx.writeAndFlush(String.format("myself send content: %s \n", msg));
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
