package com.xbc.servlet;


import com.alibaba.fastjson.JSON;
import com.xbc.entity.TbAdmin;
import com.xbc.entity.TbMenu;
import com.xbc.entity.TbRole;
import com.xbc.entity.TbUser;
import com.xbc.mapper.TbAdminMapper;
import com.xbc.mapper.TbMenuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {

    public static void main(String[] args) throws IOException {
//        String config="SqlMapConfig.xml";
//        InputStream inputStream= Resources.getResourceAsStream(config);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 然后根据 sqlSessionFactory 得到 session  true 自动提交
//        SqlSession session = sqlSessionFactory.openSession();
        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent

//        TbUser tbUser=new TbUser();
//        tbUser.setAccount("002");
//        tbUser.setPassword("123");
//        tbUser.setName("大白");
//        tbUser.setSex("男");
//        tbUser.setState("启用");
//        tbUser.setPhone("15159245354");
//        tbUser.setUemail("921504071@qq.com");
//        tbUser.setIntegral(100);
//       int num= session.insert("userSpace.insertUser",tbUser);
//        session.commit();
//       if (num>0){
//           System.out.println("注册成功");
//       }else{
//           System.out.println("注册失败");
//       }
//        TbUser loginUser= session.selectOne("userSpace.insertUser",tbUser);
//        if (loginUser!=null){
//            System.out.println("登录成功");
//        }else{
//            System.out.println("登录失败");
//        }
//        TbAdmin tbAdmin=new TbAdmin();
//        tbAdmin.setAdminAccount("admin10");
//        tbAdmin.setAdminPwd("123");
//        TbAdminMapper tbAdminMapper= session.getMapper(TbAdminMapper.class);
//        int num=tbAdminMapper.insertAdmin(tbAdmin);
//        session.commit();
//        System.out.println("tbAdmin"+ JSON.toJSONString(tbAdmin));
//        if (num>0){
//            System.out.println("添加成功");
//        }else{
//            System.out.println("添加失败");
//        }
//        TbAdmin loginAdmin=session.selectOne("adminspace.logincheck",tbAdmin);
//        System.out.println(loginAdmin);
//        if (loginAdmin!=null){
//            System.out.println("用户："+loginAdmin);
//        }else{
//            System.out.println("用户为空");
//        }
//       List<TbUser> list= session.selectList("userSpace.Userlist");
//        System.out.println("list"+list);




        try {
            String config = "SqlMapConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(config);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            TbMenuMapper roleMapper = sqlSession.getMapper(TbMenuMapper.class);
//            TbAdmin admin = (TbAdmin) request.getSession().getAttribute("admin");
            List<TbRole> list = roleMapper.findAllByIdResult(1);
            List<Integer> menuIdList = new ArrayList<Integer>();
            for (TbMenu tabMenu : list.get(0).getMenuList()) {
                Integer menuID = tabMenu.getId();
                menuIdList.add(menuID);
            }
            List<TbMenu> menuList = roleMapper.findSecondMenu(menuIdList);
            sqlSession.close();
            Map<String, List<TbMenu>> menuMap = new HashMap<String, List<TbMenu>>();
            List<TbMenu> secondMenuList = null;
            for (TbMenu fristMenu : list.get(0).getMenuList()) {
                secondMenuList = new ArrayList<TbMenu>();
                if (!menuMap.containsKey(fristMenu.getMenuName())) {//判断key是否存在
                    for (TbMenu secondMenu : menuList) {

                        if (fristMenu.getId() == secondMenu.getUpid()) {
                            secondMenuList.add(secondMenu);
                        }
                    }
                    menuMap.put(fristMenu.getMenuName(), secondMenuList);
                }
            }
//            request.setAttribute("list",menuMap);
            System.out.println("menuMap"+menuMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

//
    }

    public void deleteTest() throws IOException {
        String config="SqlMapConfig.xml";
        InputStream inputStream= Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session  true 自动提交
        SqlSession session = sqlSessionFactory.openSession();
        session.delete("adminspace.deleteadmin",5);
        session.commit();
        session.close();
    }

}
