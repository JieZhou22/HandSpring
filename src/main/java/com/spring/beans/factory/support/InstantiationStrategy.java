package com.spring.beans.factory.support;

import com.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: 周 杰
 * @Date: 2022/11/16/下午8:57
 * @Description:
 */
public interface InstantiationStrategy {
    /*
     * @Author: zhou jie
     * @Description: 实例化c
     * @Date: 下午8:59 2022/11/16
     * @param beanDefinition
     * @param beanName
     * @param ctor 为了拿到符合入参信息相对应的构造函数
     * @param args 具体的入参信息，最终实例化会用到
     **/
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args);
}
