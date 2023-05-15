package com.kunke.sanguo.response.common;

import lombok.Data;

@Data
public class ResultResponse {
    int code;
    String msg;
    Object data;

    public ResultResponse() {}

    public ResultResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultResponse OK() {
        return new ResultResponse(0, "成功");
    }

    public ResultResponse LOAD(Object obj) {
        this.data = obj;

        return this;
    }

    public static ResultResponse ERROR() {
        return new ResultResponse(-1, "错误");
    }

    public static ResultResponse ERROR(String msg) {
        return new ResultResponse(-1, msg);
    }
}
