package com.spring.beans.factory;

import com.spring.beans.BeansException;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午9:44
 * @Description:
 */
public interface BeanFactory {
    /* 这里的实例化已经交出去---DefaultSingletonBeanRegistry
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
     */
    Object getBean(String name) throws BeansException;

    /*
     * @Author: zhou jie
     * @Description: 返回有构造函数的Bean实例对象
     * @Date: 下午8:49 2022/11/16
     * @param name 要检索的bean name
     * @param args 入参信息，为了方便传递入参给构造函数实例化
     **/
    Object getBean(String name, Object... args) throws BeansException;
}
