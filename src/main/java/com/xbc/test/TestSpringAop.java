package com.xbc.test;

import com.xbc.entity.TbAdmin;
import com.xbc.service.impl.AdminServiceImpl;
//import javabean.TbUser;
//import mapper.TbUserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAop {

    public  void test02(){

    }
//    1.纯java
//    public static void main(String[] args) {
//        Test test = new Test();
//        ApplicationContext acc = new ClassPathXmlApplicationContext("AppliConfiog2.xml");
//        Sleepable sleeper = (Sleepable) acc.getBean("student");
//        sleeper.sleep();
//
//        test.test02();
//    }
    public static void main(String[] args) {
        ApplicationContext acc = new ClassPathXmlApplicationContext("spring-mvc1.xml");
        AdminServiceImpl AdminServiceImpl = (AdminServiceImpl) acc.getBean("adminService");
        TbAdmin TbAdmin=new TbAdmin();
        AdminServiceImpl.insertAdmin(TbAdmin);

    }
}
