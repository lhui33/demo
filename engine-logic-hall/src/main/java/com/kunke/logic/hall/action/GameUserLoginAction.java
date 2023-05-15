package com.kunke.logic.hall.action;

import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.bolt.broker.client.kit.ExternalCommunicationKit;
import com.iohao.game.bolt.broker.client.kit.UserIdSettingKit;
import com.kunke.logic.hall.beans.request.CreationRole;
import com.kunke.logic.hall.beans.request.SelectServiceReq;
import com.kunke.sanguo.config.MyFlowContext;
import com.kunke.sanguo.config.UserInfoAttachment;
import com.kunke.sanguo.beans.IntWrapper;
import com.kunke.sanguo.cmd.LogicHallCmd;
import com.kunke.sanguo.message.user.LoginSubmitReq;
import com.kunke.sanguo.model.GameUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@ActionController(LogicHallCmd.loginCmd)
public class GameUserLoginAction {


    /**
     * 用户登录
     */
    @ActionMethod(LogicHallCmd.loginVerify)
    public GameUser userLogin(LoginSubmitReq loginSubmitVO, MyFlowContext flowContext) {
        GameUser userInfo = new GameUser();
        userInfo.setNickName("123");
        userInfo.setId(1);
        UserIdSettingKit.settingUserId(flowContext, userInfo.getId());
        return userInfo;
    }
    /***
     * 用户选择的服务器
     * @param selectServiceReq 选择的服务器
     * @param flowContext 上下文
     * @return  1
     */
    @ActionMethod(LogicHallCmd.selectService)
    public IntWrapper selectService(SelectServiceReq selectServiceReq, MyFlowContext flowContext){
        UserInfoAttachment userInfoAttachment =new UserInfoAttachment();
        userInfoAttachment.setUserId(flowContext.getUserId());
        userInfoAttachment.setServiceId(selectServiceReq.getServiceId());
        // 设置元信息 ----- 关键代码
        ExternalCommunicationKit.setAttachment(userInfoAttachment);
        return IntWrapper.me(1);
    }
    @ActionMethod(LogicHallCmd.creationRole)
    public IntWrapper userCreationRole(CreationRole creationRole,MyFlowContext flowContext){
        log.info("打印元信息 attachment : {}", flowContext.getServiceId());
        return IntWrapper.me(1);
    }
}
