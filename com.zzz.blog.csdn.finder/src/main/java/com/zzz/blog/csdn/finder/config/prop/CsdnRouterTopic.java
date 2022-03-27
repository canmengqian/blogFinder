package com.zzz.blog.csdn.finder.config.prop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
public class CsdnRouterTopic {
    String method ;
    String dataType ;
    String url;
}
