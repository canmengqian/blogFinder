package com.zzz.media.netcollect;

import com.zzz.media.emailinterface.EmailSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(value = "网络收集接口")
public class IndexController {

    @Autowired
    EmailSendService emailinterface;

    @GetMapping("index")
    @ApiOperation("首页")
    public String index() {
        return emailinterface.send();
    }
}
