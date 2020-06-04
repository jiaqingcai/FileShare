package com.xbc.servlet;

//import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSON;
import com.xbc.entity.TbUser;
import com.xbc.mapper.TbAdminMapper;
import com.xbc.mapper.TbUserMapper;
import com.xbc.util.LayuiData;
import com.xbc.util.ResultUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserListServlet",urlPatterns = "/UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserListServlet doPost ");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserListServlet doGet ");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String draw = request.getParameter("draw");//重绘次数 和前台对应
        String config="SqlMapConfig.xml";
        InputStream inputStream= Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session  true 自动提交
        SqlSession session = sqlSessionFactory.openSession();
        TbUserMapper tbUserMapper=session.getMapper(TbUserMapper.class);
        List<TbUser> userList= tbUserMapper.findById();
        System.out.println(userList);

        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(100);
        layuiData.setData(userList);
        layuiData.setMsg("成功");

//        Map<String, Object> map= ResultUtil.resultPageData("00","返回成功",userList,100,draw);

        if (layuiData!=null) {
//            System.out.println(admin);
//            request.getSession().setAttribute("admin", admin.getAdminName());
            response.getWriter().write(JSON.toJSONString(layuiData));
        } else {
            System.out.println("登录失败");
            response.getWriter().write(JSON.toJSONString(ResultUtil.fail("查询失败")));

        }


    }
}
