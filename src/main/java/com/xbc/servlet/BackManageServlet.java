package com.xbc.servlet;

import com.xbc.entity.MenuNode;
import com.xbc.entity.TbAdmin;
import com.xbc.entity.TbMenu;
import com.xbc.entity.TbRole;
import com.xbc.mapper.TbMenuMapper;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "BackManageServlet", urlPatterns = "/BackManageServlet")
public class BackManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            String config = "SqlMapConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(config);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            TbMenuMapper roleMapper = sqlSession.getMapper(TbMenuMapper.class);
            TbAdmin admin = (TbAdmin) request.getSession().getAttribute("admin");
            List<TbRole> list = roleMapper.findAllByIdResult(admin.getRoleId());
            List<Integer> menuIdList = new ArrayList<Integer>();
            for (TbMenu tabMenu : list.get(0).getMenuList()) {
                Integer menuID = tabMenu.getId();
                menuIdList.add(menuID);
            }

            List<TbMenu> menuList = roleMapper.findSecondMenu(menuIdList);

//            List<MenuNode> nodes = menuList.stream()
//                    .filter(m -> m.getMenuLevel() == 1)
//                    .map(m -> {
//                        MenuNode node = new MenuNode();
//                        node.setId(m.getId());
//                        node.setName(m.getMenuName());
//                        return node;
//                    })
//                    .collect(Collectors.toList());
//            nodes.forEach(n -> setChildren(n, menuList));

            sqlSession.close();
            Map<String, List<TbMenu>> menuMap = new HashMap<String, List<TbMenu>>();
            List<TbMenu> secondMenuList = null;
            for (TbMenu fristMenu : list.get(0).getMenuList()) {
                secondMenuList = new ArrayList<TbMenu>();
                if (!menuMap.containsKey(fristMenu.getMenuName())) {
                    for (TbMenu secondMenu : menuList) {

                        if (fristMenu.getId() == secondMenu.getUpid()) {
                            secondMenuList.add(secondMenu);
                        }
                    }
                    menuMap.put(fristMenu.getMenuName(), secondMenuList);
                }
            }
            request.setAttribute("list", menuMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("back/jsp/text.jsp").forward(request, response);
    }

//    private void setChildren(MenuNode n, List<TbMenu> menuList) {
//        n.setChildren(menuList.stream()
//                .filter(m -> n.getId() == m.getUpid())
//                .map(m -> {
//                    MenuNode node = new MenuNode();
//                    node.setName(m.getMenuName());
//                    node.setId(m.getId());
//                    setChildren(node, menuList);
//                    return node;
//                }).collect(Collectors.toList()));
//
//    }

}
