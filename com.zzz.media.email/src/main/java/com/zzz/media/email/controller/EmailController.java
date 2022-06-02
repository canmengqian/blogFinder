package com.zzz.media.email.controller;

import com.zzz.media.common.web.BizException;
import com.zzz.media.email.service.MailSendServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className EmailController
 * @description TODO
 * @date 2022/5/19
 */
@RestController
@RequestMapping("email/send")
public class EmailController {

    @Resource
    MailSendServiceImpl mailSendService;

    @RequestMapping("/ok")
    public String index() throws BizException {
        return mailSendService.sendTxt(null);
    }
}
