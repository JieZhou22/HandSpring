package com.spring.beans.factory.config;

import com.spring.beans.factory.HierarchicalBeanFactory;

/**
 * @Author: 周 杰
 * @Date: 2022/11/17/下午11:13
 * @Description:
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
