package com.kunke.logic.hall;

import com.iohao.game.action.skeleton.core.IoGameGlobalSetting;
import com.iohao.game.action.skeleton.core.codec.JsonDataCodec;
import com.iohao.game.action.skeleton.ext.spring.ActionFactoryBeanForSpring;
import com.iohao.game.bolt.broker.client.BrokerClientApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.kunke.logic.hall", "com.kunke.sanguo"})
@EnableAsync
public class LogicHallApp {
    public static void main(String[] args) {

        // 启动 spring boot
        SpringApplication.run(LogicHallApp.class, args);

        // 设置 json 编解码。如果不做设置，默认使用 jprotobuf
        IoGameGlobalSetting.setDataCodec(new JsonDataCodec());
        // 启动班级逻辑服
        LogicHallClient logicBusinessClient = new LogicHallClient();
        BrokerClientApplication.start(logicBusinessClient);
    }

    @Bean
    public ActionFactoryBeanForSpring actionFactoryBean() {
        // 将业务框架交给 spring 管理
        return ActionFactoryBeanForSpring.me();
    }
}
