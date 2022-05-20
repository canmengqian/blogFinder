package com.zzz.service1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className S1
 * @description TODO
 * @date 2022/5/20
 */
@RestController
@RequestMapping(value = "/s1")
public class S1 {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
