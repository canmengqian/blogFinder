package com.zzz.blog.csdn.finder.scheduler;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzz.blog.csdn.finder.dto.BlogerInfoDTO;
import com.zzz.blog.csdn.finder.entity.CsdnBlogerInfo;
import com.zzz.blog.csdn.finder.enums.BlogerSourceType;
import com.zzz.blog.csdn.finder.service.impl.CsdnBlogerFinderServiceImpl;
import com.zzz.blog.csdn.finder.vo.blog.BlogerQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CsdnFinderScheduler {

    @Resource
    CsdnBlogerFinderServiceImpl csdnBlogerFinderService;

    @Scheduled(fixedDelay = 10000)
    public void findInvoke() throws JsonProcessingException {
        StopWatch stopWatch = new StopWatch ();
        stopWatch.start ("CSDN抓取任务开始");
        AtomicLong recordCount= new AtomicLong (0);
        List<CsdnBlogerInfo> info = csdnBlogerFinderService.getMapper ().createLambdaQuery ().andEq (CsdnBlogerInfo::getExecSubcribeStatus, 0).limit (1, 100).select ();
        if (CollUtil.isNotEmpty (info)) {
            List<String> ids = info.stream ().map (CsdnBlogerInfo::getId).filter (CharSequenceUtil::isNotEmpty).collect (Collectors.toList ());
            ids.forEach (s -> {
                BlogerQuery query = BlogerQuery.builder ().blogerId (s).sourceType (BlogerSourceType.CSDN.code).useSelef (0).build ();
                try {
                    List<BlogerInfoDTO> records=  csdnBlogerFinderService.getSubsciribeList (query);
                    recordCount.addAndGet (CollUtil.isEmpty (records)?0:records.size ());
                   // Thread.sleep (5000);
                } catch (JsonProcessingException e) {
                    e.printStackTrace ();
                }
            });

        }
        stopWatch.stop ();
        log.info ("抓取耗时{}毫秒", stopWatch.getTotalTimeMillis ());
    }
}
