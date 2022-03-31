package com.zzz.blog.csdn.finder.manger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzz.blog.csdn.finder.dto.BlogerInfoDTO;
import com.zzz.blog.csdn.finder.service.BlogerFinderService;
import com.zzz.blog.csdn.finder.vo.blog.BlogerQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BlogerManager {
    @Resource
    @Qualifier("CsdnBlogerFinderServiceImpl")
    BlogerFinderService<BlogerInfoDTO> csdnBlogerFinderService;

    public void findSubsribeBloger(BlogerQuery query) throws JsonProcessingException {
        switch (query.getSourceType ()) {
            case CSDN:
                csdnBlogerFinderService.getSubsciribeList (query.getBlogerId ());
                break;
            case BLOGER:
                break;
        }
    }
}
