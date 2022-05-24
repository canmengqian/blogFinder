package com.zzz.media.base.vo;

import lombok.Data;

/**
 * @author zzz
 */
@Data
public class GennerResult<T> {
    /**
     * 状态码，比如1000代表响应成功
     */
    private String code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public GennerResult(T data) {
        this(GennerBizCode.SUCCESS, data);
    }

    public GennerResult(GennerBizCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public GennerResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GennerResult(String code, String errMsg, T data) {
        this.code = code;
        this.msg = errMsg;
        this.data = data;
    }

    public static GennerResult fail(String msg) {
        return new GennerResult(GennerBizCode.FAILURE.getCode(), msg);
    }

    public static GennerResult fail() {
        return new GennerResult(GennerBizCode.FAILURE.getCode(), GennerBizCode.FAILURE.getMsg());
    }
}