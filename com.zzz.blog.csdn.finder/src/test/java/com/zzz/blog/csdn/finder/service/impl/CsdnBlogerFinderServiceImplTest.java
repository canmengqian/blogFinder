package com.zzz.blog.csdn.finder.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzz.blog.csdn.finder.Application;
import com.zzz.blog.csdn.finder.entity.CsdnBlogerInfo;
import com.zzz.blog.csdn.finder.mapper.CsdnBlogerInfoMapper;
import com.zzz.blog.csdn.finder.service.BlogerFinderService;
import com.zzz.blog.csdn.finder.vo.blog.BlogerQuery;
import org.beetl.sql.core.db.MySqlStyle;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
class CsdnBlogerFinderServiceImplTest {
    @Resource
    CsdnBlogerFinderServiceImpl csdnBlogerFinderService;

    @Test
    void getSubsciribeList() throws JsonProcessingException {
        CsdnBlogerFinderServiceImpl service = new CsdnBlogerFinderServiceImpl();
    }

    @Test
    void getotherSubsciribeList() throws JsonProcessingException {
        csdnBlogerFinderService.getSubsciribeList(BlogerQuery.builder().useSelef(0).blogerId("weixin_43920582").build());
    }
}