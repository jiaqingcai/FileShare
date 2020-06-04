package com.xbc.inte;

import com.xbc.entity.TbAdmin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginInteTest implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        TbAdmin admin = (TbAdmin) request.getSession().getAttribute("admin");

        if (admin != null) {
            System.out.println("已有用户登录");
            //用户已登录
            return true;
        } else {
            //用户未登录
            if (request.getHeader("x-requested-with") != null
                    && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                //处理ajax请求
                System.out.println("ajax调用");
                response.setHeader("sessionstatus", "timeout") ;
                response.setStatus(403);
            } else {
                response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            }
            return false;
        }
    }
}
