package com.marketshrimp.netty.protobuf.com.example.tutorial;

import com.example.tutorial.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/4
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MyDataInfo.Person person = (MyDataInfo.Person) msg;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
                .setName("田翔")
                .setAge(24)
                .setAddress("上海")
                .build();

        // 将消息发送给服务器端
        ctx.channel().writeAndFlush(person);
    }
}
