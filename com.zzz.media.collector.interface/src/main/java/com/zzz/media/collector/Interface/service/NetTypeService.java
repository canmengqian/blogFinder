package com.zzz.media.collector.Interface.service;

import com.zzz.media.collector.Interface.vo.net.type.NetType;
import org.beetl.sql.core.page.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhengzz
 * @version 1.0.0
 * @description 网站类型服务
 * @date 2022/6/8
 */
@Service
@FeignClient(name = "net")
@RequestMapping("/net/type")
public interface NetTypeService {
    @PostMapping("add")
    int addType(@RequestBody NetType type);

    @PostMapping("update")
    int updateType(@RequestBody NetType type);

    @PostMapping("del")
    int delType(@RequestBody NetType type);

    @PostMapping("query/all")
    PageResult<NetType> queryAll(@RequestBody NetType type);

    @PostMapping("query/id")
    PageResult<NetType> queryById();
}
