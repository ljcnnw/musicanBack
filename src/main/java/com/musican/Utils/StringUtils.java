package com.musican.Utils;

import java.util.UUID;

public class StringUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");

    }

    public static boolean isNotBlanks(String str) {
        if (str == null) {
            return false;
        } else if (org.springframework.util.StringUtils.isEmpty(str)) {
            return false;
        } else {
            return true;
        }
    }
}
