package com.xbc.test;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.xbc.entity.TbAdmin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIoc {
    public static void main(String[] args) {
        String confxml = "SpringIocConfig.xml";
        ApplicationContext conf = new ClassPathXmlApplicationContext(confxml);
       TbAdmin TbAdmin= (com.xbc.entity.TbAdmin) conf.getBean("admin");
        System.out.println("TbAdmin"+TbAdmin);
        DruidAbstractDataSource DruidAbstractDataSource= (com.alibaba.druid.pool.DruidAbstractDataSource) conf.getBean("dataSource");
        System.out.println("DruidAbstractDataSource"+DruidAbstractDataSource.getUrl());
    }
}
