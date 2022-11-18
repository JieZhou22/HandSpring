package com.spring.beans;

/**
 * @Author: 周 杰
 * @Date: 2022/11/16/下午10:29
 * @Description: 要注入属性，有属性名和属性值
 *
 */
public class PropertyValue {
    /** 属性名称 */
    private final String name;

    /** 属性值 */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /** 获取属性名 **/
    public String getName() {
        return name;
    }

    /** 获取属性值 **/
    public Object getValue() {
        return value;
    }
}
