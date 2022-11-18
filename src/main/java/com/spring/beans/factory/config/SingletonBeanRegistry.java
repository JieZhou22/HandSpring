package com.spring.beans.factory.config;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午10:45
 * @Description: 定义了一个获取单例对象的接口
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
