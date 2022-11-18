package com.spring.beans.factory.support;

import com.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午10:47
 * @Description: 默认的单例bean注册表，记录单例bean的注册信息
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    // 1. 以HashMap的key-value结构来存储 单例bean 的注册信息
    private Map<String, Object> singletonObjects = new HashMap<>();

//    @Override
//    public Object getSingleton(String beanName) {
//        return beanName;
//    }

    /**
     * @description: 通过beanName（key）在注册表中获取到对应定义的bean
     * @author: zhou jie
     * @date: 2022/11/15 下午10:59
     * @param: [beanName]
     * @return: java.lang.Object
     **/
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }


    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
