package com.kunke.sanguo.message.user;

import lombok.Data;

/**
 * 登录用
 */
@Data
public class LoginSubmitReq {
    private String UID;
    private String username;
    private int channelType;
}
