package com.zzz.blog.csdn.finder.service;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 *
 */
@Component
public interface BlogerFinderService<T> {
    /**
     * 获取订阅者信息
     * @param blogerId
     * @return
     */
    public List<T> getSubsciribeList(String blogerId);
}
