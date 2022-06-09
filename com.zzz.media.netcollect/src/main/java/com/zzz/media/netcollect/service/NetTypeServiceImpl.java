package com.zzz.media.netcollect.service;

import com.zzz.media.collector.Interface.service.NetTypeService;
import com.zzz.media.collector.Interface.vo.net.type.NetType;
import org.beetl.sql.core.page.PageResult;
import org.springframework.stereotype.Service;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className NetTypeServiceImpl
 * @description TODO
 * @date 2022/6/8
 */
@Service("NetTypeServiceImpl")
public class NetTypeServiceImpl implements NetTypeService {
    @Override
    public int addType(NetType type) {
        return 0;
    }

    @Override
    public int updateType(NetType type) {
        return 0;
    }

    @Override
    public int delType(NetType type) {
        return 0;
    }

    @Override
    public PageResult<NetType> queryAll(NetType type) {
        return null;
    }

    @Override
    public PageResult<NetType> queryById() {
        return null;
    }
}
