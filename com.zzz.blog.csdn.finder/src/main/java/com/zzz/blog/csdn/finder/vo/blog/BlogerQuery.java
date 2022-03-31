package com.zzz.blog.csdn.finder.vo.blog;

import com.zzz.blog.csdn.finder.enums.BlogerSourceType;
import com.zzz.blog.csdn.finder.vo.BaseVo;
import lombok.Data;

@Data
public class BlogerQuery extends BaseVo {
    String blogerId;
    BlogerSourceType sourceType;
}
