package com.kunke.sanguo.config;

import com.iohao.game.core.common.client.Attachment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
@FieldDefaults(level = AccessLevel.PUBLIC)
public class UserInfoAttachment implements Attachment {
    public long userId;
    public int serviceId;
    public int roleId;

    @Override
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
