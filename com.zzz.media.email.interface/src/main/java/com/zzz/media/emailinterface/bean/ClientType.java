package com.zzz.media.emailinterface.bean;

import com.zzz.media.common.Enum.BaseEnum;

public enum ClientType implements BaseEnum {
    TRACE,
    SYS,
    CUSTOM;

    @Override
    public String[] keysByNameAndOrder() {
        return new String[0];
    }
}
