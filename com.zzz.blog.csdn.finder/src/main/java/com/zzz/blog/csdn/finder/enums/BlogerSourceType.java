package com.zzz.blog.csdn.finder.enums;

/**
 * 博客主数据来源类型
 */
public enum BlogerSourceType {
    CSDN("CSDN"),
    BLOGER("博客园");
    public String name;

    BlogerSourceType(String name) {
        this.name = name;
    }
}
