package com.zzz.media.netcollect;

import com.zzz.media.emailinterface.EmailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className IndexController
 * @description TODO
 * @date 2022/5/20
 */
@RestController
@RequestMapping("net")
public class IndexController {

    @Autowired
    EmailSendService emailinterface;

    @RequestMapping("index")
    public String index() {
        return emailinterface.send();
    }
}
