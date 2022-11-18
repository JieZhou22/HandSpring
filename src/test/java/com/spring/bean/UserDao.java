package com.spring.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 周 杰
 * @Date: 2022/11/16/下午11:04
 * @Description:
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
