package com.zzz.media.collector.Interface.vo.net.type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className NetType
 * @description 网站类型
 * @date 2022/6/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class NetType {
    String pid;
    String typeId;
    String name;
    String icon;
    String desc;
    Date cdate;
    Date udate;
}
