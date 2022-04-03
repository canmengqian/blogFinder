package com.zzz.blog.csdn.finder.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzz.blog.csdn.finder.vo.blog.BlogerQuery;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 *
 */
@Component
public interface BlogerFinderService<T, M> {
    /**
     * 获取订阅者信息
     * @param blogerId
     * @return
     */
    public List<T> getSubsciribeList(BlogerQuery query) throws JsonProcessingException;

    M getMapper();
}
