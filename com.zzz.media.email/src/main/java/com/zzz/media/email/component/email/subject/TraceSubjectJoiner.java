package com.zzz.media.email.component.email.subject;

import com.zzz.media.email.component.email.TraceLevel;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className TraceSubjectJoiner
 * @description TODO
 * @date 2022/6/2
 */
public class TraceSubjectJoiner implements SubjectJoiner<TraceLevel> {
    @Override
    public String join(String subject, String... ext) {
        if (ext == null || ext.length == 0) {
            return subject;
        }
        return subject + ext[0];
    }

    @Override
    public String join(String subject, TraceLevel level) {
        return subject + level.getLevel();
    }
}
