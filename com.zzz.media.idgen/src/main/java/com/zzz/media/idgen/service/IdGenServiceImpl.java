package com.zzz.media.idgen.service;

import cn.hutool.core.lang.Snowflake;
import com.zzz.idgen.Interface.IdGenService;
import com.zzz.media.util.IdUtil;
import org.springframework.stereotype.Service;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className IdGenServiceImpl
 * @description TODO
 * @date 2022/5/20
 */
@Service("IdGenServiceImpl")
public class IdGenServiceImpl implements IdGenService {
    @Override
    public String randomNumWithDate(int len) {
        return IdUtil.dateRandomIdWithTime(len);
    }

    @Override
    public String snowflake(long workId) {
        Snowflake snowflake = cn.hutool.core.util.IdUtil.getSnowflake(workId);
        return snowflake.nextIdStr();
    }


}
