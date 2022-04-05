package com.zzz.blog.csdn.finder.service.init;

import cn.hutool.core.util.ObjectUtil;
import com.zzz.blog.csdn.finder.entity.CsdnBlogerInfo;
import com.zzz.blog.csdn.finder.mapper.CsdnBlogerInfoMapper;
import com.zzz.blog.csdn.finder.vo.BaseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
@Slf4j
public class CsdnBlogerCacheService {
    @Resource
    RedisTemplate<String, String> redisTemplate;

    @Resource
    CsdnBlogerInfoMapper csdnBlogerInfoMapper;

   // @PostConstruct
    public void initBlogerInfo() {
        log.info ("初始化csdn  bloger 信息,正在加载至redis中");
        StopWatch stopWatch = new StopWatch ();
        stopWatch.start ();
        csdnBlogerInfoMapper.createLambdaQuery ().select (CsdnBlogerInfo::getId).stream().map (CsdnBlogerInfo::getId).forEach (e-> redisTemplate.opsForValue ().set (e,e));
        stopWatch.stop ();
        log.info ("加载完毕，耗时{}毫秒", stopWatch.getTotalTimeMillis ());
    }


    public boolean hashKeyWithCacheAndDb(String key) {
        boolean haskey = redisTemplate.hasKey (key);
        if (!haskey) {
            CsdnBlogerInfo info = csdnBlogerInfoMapper.createLambdaQuery ().andEq (CsdnBlogerInfo::getId, key).single ();
            if (ObjectUtil.isNotNull (info)) {
                redisTemplate.opsForValue ().set (info.getId (), info.getId ());
                return true;
            }
        }
        return haskey;
    }
}
