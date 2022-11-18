package com.spring.beans.factory.config;

import com.spring.beans.PropertyValues;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午9:44
 * @Description: 用于定义Bean实例化信息
 */
public class BeanDefinition {

    // 创建Class对象，把Bean的实例化操作放到容器中处理
    private Class beanClass;

    // 属性信息
    private PropertyValues propertyValues;

    // 为了把属性一定交给 Bean 定义，所以这里填充了 PropertyValues 属性，同时把两个构造函数做了一些简单的优化，避免后面 for 循环时还得判断属性填充是否为空。

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }



    // get 、 set 方法

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
