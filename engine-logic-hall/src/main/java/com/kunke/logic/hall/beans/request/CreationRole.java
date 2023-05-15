package com.kunke.logic.hall.beans.request;


import lombok.Data;

@Data
public class CreationRole {
    //服务器id
    private int serviceId;
    //角色名
    private String roleName;
    //角色性别
    private int roleSex;
    //角色职业
    private int roleJobId;
    //角色眼影
    private int roleEyeshadowId;
    //角色眼睛
    private int roleEyeId;
    //角色发型
    private int roleHairId;
    //角色皮肤
    private int roleSkinId;
    //角色脸型
    private int roleFaceId;
    //角色嘴巴
    private int roleMouthId;
    //角色脸部装饰
    private int roleFaceDecorationId;

}
