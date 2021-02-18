package com.chungui.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @Author 周春桂
 * @Date 2021/2/18 13:52
 * @Desciption
 **/
@Configuration
public class MyBeanPostProcessor implements BeanPostProcessor , Ordered {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor Before.....");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor After.....");
        return bean;
    }

    public int getOrder() {
        return 0;
    }
}
