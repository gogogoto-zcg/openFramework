package com.chungui.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author 周春桂
 * @Date 2020/7/24 18:16
 * @Desciption 学生实体类
 **/
@Component
public class StudentBean {

    private String name;
    private int age;
    private int sex;
    private String phone;
    private String addr;
    //读取容器中bean的内容
    @Value("#{component1.name}")
    private String beanAttr;
    //读取配置文件内容
    @Value("${username}")
    private String propAttr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }


    @Override
    public String toString() {
        return "StudentBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", addr='" + addr + '\'' +
                ", beanAttr='" + beanAttr + '\'' +
                ", propAttr='" + propAttr + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring.xml"});
        StudentBean studentBean = (StudentBean)context.getBean("studentBean");
//        studentBean.setName("zhangsan");
        System.out.println(studentBean);

    }
}
