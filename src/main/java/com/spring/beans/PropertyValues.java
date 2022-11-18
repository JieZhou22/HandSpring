package com.spring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 周 杰
 * @Date: 2022/11/16/下午10:30
 * @Description: 对属性进行包装，用集合
 */
public class PropertyValues {

    /** 属性集合 **/
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    // 增加属性
    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    // 获取属性数组
    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /*
     * @Author: zhou jie
     * @Description: 通过 propertyName 来匹配，得到具体的property属性
     * @Date: 下午10:33 2022/11/16
     * @param propertyName
     **/
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
