package com.spring.beans.factory.support;

import com.spring.beans.BeansException;
import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.config.BeanDefinition;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午10:53
 * @Description: 实现BeanFactory的getBean方法，来获取到单例bean
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }
    /*
     * @Author: zhou jie
     * @Description: 多个方法需要使用的重复代码，进行抽象出来
     * @Date: 下午9:35 2022/11/16
     * @param name
     * @param args
     **/
    protected <T> T doGetBean(final String name, final Object[] args) {
        // 获取单例Bean，如果Bean不存在，则重新创建一个Bean
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        // 如果bean为null，则先定义一个beanDefinition，再利用name和beanDefinition创建一个bean
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }


    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);
}
