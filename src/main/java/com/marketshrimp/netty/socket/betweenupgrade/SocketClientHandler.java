package com.marketshrimp.netty.socket.betweenupgrade;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.time.LocalDateTime;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/4
 */
public class SocketClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server address: " + ctx.channel().remoteAddress() + "server response content: "+ msg);
        ctx.writeAndFlush("from client: " + LocalDateTime.now());
    }

    /**
     * 客户端主动发送信息到服务端, 连接建立则发送
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("from client say hello~");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
