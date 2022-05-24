package com.zzz.media.util;

import cn.hutool.core.util.RandomUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className IdUtil
 * @description TODO
 * @date 2022/5/20
 */
public class IdUtil {
    private final static int RANDOM_LENGTH = 6;

    private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    public static String dateRandomIdWithTime() {
        return dateRandomIdWithTime(RANDOM_LENGTH);
    }

    public static String dateRandomIdWithTime(int randomLength) {
        if (randomLength > 0) {

            return DTF.format(LocalDateTime.now()) + RandomUtil.randomNumbers(randomLength);
        }
        return DTF.format(LocalDateTime.now());
    }


    public static String dateId() {
        return DTF.format(LocalDateTime.now());
    }
}
