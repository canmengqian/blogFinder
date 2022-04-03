package com.zzz.blog.csdn.finder.entity;

import java.util.Date;

import lombok.Data;
import org.beetl.sql.annotation.entity.*;
/*
 * csdn博客主信息表
 * gen by beetlsql3 2022-03-31
 */

@Table(name = "csdn_bloger_info")
@Data
public class CsdnBlogerInfo implements java.io.Serializable {
    /**
     * 博客主ID
     */
    @AssignID
    private String blogerId;
    private String nickname;
    /**
     * 头像地址
     */
    private String userAvatar;
    /**
     * 博客地址
     */
    private String blogUrl;
    /**
     * 由CSDN分配的ID
     */
    private String id;
    /**
     * 获取订阅者状态
     */
    private Integer execSubcribeStatus;
    private String loginUsernameIsFollow;

    String briefIntroduction;
    private String blogExpert;
    /**
     * 执行时间
     */
    private Date exeDatetime;
    /**
     * 创建时间
     */
    private Date cdate;
    /**
     * 更新时间
     */
    private Date udate;
    /**
     * 数据来源
     */
    private Integer sourceId;
    /**
     * 是否自身ID
     */
    private Integer isSelf;


}
