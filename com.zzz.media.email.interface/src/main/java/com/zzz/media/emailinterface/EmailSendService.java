package com.zzz.media.emailinterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
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
}
