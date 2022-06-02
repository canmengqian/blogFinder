package com.zzz.media.email.service;

import com.zzz.media.common.web.BizException;
import com.zzz.media.emailinterface.EmailSendService;
import com.zzz.media.emailinterface.bean.EmailTxtSendBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className MailSendServiceImpl
 * @description TODO
 * @date 2022/5/19
 */
@Service("MailSendServiceImpl")
@EnableRetry
@Slf4j
public class MailSendServiceImpl implements EmailSendService {
    @Autowired
    Environment env;

    @Override
    public String send() {
        return env.getProperty("server.port");
    }

    @Override
    @Retryable(recover = "mailLog", value = {BizException.class}, maxAttempts = 5, backoff = @Backoff(maxDelay = 5000, value = 1000L, multiplier = 1))
    public String sendTxt(EmailTxtSendBean info) throws BizException {
        log.warn("发送邮件");
        throw new BizException("", this.getClass());
    }

    @Recover
    public String mailLog() {
        log.error("邮件无法发送");
        return "ERROR";
    }

}
