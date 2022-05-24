package com.zzz.media.email.service;

import com.zzz.media.common.web.BizException;
import com.zzz.media.emailinterface.EmailSendService;
import com.zzz.media.emailinterface.bean.EmailTxtSendBean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className MailSendServiceImpl
 * @description TODO
 * @date 2022/5/19
 */
@Service("MailSendServiceImpl")
@EnableRetry
public class MailSendServiceImpl implements EmailSendService {
    @Override
    public String send() {
        return " send ok";
    }

    @Override
    @Retryable()
    public String sendTxt(EmailTxtSendBean info) throws BizException {
        throw new BizException("", this.getClass());
    }


}
