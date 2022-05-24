package com.zzz.media.emailinterface.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className User
 * @description TODO
 * @date 2022/5/23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailUser {
    String userId;
    String account;
}
