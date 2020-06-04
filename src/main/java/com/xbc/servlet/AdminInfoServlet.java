package com.xbc.servlet;

import com.alibaba.fastjson.JSON;
import com.xbc.entity.TbUser;
import com.xbc.mapper.TbUserMapper;
import com.xbc.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminInfoServlet",urlPatterns = "/AdminInfoServlet")
public class AdminInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AdminInfoServlet doPost");
        String name=request.getParameter("username");
        String userid=request.getParameter("userid");
        String flagStr=request.getParameter("flag");
        SqlSession SqlSession= SqlSessionFactoryUtils.getSqlSession();
        TbUserMapper TbUserMapper=SqlSession.getMapper(com.xbc.mapper.TbUserMapper.class);
        if("updateinfo".equals(flagStr)){
            String phone=request.getParameter("phone");
            TbUser TbUser=new TbUser();
            TbUser.setId(Integer.valueOf(userid));
            TbUser.setName(name);
            TbUser.setPhone(phone);
            int a=  TbUserMapper.upadteinfo(TbUser);
            SqlSession.commit();
            if (a>0){
                response.getWriter().write("1");
            }else{
                response.getWriter().write("0");
            }

//            System.out.println("phone"+phone);
        }
//        System.out.println("name"+name);
//        System.out.println("userid"+userid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
