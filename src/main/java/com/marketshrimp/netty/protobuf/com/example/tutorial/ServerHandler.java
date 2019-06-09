package com.marketshrimp.netty.protobuf.com.example.tutorial;

import com.example.tutorial.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/18
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof MyDataInfo.Person) {
            MyDataInfo.Person person = (MyDataInfo.Person) msg;
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getAddress());
        }
    }

}
