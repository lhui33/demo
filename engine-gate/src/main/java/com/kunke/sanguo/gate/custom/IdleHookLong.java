package com.kunke.sanguo.gate.custom;

import com.iohao.game.action.skeleton.core.exception.ActionErrorEnum;
import com.iohao.game.bolt.broker.client.external.bootstrap.ExternalKit;
import com.iohao.game.bolt.broker.client.external.bootstrap.heart.IdleHook;
import com.iohao.game.bolt.broker.client.external.bootstrap.message.ExternalMessage;
import com.iohao.game.bolt.broker.client.external.bootstrap.message.ExternalMessageCmdCode;
import com.iohao.game.bolt.broker.client.external.session.UserSession;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdleHookLong implements IdleHook {
    @Override
    public boolean callback(ChannelHandlerContext ctx, IdleStateEvent event, UserSession userSession) {
        IdleState state = event.state();
        if (state == IdleState.READER_IDLE) {
            /* 读超时 */
            log.debug("READER_IDLE 读超时");
        } else if (state == IdleState.WRITER_IDLE) {
            /* 写超时 */
            log.debug("WRITER_IDLE 写超时");
        } else if (state == IdleState.ALL_IDLE) {
            /* 总超时 */
            log.debug("ALL_IDLE 总超时");
        }

        ExternalMessage externalMessage = new ExternalMessage();
        externalMessage.setCmdCode(ExternalMessageCmdCode.idle);
        // 错误码
        externalMessage.setResponseStatus(ActionErrorEnum.idleErrorCode.getCode());
        // 错误消息
        externalMessage.setValidMsg(ActionErrorEnum.idleErrorCode.getMsg() + " : " + state.name());
        log.info("触发了心跳事件: {}", externalMessage);
        log.info("state.name(): {}", state.name());
        // 通知客户端，触发了心跳事件
        ctx.writeAndFlush(externalMessage);

        return true;
    }
}