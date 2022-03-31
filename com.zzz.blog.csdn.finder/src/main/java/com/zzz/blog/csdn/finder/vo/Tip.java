package com.zzz.blog.csdn.finder.vo;

import lombok.*;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className Error
 * @description TODO
 * @date 2022/2/15
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tip {
    /**
     * 告警输出
     */
    int level;

    /**
     * SUCCESS,INFO,WARN,FORBID,ERROR,FATAL
     */
    String name;

    /**
     * 错误消息
     */
    String errMsg;

    public static Tip error(String msg) {
        return Tip.builder().errMsg(msg).level(ErrorLevel.ERROR.ordinal()).name(ErrorLevel.ERROR.getProp()).build();
    }

    public static Tip success(String msg) {
        return Tip.builder().errMsg(msg).level(ErrorLevel.SUCCESS.ordinal()).name(ErrorLevel.SUCCESS.getProp()).build();
    }

    public static Tip info(String msg) {
        return Tip.builder().errMsg(msg).level(ErrorLevel.INFO.ordinal()).name(ErrorLevel.INFO.getProp()).build();
    }

    public static Tip warn(String msg) {
        return Tip.builder().errMsg(msg).level(ErrorLevel.WARN.ordinal()).name(ErrorLevel.WARN.getProp()).build();
    }

    public static Tip fatal(String msg) {
        return Tip.builder().errMsg(msg).level(ErrorLevel.FATAL.ordinal()).name(ErrorLevel.FATAL.getProp()).build();
    }

    public static Tip forbid(String msg) {
        return Tip.builder().errMsg(msg).level(ErrorLevel.FORBID.ordinal()).name(ErrorLevel.FORBID.getProp()).build();
    }


    enum ErrorLevel {
        SUCCESS("SUCCESS"),
        INFO("INFO"),
        WARN("WARN"),
        FORBID("FORBID"),
        ERROR("ERROR"),
        FATAL("FATAL");


        String prop;

        public String getProp() {
            return prop;
        }

        public void setProp(String prop) {
            this.prop = prop;
        }

        ErrorLevel(String prop) {
            this.prop = prop;
        }

    }
}
