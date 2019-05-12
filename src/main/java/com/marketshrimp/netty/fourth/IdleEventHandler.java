package com.marketshrimp.netty.fourth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/12
 */
public class IdleEventHandler extends ChannelInboundHandlerAdapter {

    /**
     * 触发用户事件(读写)
     * @param evt:事件类型
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 事件是空闲状态事件
        if(evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent)evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "readEvent";
                    break;
                case WRITER_IDLE:
                    eventType = "writeEvent";
                    break;
                case ALL_IDLE:
                    eventType = "readWriteEvent";
            }
             System.out.println(ctx.channel().remoteAddress() + " 超时事件: " + eventType);
            ctx.channel().close();
        }
    }
}
