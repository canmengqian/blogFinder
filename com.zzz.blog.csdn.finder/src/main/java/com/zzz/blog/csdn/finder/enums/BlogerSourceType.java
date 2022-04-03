package com.zzz.blog.csdn.finder.enums;

/**
 * 博客主数据来源类型
 */
public enum BlogerSourceType {
    NONE(-99,""),
    CSDN(1,"CSDN"),
    BLOGER(2,"博客园");
    public  int code ;
    public String name;

    BlogerSourceType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static BlogerSourceType  getType(int code){
       for(BlogerSourceType type : BlogerSourceType.values ()){
           if(code==type.ordinal ()){
               return type;
           }
       }
       return NONE;
    }
}
