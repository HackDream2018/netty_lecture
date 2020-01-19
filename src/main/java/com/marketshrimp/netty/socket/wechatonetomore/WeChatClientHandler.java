package com.marketshrimp.netty.socket.wechatonetomore;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/12
 */
public class WeChatClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
         System.out.println((String)msg);
    }
}
