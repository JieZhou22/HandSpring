package com.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.spring.beans.BeansException;
import com.spring.beans.PropertyValue;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.PropertyValues;
import com.spring.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午11:10
 * @Description: 实现了Bean的实例化操作newInstance，并调用addSingleton方法存放到单例对象的缓存中去
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        // 1. 创建一个空bean
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 3.将新构造的单例对象添加到缓存中去,下一次访问的时候，先进入缓存查看是否有相同beanName的单例对象
        registerSingleton(beanName, bean);
        return bean;
    }

    /*
     * @Author: zhou jie
     * @Description: 属性填充
     * @Date: 上午9:50 2022/11/17
     * @param beanName
     * @param bean
     * @param beanDefinition
     **/
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                // 如果属性值是 BeanReference
                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();

        // getDeclaredConstructors()得到的是一个集合，你的所有构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            // 构造函数集合与入参信息进行比较，这里只进行数量对比，实际源码中还需要对比入参类型，否则相同数量不同入参类型的情况，就会抛异常了
            // 对比是为了找到对应的构造函数，并使用进行实例化
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
