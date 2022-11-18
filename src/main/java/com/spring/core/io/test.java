package com.spring.core.io;

import static com.spring.core.io.ResourceLoader.CLASSPATH_URL_PREFIX;

/**
 * @Author: 周 杰
 * @Date: 2022/11/17/下午10:43
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        String location = "classpath: wwwww.ww.ww";

        String substring = location.substring(10);
        System.out.println(substring);
        System.out.println(CLASSPATH_URL_PREFIX.length());
    }
}
