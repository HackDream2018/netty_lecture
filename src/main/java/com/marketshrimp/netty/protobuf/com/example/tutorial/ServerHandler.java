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
        MyDataInfo.MyMessage myMessage = (MyDataInfo.MyMessage) msg;
        switch (myMessage.getDataType()) {
            case PersonType:
                MyDataInfo.Person person = myMessage.getPerson();
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                break;
            case AnimalType:
                MyDataInfo.Animal animal = myMessage.getAnimal();
                 System.out.println(animal.getName());
                 System.out.println(animal.getGender());
        }
    }
}
