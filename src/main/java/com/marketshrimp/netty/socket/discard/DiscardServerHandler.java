package com.marketshrimp.netty.socket.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     *  接收到客户端消息执行此方法
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 必须要try
        try {
            // 释放接收到的消息
            ReferenceCountUtil.release(msg);
            ByteBuf in = (ByteBuf) msg;
            System.out.println(in.toString(CharsetUtil.US_ASCII));
        } catch (Exception e) {

        }
    }


}