package com.zzz.blog.csdn.finder.entity;

import java.util.Date;

import lombok.Data;
import org.beetl.sql.annotation.entity.*;
/*
 * csdn爬取流水
 * gen by beetlsql3 2022-04-08
 */

@Table(name = "csdn_find_log")
@Data
public class CsdnFindLog implements java.io.Serializable {
    /**
     * 流水ID
     */
    @AssignID
    private String flowId;
    /**
     * 最新日期
     */
    private Integer lastDay;
    /**
     * 爬取批次号
     */
    private String batchId;
    /**
     * 爬取主题
     */
    private String topic;
    /**
     * 爬取总数
     */
    private Integer findTotal;
    /**
     * 爬取新增数
     */
    private Integer findAdd;
    /**
     * 已存在数
     */
    private Integer findExist;
    private Date cdate;


}
