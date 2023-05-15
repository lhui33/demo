/*
 * # iohao.com . MR.L
 * Copyright (C) 2021 - 2022 double joker （262610965@qq.com） . All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kunke.sanguo.gate;

import com.iohao.game.bolt.broker.client.external.ExternalServer;
import com.iohao.game.bolt.broker.client.external.ExternalServerBuilder;
import com.iohao.game.bolt.broker.client.external.bootstrap.ExternalJoinEnum;
import com.iohao.game.bolt.broker.client.external.bootstrap.heart.IdleProcessSetting;
import com.iohao.game.bolt.broker.client.external.config.ExternalGlobalConfig;
import com.iohao.game.bolt.broker.core.client.BrokerAddress;
import com.iohao.game.bolt.broker.core.common.IoGameGlobalConfig;
import com.kunke.sanguo.cmd.LogicHallCmd;
import com.kunke.sanguo.gate.custom.IdleHookLong;

/**
 * @author MR.L
 * @date 2022-07-09
 */
public class GameExternal {
    public ExternalServer createExternalServer(int externalPort) {

        extractedIgnore();

//        IdleProcessSetting idleProcessSetting = new IdleProcessSetting()
//                .allIdleTime(45)
//                .readerIdleTime(45)
//                .writerIdleTime(45)
//                .idleHook(new IdleHookLong());

        // 游戏对外服 - 构建器
        ExternalServerBuilder builder = ExternalServer.newBuilder(externalPort)
                // websocket 方式连接
                .externalJoinEnum(ExternalJoinEnum.WEBSOCKET)
//                .enableIdle(idleProcessSetting)
                // Broker （游戏网关）的连接地址；如果不设置，默认也是这个配置
                .brokerAddress(new BrokerAddress("127.0.0.1", IoGameGlobalConfig.brokerPort));

        // 构建游戏对外服
        return builder.build();
    }

    private void extractedIgnore() {
        /*
         * 注意，权限相关验证配置在游戏对外服是正确的，因为是游戏对外服在控制访问验证
         * see https://www.yuque.com/iohao/game/tywkqv#qEvtB
         */
        var accessAuthenticationHook = ExternalGlobalConfig.accessAuthenticationHook;
        // 表示登录才能访问业务方法
        accessAuthenticationHook.setVerifyIdentity(false);
//        /*
//         * 由于 accessAuthenticationHook.verifyIdentity = true; 时，需要玩家登录才可以访问业务方法 （action）
//         *
//         * 在这可以配置一些忽略访问限制的路由。
//         * 这里配置的路由，表示不登录也可以进行访问
//         * 现在忽略的 3-1，是登录 action 的路由，所以当我们访问 3-1 路由时，可以不登录。
//         * 忽略的路由可以添加多个。
//         * LogicHallCmd.gameCmd, LogicHallCmd.getServerList  获取服务器列表
//         * LogicHallCmd.mainCmd, LogicHallCmd.loginVerify  登录校验
//         */
//        accessAuthenticationHook.addIgnoreAuthenticationCmd(LogicHallCmd.loginCmd, LogicHallCmd.loginVerify);
//        accessAuthenticationHook.addIgnoreAuthenticationCmd(LogicHallCmd.loginCmd, LogicHallCmd.boardCast);
    }
}
