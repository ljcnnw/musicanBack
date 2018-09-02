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


    public static String join(String s[]) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            if(i == s.length-1){
                str.append(s[i]);
            }else {
                str.append(s[i]+",");
            }
        }
        return str.toString();
    }
}
