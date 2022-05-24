package com.zzz.idgen.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhengzz
 * @version 1.0.0
 * @description
 * @date 2022/5/20
 */
@Component
@FeignClient(value = "id-gen", path = "key")
public interface IdGenService {
    @GetMapping("/random/date")
    String randomNumWithDate(@RequestParam(value = "len", defaultValue = "6") int len);

    @GetMapping("/snowflake")
    String snowflake(@RequestParam(value = "len", defaultValue = "0") long workId);
}
