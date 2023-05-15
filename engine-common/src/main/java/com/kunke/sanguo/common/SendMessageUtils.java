package com.kunke.sanguo.common;

import com.google.common.collect.Lists;
import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.action.skeleton.core.CmdInfo;
import com.iohao.game.action.skeleton.core.commumication.BroadcastContext;
import com.iohao.game.action.skeleton.core.commumication.BrokerClientContext;
import com.iohao.game.action.skeleton.core.flow.ActionMethodResultWrap;
import com.iohao.game.action.skeleton.core.flow.FlowContext;
import com.iohao.game.action.skeleton.core.flow.attr.FlowAttr;
import com.iohao.game.action.skeleton.protocol.HeadMetadata;
import com.iohao.game.action.skeleton.protocol.ResponseMessage;
import com.iohao.game.bolt.broker.core.client.BrokerClientHelper;

import java.util.List;

public class SendMessageUtils {

    // 私有化构造方法
    private SendMessageUtils(){}

    // 广播给指定用户列表，指定内容
    public static void sendByUserIds(FlowContext flowContext, Object methodResult, List<Integer> userIds) {
        // 获取路由码
        int mergeCode = flowContext.getActionCommand().getCmdInfo().getCmdMerge();
        // 需要传输的数据包
        flowContext.setMethodResult(methodResult);
        // 获取业务流总线中的方法包装类
        BarSkeleton barSkeleton = flowContext.getBarSkeleton();
        ActionMethodResultWrap actionMethodResultWrap = barSkeleton.getActionMethodResultWrap();
        // 结果包装器, 将result转义成编码结果集，并将捕获的运行异常设置到responseStatus中
        actionMethodResultWrap.wrap(flowContext);
        // 获取到包装类处理后的Response对象
        ResponseMessage responseMessage = flowContext.getResponse();
        HeadMetadata headMetadata = responseMessage.getHeadMetadata();
        // 路由设置
        headMetadata.setCmdMerge(mergeCode);
        // 获取用户远程连接信息
        BrokerClientContext brokerClientContext = flowContext.option(FlowAttr.brokerClientContext);
        // 推送响应 （广播消息）给指定的用户列表
        BroadcastContext broadcastContext = brokerClientContext.getBroadcastContext();
        List<Long> userIdLong = Lists.newArrayList();
        // 转义UserIds
        userIds.forEach(i -> userIdLong.add(Long.valueOf(i.toString())));
        broadcastContext.broadcast(responseMessage, userIdLong);
    }

    /**
     * 广播给固定用户群
     * @param mainCmd   主路由
     * @param subCmd    次路由
     * @param message   消息体
     * @param userIds   用户id集合
     */
    public static void sendByUserIds(int mainCmd, int subCmd, Object message, List<Integer> userIds) {
        // 广播消息的路由
        CmdInfo cmdInfo = CmdInfo.getCmdInfo(mainCmd, subCmd);
        // 广播上下文
        BroadcastContext broadcastContext = BrokerClientHelper.me().getBroadcastContext();
        List<Long> userIdLong = Lists.newArrayList();
        // 转义UserIds
        userIds.forEach(i -> userIdLong.add(Long.valueOf(i.toString())));
        broadcastContext.broadcast(cmdInfo, message, userIdLong);
    }

    /**
     * 广播
     * @param mainCmd   主路由
     * @param subCmd    次路由
     * @param message   消息体
     */
    public static void broadcast(int mainCmd, int subCmd, Object message) {
        // 广播消息的路由
        CmdInfo cmdInfo = CmdInfo.getCmdInfo(mainCmd, subCmd);
        // 广播上下文
        BroadcastContext broadcastContext = BrokerClientHelper.me().getBroadcastContext();
        broadcastContext.broadcast(cmdInfo, message);
    }
}
