package com.zzz.blog.csdn.finder.vo.blog;

import com.zzz.blog.csdn.finder.enums.BlogerSourceType;
import com.zzz.blog.csdn.finder.vo.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class BlogerQuery extends BaseVo {
    String blogerId;
    @Min(value = 1)
    @Max(2)
    int sourceType;
    int useSelef;
}
