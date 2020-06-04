package com.xbc.servlet;

import com.xbc.entity.TbAdmin;
import com.xbc.entity.TbUser;
import com.xbc.mapper.TbAdminMapper;
import com.xbc.mapper.TbUserMapper;
import com.xbc.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test513 {
    public static void main(String[] args) throws IOException {
//        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
//        String config="SqlMapConfig.xml";
//        InputStream inputStream= Resources.getResourceAsStream(config);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 然后根据 sqlSessionFactory 得到 session  true 自动提交
//        SqlSession session = sqlSessionFactory.openSession();
//        TbAdminMapper tbAdminMapper= session.getMapper(TbAdminMapper.class);
//        TbAdmin tbAdmin=new TbAdmin();
//        tbAdmin.setAdminAccount("admin");
//        tbAdmin.setAdminPwd("123");
//        TbAdmin loginUser= tbAdminMapper.logincheck(tbAdmin);
//        if (loginUser!=null){
//            System.out.println("登录成功");
//        }else{
//            System.out.println("登录失败");
//        }

        //=================================
//        TbUser tbUser=new TbUser();
//        tbUser.setAccount("005");
//        tbUser.setPassword("123");
//        tbUser.setName("小黄");
//        tbUser.setSex("男");
//        tbUser.setState("启用");
//        tbUser.setPhone("15159245354");
//        tbUser.setUemail("921504071@qq.com");
//        tbUser.setIntegral(100);
//        TbUserMapper tbUserMapper=session.getMapper(TbUserMapper.class);
//        int num=tbUserMapper.insertUser(tbUser);
//        session.commit();
//        if(num>0){
//            System.out.println(tbUser);
//        }else{
//            System.out.println("0");
//        }
       SqlSession SqlSession= SqlSessionFactoryUtils.getSqlSession();
        TbUserMapper tbUserMapper=SqlSession.getMapper(TbUserMapper.class);
        tbUserMapper.findById();
        System.out.println(tbUserMapper.findById());
    }
}
