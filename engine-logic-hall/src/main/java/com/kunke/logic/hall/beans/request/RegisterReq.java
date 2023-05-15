package com.kunke.logic.hall.beans.request;

import lombok.Data;

@Data
public class RegisterReq {
    private String mobile;
    private String nickName;
    private Integer country;
}
