package com.zzz.media.email.component.email.subject;

/**
 * @author zhengzz
 * @version 1.0.0
 * @description TODO
 * @date 2022/6/2
 */
public interface SubjectJoiner<R> {
    String join(String subject, String... ext);

    String join(String subject, R r);
}
