package com.spring.core.io;

/**
 * @Author: 周 杰
 * @Date: 2022/11/17/下午10:29
 * @Description: 资源加载器
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    // 定义获取资源接口，里面传递 location 地址即可
    Resource getResource(String location);
}
