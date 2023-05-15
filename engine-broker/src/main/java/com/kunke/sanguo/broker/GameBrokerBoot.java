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
package com.kunke.sanguo.broker;

import com.iohao.game.bolt.broker.server.BrokerServer;
import com.iohao.game.bolt.broker.server.BrokerServerBuilder;

/**
 * @author MR.L
 * @date 2022-07-09
 */
public class GameBrokerBoot {
    public BrokerServer createBrokerServer() {
        // broker （游戏网关） 构建器
        BrokerServerBuilder brokerServerBuilder = BrokerServer.newBuilder();
        return brokerServerBuilder.build();
    }
}
