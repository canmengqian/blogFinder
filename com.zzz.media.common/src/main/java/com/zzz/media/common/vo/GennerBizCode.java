package com.zzz.media.common.vo;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className GennerBizCode
 * @description TODO
 * @date 2022/5/23
 */
public enum GennerBizCode {
    /**
     * 系统提示 0000,9999
     */
    SUCCESS("0000", "操作成功"),
    FAILURE("9999", "操作失败");

    private String code;
    private String msg;

    GennerBizCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
