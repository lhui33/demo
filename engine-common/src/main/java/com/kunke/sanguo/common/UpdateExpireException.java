package com.kunke.sanguo.common;

import java.io.Serial;

/**
 * <b>类名：</b>更新数据过期提醒<br>
 * <br>
 *
 * @author Charles
 * @version 2021/1/13
 */
public class UpdateExpireException extends Exception {
    @Serial
    private static final long serialVersionUID = 3561809313661698115L;

    public UpdateExpireException(String msg) {
        super(msg);
    }
}
