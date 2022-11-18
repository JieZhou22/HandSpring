package com.spring.beans.factory.config;

/**
 * @Author: 周 杰
 * @Date: 2022/11/16/下午10:42
 * @Description: 定义bean的对象类型
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
