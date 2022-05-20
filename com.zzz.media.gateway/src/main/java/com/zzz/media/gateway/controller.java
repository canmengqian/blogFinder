package com.zzz.media.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className controller
 * @description TODO
 * @date 2022/5/20
 */
@RestController
@RequestMapping("gw")
public class controller {
    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
