package com.zzz.blog.csdn.finder.mapper;

import org.beetl.sql.mapper.BaseMapper;
import com.zzz.blog.csdn.finder.entity.*;
import org.beetl.sql.mapper.annotation.Param;
import org.beetl.sql.mapper.annotation.Update;
import org.springframework.stereotype.Repository;

/*
 *
 * gen by beetlsql3 mapper 2022-03-31
 */
@Repository
public interface CsdnBlogerInfoMapper extends BaseMapper<CsdnBlogerInfo> {

    @Update
    void updateExecStatusById(@Param("id") String id, @Param("status") int status);

    @Update
    void deleteWithKey(@Param("id") String id);
}
