package com.zzz.media.base.web;

import com.zzz.media.base.vo.GennerBizCode;
import lombok.Getter;

@Getter
public class APIException extends RuntimeException {
    private String code;
    private String msg;
    private GennerBizCode resultCode;

    public APIException(GennerBizCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.resultCode = resultCode;
    }

    public static APIException failure() {
        String code = GennerBizCode.FAILURE.getCode();
        String msg = GennerBizCode.FAILURE.getMsg();
        return new APIException(code, msg);
    }

    public static APIException failure(String msg) {
        String code = GennerBizCode.FAILURE.getCode();
        return new APIException(code, msg);
    }

    public static APIException failure(String code, String msg) {
        return new APIException(code, msg);
    }

    public static APIException failure(GennerBizCode resultCode) {
        return new APIException(resultCode);
    }

    public APIException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
