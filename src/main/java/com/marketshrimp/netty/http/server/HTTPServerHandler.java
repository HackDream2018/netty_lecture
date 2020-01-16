package com.marketshrimp.netty.http.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 处理请求TCP流管道中的数据
 * @date: 2019/5/4
 */
public class HTTPServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 处理器被添加
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler Added");
        super.handlerAdded(ctx);
    }

    /**
     * 处理器被删除
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler Removed");
        super.handlerRemoved(ctx);
    }

    /**
     * 连接注册
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Registered");
        super.channelRegistered(ctx);
    }

    /**
     * 连接取消注册
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Unregistered");
        super.channelUnregistered(ctx);
    }

    /**
     * 连接建立
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel open");
        super.channelActive(ctx);
    }

    /**
     * 连接断开
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel close");
        super.channelInactive(ctx);
    }

    /**
     * 读请求内容
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
         System.out.println("channel Read");
        if(msg instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest)msg;
            URI uri = new URI(httpRequest.uri());
            // 浏览器活动Title的请求不执行
            if("/favicon.ico".equals(uri.getPath())) {
                return;
            }

            // ByteBuf字节缓冲流, 内容的编码格式
            ByteBuf byteBuf = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
            // Http响应DefaultFullHttpResponse(http协议版本, 响应的状态码, 响应内容)
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1
                    , HttpResponseStatus.OK
                    , byteBuf);
            // 设置Http头信息
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes()); // 缓冲区内容长度
            // 响应到客户端
            ctx.writeAndFlush(response);
            // 与服务器断开连接
            ctx.close();
        }
    }
}
