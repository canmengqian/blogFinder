package com.zzz.media.email.component.email;

public enum TraceLevel {
    DEBUG("debug", "调试"),
    INFO("info", "详情"),
    WARNING("warning", "告警"),
    ERROR("error", "错误"),
    FATAL("fatal", "致命"),
    CRASH("crash", "崩溃");
    private String level;
    private String desc;

    TraceLevel(String level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
