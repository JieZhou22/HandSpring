package com.spring.beans;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午10:58
 * @Description: 定义Bean的异常
 */
public class BeansException extends RuntimeException{
    // 使用两个有参构造器
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
