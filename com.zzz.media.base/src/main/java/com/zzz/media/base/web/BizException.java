package com.zzz.media.base.web;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className BizException
 * @description TODO
 * @date 2022/5/23
 */
@Slf4j
public class BizException extends Exception {
    public BizException(String message,Class clazz) {
        super(message);
        log.error("current class name is : {}, cause by {}",clazz.getName(),message);
    }
}
