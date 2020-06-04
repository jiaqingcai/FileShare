package com.xbc.servlet;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.xbc.entity.TbAdmin;
import com.xbc.mapper.TbAdminMapper;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.MapListHandler;
import com.xbc.service.impl.AdminServiceImpl;
import com.xbc.service.interfacee.AdminService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

@WebServlet(name = "LoginCheckServlet",urlPatterns = "/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    @Autowired
    private AdminService AdminService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("LoginCheckServlet");
        Object object = null;
       String account= request.getParameter("userAccount");
        String pwd= request.getParameter("password");
//        String config="SqlMapConfig.xml";
//        InputStream inputStream= Resources.getResourceAsStream(config);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 然后根据 sqlSessionFactory 得到 session  true 自动提交
//        SqlSession session = sqlSessionFactory.openSession();
        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        TbAdmin tbAdmin=new TbAdmin();
        tbAdmin.setAdminAccount(account);
        tbAdmin.setAdminPwd(pwd);
//        TbAdmin loginAdmin=session.selectOne("adminspace.logincheck",tbAdmin);
//        TbAdminMapper tbAdminMapper=session.getMapper(TbAdminMapper.class);
//        TbAdmin loginAdmin=tbAdminMapper.logincheck(tbAdmin);
        String confxml = "SpringIocConfig.xml";
        ApplicationContext conf = new ClassPathXmlApplicationContext(confxml);
       AdminServiceImpl AdminServiceImpl= (com.xbc.service.impl.AdminServiceImpl) conf.getBean("adminService");
      TbAdmin  loginAdmin= AdminServiceImpl.logincheck(tbAdmin);

        System.out.println(loginAdmin);
        if (loginAdmin!=null){
            request.getSession().setAttribute("admin",loginAdmin);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"UTF-8"));
            pw.println("true");
            pw.flush();
            System.out.println("用户："+loginAdmin);
        }else{
            System.out.println("用户为空");
        }
//        QueryRunner qr = new QueryRunner(C3p0Util.getInstance().getDataSource());
//        Connection conn=C3p0Util.getInstance().getConnection();
//        String sql="select * from tb_admin WHERE admin_account=? AND admin_pwd=?";
//        try {
//            object= qr.query(sql,new MapListHandler(),account,pwd);
//            System.out.println("object"+object);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        if (object!=null){
//            System.out.println("登录成功");
////            response.sendRedirect("index.jsp");
//            PrintWriter pw = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"UTF-8"));
//            pw.println("true");
//            pw.flush();
//        }else{
//            System.out.println("登录失败");
//        }
//        sqlsession.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
