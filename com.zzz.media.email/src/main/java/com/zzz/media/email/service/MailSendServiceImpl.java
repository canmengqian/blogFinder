package com.zzz.media.email.service;

import com.zzz.media.emailinterface.EmailSendService;
import org.springframework.stereotype.Service;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className MailSendServiceImpl
 * @description TODO
 * @date 2022/5/19
 */
@Service("MailSendServiceImpl")
public class MailSendServiceImpl implements EmailSendService {
    @Override
    public String send() {
        return " send ok";
    }
}
