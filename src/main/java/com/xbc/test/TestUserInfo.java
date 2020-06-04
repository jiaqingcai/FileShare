package com.xbc.test;

import com.xbc.entity.TbUser;
import com.xbc.mapper.TbUserMapper;
import com.xbc.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class TestUserInfo {
    public static void main(String[] args) {
        SqlSession SqlSession= SqlSessionFactoryUtils.getSqlSession();
        TbUserMapper TbUserMapper=SqlSession.getMapper(com.xbc.mapper.TbUserMapper.class);
        TbUser TbUser=new TbUser();
        TbUser.setId(1);
        TbUser.setName("小白");
        TbUser.setPhone("18020748867");
      int a=  TbUserMapper.upadteinfo(TbUser);
        SqlSession.commit();
        System.out.println("a"+a);
    }
}
