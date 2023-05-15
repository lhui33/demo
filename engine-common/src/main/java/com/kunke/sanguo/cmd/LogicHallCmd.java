package com.kunke.sanguo.cmd;

public interface LogicHallCmd {

////////////////////用户与公告///////////////////////
    // 用户与公告
    int loginCmd = RootModuleCmd.logicLoginCmd;
    int testLink = 0;
    // 登录校验
    int loginVerify = 1;
    // 公告
    int boardCast = 2;
    // 获取服务器信息
    int getServiceInfo = 3;
    //玩家角色创建
    int creationRole = 4;
    int selectService = 5;
    int selectRole = 6;
}
