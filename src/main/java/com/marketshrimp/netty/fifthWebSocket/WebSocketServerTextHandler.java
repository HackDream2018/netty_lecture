package com.marketshrimp.netty.fifthWebSocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/18
 */
public class WebSocketServerTextHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
         System.out.println("handle added id: " + ctx.channel().id().asLongText());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof TextWebSocketFrame) {
            TextWebSocketFrame textMsg = (TextWebSocketFrame)msg;
             System.out.println("reject content: "+ textMsg.text());
             ctx.writeAndFlush(new TextWebSocketFrame("server current dateTime: " + LocalDateTime.now()));
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handle removed id: " + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
         System.out.println("happen exception");
         ctx.close();
    }
}
