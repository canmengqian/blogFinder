package com.zzz.media.emailinterface;

import com.zzz.media.common.web.BizException;
import com.zzz.media.emailinterface.bean.EmailTxtSendBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhengzz
 * @version 1.0.0
 * @description TODO
 * @date 2022/5/19
 */

@Component
@FeignClient(value = "email-service", path = "email/send")
public interface EmailSendService {
    @RequestMapping(value = "ok")
    String send();


    @RequestMapping(value = "txt")
    String sendTxt(@RequestBody EmailTxtSendBean info) throws BizException;

}
