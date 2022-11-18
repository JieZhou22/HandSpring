package com.spring.beans.factory.support;

import com.spring.beans.BeansException;
import com.spring.core.io.Resource;
import com.spring.core.io.ResourceLoader;

/**
 * @Author: 周 杰
 * @Date: 2022/11/17/下午10:49
 * @Description: Simple interface for bean definition readers.
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
