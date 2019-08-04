package com.marketshrimp.netty.protobuf.com.example.tutorial;

import com.example.tutorial.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Random;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/4
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.MyMessage myMessage = null;
        int randomInt = new Random().nextInt(2);
        switch(randomInt) {
            case 0:
                myMessage = MyDataInfo.MyMessage.newBuilder()
                        .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                        .setPerson(
                                MyDataInfo.Person.newBuilder()
                                        .setName("田翔")
                                        .setAge(24)
                                        .setAddress("上海")
                                        .build()
                        ).build();
                break;
            case 1:
                myMessage =  MyDataInfo.MyMessage.newBuilder()
                        .setDataType(MyDataInfo.MyMessage.DataType.AnimalType)
                        .setAnimal(
                                MyDataInfo.Animal.newBuilder()
                                        .setName("苏格兰边牧")
                                        .setGender("公狗")
                                        .build()
                        ).build();
        }
        
        // 将消息发送给服务器端
        ctx.channel().writeAndFlush(myMessage);
    }
}
