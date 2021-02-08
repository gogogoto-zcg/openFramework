package com.chungui.bean;

import org.springframework.stereotype.Component;

/**
 * @Author 周春桂
 * @Date 2021/2/4 10:18
 * @Desciption
 **/
@Component
public class Component1 {
    String name = "123";
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
