package com.chungui.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;

/**
 * @Author 周春桂
 * @Date 2021/2/18 11:53
 * @Desciption 测试Spring Bean的生命周期
 **/
//@Component
public class LifeBean implements InitializingBean, BeanFactoryAware, BeanNameAware , DisposableBean {
    private BeanFactory beanFactory;

    private String beanName;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("BeanFactoryAware...");
        System.out.println(beanFactory);
    }

    public void setBeanName(String s) {
        this.beanName = s;
        System.out.println("BeanNameAware...");
        System.out.println(beanName);
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println(getClass().getCanonicalName()+"正在afterPropertiesSet");
    }


    public void init(){
        System.out.println("init....");
    }

    @PostConstruct
    public void postConstrutor(){
        System.out.println("PostConstruct...");
    }

    public void close(){
        System.out.println("close....");
    }

    public void destroy() throws Exception {
        System.out.println(getClass().getCanonicalName()+"正在destroy");
    }
}
