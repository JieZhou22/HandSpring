package com.spring.beans.factory.support;

import com.spring.beans.BeansException;
import com.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: 周 杰
 * @Date: 2022/11/16/下午9:00
 * @Description:
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    /*
     * @Author: zhou jie
     * @Description:
     * @Date: 下午9:02 2022/11/16
     * @param beanDefinition
     * @param beanName
     * @param ctor 为了拿到符合入参信息相对应的构造函数
     * @param args 具体的入参信息，最终实例化会用到
     **/
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                // 有构造函数的实例化，把入参信息传递给 newInstance 进行实例化
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
