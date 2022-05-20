package com.zzz.blog.csdn.finder.vo;

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


    public int page;

    public int limit;

    public static final String NIL = "NIL";


    public String startDate;
    public String endDate;
    public String queryDate;

    /**
     * 错误等级
     */
    Tip tip;

    /**
     * 起始日期
     */
    public static final String START_DATE = "19000101";
    /**
     * 结束日期
     */
    public static final String END_DATE = "99991231";

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

    /**
     * 100倍默认查询条数
     */
    public static final int MULTIPLE_100_LIMIT = 100 * DEFAULT_LIMIT;
    /**
     * 业务允许最大查询条数
     */
    public static final int MAX_LIMIT = 100000;

    /*
     * @author zhengzz
     * @description 默认页数
     * @date 9:38 2021/8/23
     * @Param [page]
     * @Return int
     **/
    public static int defaultPage(int page) {
        return Math.max(page, DEFAULT_PAGE);
    }

    /*
     * @author zhengzz
     * @description 默认条数
     * @date 9:38 2021/8/23
     * @Param [limit]
     * @Return int
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

    /**
     * @Return
     * @Param
     * @author zhengzz
     * @description 修正页数
     * @date 14:26 2022/2/16
     **/
    public void amendPage() {
        if (page <= 0) {
            this.page = defaultPage(1);
        }
    }

    /**
     * @Return
     * @Param
     * @author zhengzz
     * @description 修正条数
     * @date 14:26 2022/2/16
     **/
    public void amendLimit() {
        if (limit <= 0) {
            this.limit = defaultLimit(10);
        }
    }

    public void amendstartDate() {
        if (CharSequenceUtil.isEmpty(startDate)) {
            this.startDate = START_DATE;
        }
    }

    public void amendendDate() {
        if (CharSequenceUtil.isEmpty(endDate)) {
            this.endDate = END_DATE;
        }
    }


    /**
     * @Return
     * @Param
     * @author zhengzz
     * @description 修正页数和条数
     * @date 14:26 2022/2/16
     **/
    public void amendPageAndLimit() {
        amendPage();
        amendLimit();
    }

    public void amendStartAndEndDate() {
        amendstartDate();
        amendendDate();
    }


}
