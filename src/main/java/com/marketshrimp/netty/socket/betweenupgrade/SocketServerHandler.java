package com.marketshrimp.netty.socket.betweenupgrade;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.UUID;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 自定义管道处理器(ChannelInboundHandlerAdapter请求进来的适配器, 处理接收的数据)
 * @date: 2019/5/4
 */
public class SocketServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * @param ctx 管道处理器上下文里有操作方法
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client address: " + ctx.channel().remoteAddress() + "client send content: "+ msg);
        ctx.writeAndFlush("from server: " + UUID.randomUUID());
    }

    /**
     *  在遇到不同异常的情况下有不同的实现，比如关闭连接之前发送一个错误码的响应消息
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
