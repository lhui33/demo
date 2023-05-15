package com.kunke.sanguo.common;

import java.io.Serial;

/**
 * <b>类名：</b>业务异常提醒<br>
 * <br>
 *
 * @author Charles
 * @version 2021/1/13
 */
public class BusinessException extends Exception {
    @Serial
    private static final long serialVersionUID = 3561809313661698115L;

    public BusinessException(String msg) {
        super(msg);
    }
}
