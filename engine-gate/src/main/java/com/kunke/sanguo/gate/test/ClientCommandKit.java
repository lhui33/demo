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
package com.kunke.sanguo.gate.test;


import com.iohao.game.action.skeleton.core.CmdKit;
import com.iohao.game.action.skeleton.core.DataCodecKit;
import com.iohao.game.bolt.broker.client.external.bootstrap.ExternalKit;
import com.iohao.game.bolt.broker.client.external.bootstrap.message.ExternalMessage;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author MR.L
 * @date 2022-07-09
 */
@Slf4j
@UtilityClass
public class ClientCommandKit {

    Map<Integer, ClientCommand> clientCommandMap = new LinkedHashMap<>();

    public boolean login;

    public List<ExternalMessage> listRequestExternalMessage() {
        return clientCommandMap
                .values()
                .stream()
                // 得到与游戏对外服交互的协议
                .map(ClientCommand::getExternalMessage)
                .filter(Objects::nonNull)
                // 将对外服交互协议转成 byte[]
                .toList();
    }

    public ClientCommand createClientCommand(ExternalMessage externalMessage, Class<?> resultClass) {
        ClientCommand clientCommand = new ClientCommand();
        clientCommand.externalMessage = externalMessage;
        clientCommand.resultClass = resultClass;

        clientCommandMap.put(externalMessage.getCmdMerge(), clientCommand);

        return clientCommand;
    }

    public ClientCommand createClientCommand(ExternalMessage externalMessage) {
        return createClientCommand(externalMessage, null);
    }

    public ExternalMessage createExternalMessage(int cmd, int subCmd) {
        return createExternalMessage(cmd, subCmd, null);
    }

    public ExternalMessage createExternalMessage(int cmd, int subCmd, Object object) {
        // 游戏框架内置的协议， 与游戏前端相互通讯的协议
        return ExternalKit.createExternalMessage(cmd, subCmd, object);
    }

    public ExternalMessage createExternalMessage(int cmd, int subCmd, byte[] object) {
        // 游戏框架内置的协议， 与游戏前端相互通讯的协议
        return ExternalKit.createExternalMessage(cmd, subCmd, object);
    }

    public void addParseResult(int cmd, int subCmd, Class<?> resultClass) {
        ClientCommand clientCommand = new ClientCommand();
        clientCommand.resultClass = resultClass;

        int mergeCmd = CmdKit.merge(cmd, subCmd);
        clientCommandMap.put(mergeCmd, clientCommand);
    }

    public void printOnMessage(ByteBuffer byteBuffer) {

    }

    private void printError(ExternalMessage message) {
        int responseStatus = message.getResponseStatus();
        String validMsg = message.getValidMsg();

        log.info("错误码：{} 错误消息 : {}", responseStatus, validMsg);
    }

    private void printNormal(ExternalMessage message) {
        int cmdMerge = message.getCmdMerge();

        ClientCommand clientCommand = clientCommandMap.get(cmdMerge);

        if (clientCommand == null) {
            log.info("没有对应的处理类");
            return;
        }

        if (clientCommand.resultClass == null) {
            log.info("没有对应的处理类来反序列化结果, resultClass is null");
            return;
        }

        byte[] data = message.getData();
        Object o = DataCodecKit.decode(data, clientCommand.resultClass);

        log.info(" {}", o);
    }
}
