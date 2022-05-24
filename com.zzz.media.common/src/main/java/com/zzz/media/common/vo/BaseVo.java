package com.zzz.media.common.vo;

import cn.hutool.core.text.CharSequenceUtil;
import lombok.Data;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className BaseVo
 * @description BaseVo
 * @date 2021/8/18
 */
@Data
public class BaseVo {
    public static final byte[] JWT_SALT_KEY = "".getBytes();
    public static final String JWT_SMS_USER = "";
    public int pageNum;
    public int pageSize;
    String startDate;
    String endDate;

    /**
     * 起始日期
     */
    public static final String START_DATE = "19000101";
    /**
     * 结束日期
     */
    public static final String END_DATE = "99991231";

    /**
     * 起始日期
     */
    public static final String START_DATE_TIME = "1900-01-01 00:00:00";
    /**
     * 结束日期
     */
    public static final String END_DATE_TIME = "9999-12-31 23:59:59";

    /**
     * 默认页数
     */
    public static final int DEFAULT_PAGE = 1;
    /**
     * 默认查询条数
     */
    public static final int DEFAULT_LIMIT = 10;
    /**
     * 2倍默认查询条数
     */
    public static final int MULTIPLE_2_LIMIT = 2 * DEFAULT_LIMIT;

    /**
     * 5倍默认查询条数
     */
    public static final int MULTIPLE_5_LIMIT = 5 * DEFAULT_LIMIT;

    /**
     * 10倍默认查询条数
     */
    public static final int MULTIPLE_10_LIMIT = 10 * DEFAULT_LIMIT;

    /*
     * @author zhengzz
     * @description 默认页数
     * @date 9:38 2021/8/23
     * @param [page]
     * @return int
     **/
    public static int defaultPage(int page) {
        return Math.max(page, DEFAULT_PAGE);
    }

    /*
     * @author zhengzz
     * @description 默认条数
     * @date 9:38 2021/8/23
     * @param [limit]
     * @return int
     **/
    public static int defaultLimit(int limit) {
        return Math.max(limit, DEFAULT_LIMIT);
    }

    public static int defaultLimit(int limit, int multiple) {
        return Math.max(limit, multiple * DEFAULT_LIMIT);
    }

    public static String defaultStartDate(String startDate) {
        if (CharSequenceUtil.isNotEmpty(startDate)) {
            return startDate;
        }
        return START_DATE;

    }

    public static String defaultEndDate(String endDate) {
        if (CharSequenceUtil.isNotEmpty(endDate)) {
            return endDate;
        }
        return END_DATE;

    }

    public static String defaultStartDateTime(String startDateTime) {
        if (CharSequenceUtil.isNotEmpty(startDateTime)) {
            return startDateTime;
        }
        return START_DATE_TIME;

    }

    public static String defaultEndDateTime(String endDateTime) {
        if (CharSequenceUtil.isNotEmpty(endDateTime)) {
            return endDateTime;
        }
        return END_DATE_TIME;

    }


}
