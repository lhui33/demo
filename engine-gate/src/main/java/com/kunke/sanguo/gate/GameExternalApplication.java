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

import com.iohao.game.action.skeleton.core.IoGameGlobalSetting;
import com.iohao.game.action.skeleton.core.codec.JsonDataCodec;
import com.iohao.game.bolt.broker.client.external.ExternalServer;

/**
 * 单独启动类：游戏对外服
 *
 * @author MR.L
 * @date 2022-07-09
 */
public class GameExternalApplication {
    public static void main(String[] args) {

        // 设置 json 编解码。
        IoGameGlobalSetting.setDataCodec(new JsonDataCodec());
        // 对外开放的端口
        int externalPort = 10100;

        // 构建游戏对外服
        ExternalServer externalServer = new GameExternal().createExternalServer(externalPort);

        // 启动游戏对外服
        externalServer.startup();
    }
}
