package com.kunke.sanguo.cmd;

public interface RootModuleCmd {
    //服务器主命令
    int logicServiceCmd = 1;
    //登录主命令
    int logicLoginCmd = 2;
    //大厅主命令
    int logicHallCmd = 3;
    //大厅im
    int logicHallImCmd = 4;
    //大厅邮件
    int logicHallMailCmd = 5;
    //广播消息
    int logicBroadcastCmd= 6;
    //任务消息
    int logicGameTaskCmd = 7;
    //宗门消息
    int logicGameDoorCmd = 8;
    //背包消息
    int logicBackpackCmd = 9;
    //弟子消息
    int logicGameDiscipleCmd = 10;
    //技能消息
    int logicGameSkillCmd = 11;
}
