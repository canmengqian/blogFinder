package com.zzz.blog.csdn.finder.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzz.blog.csdn.finder.manger.BlogerManager;
import com.zzz.blog.csdn.finder.vo.blog.BlogerQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Indexed;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "博客主信息")
@Indexed
@RestController
@RequestMapping("/bloger")
public class BlogerInfoController {

    @Resource
    BlogerManager blogerManager;
    @PostMapping("query")
    @ApiOperation (value = "查询博客主信息",notes = "查询博客主信息")
    public void queryBloger(@Validated  @RequestBody BlogerQuery query){

    }
    @PostMapping("craw/subsribe/bloger")
    @ApiOperation (value = "抓取关注的博客主信息",notes = "抓取关注的博客主信息")
    public void findSubsribeBloger(@Validated  @RequestBody BlogerQuery query) throws JsonProcessingException {
        blogerManager.findSubsribeBloger (query);
    }
}
