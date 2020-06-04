package com.xbc.control;

import com.alibaba.fastjson.JSON;
import com.xbc.entity.*;
import com.xbc.service.interfacee.AdminService;
import com.xbc.service.interfacee.MenuService;
import com.xbc.service.interfacee.UserServicce;
import com.xbc.util.LayuiData;
import com.xbc.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

//@SuppressWarnings("all")
@Controller
@RequestMapping("/adminControl")
public class AdminControl {
    @Autowired
    public AdminService adminService;
    @Autowired
    public MenuService MenuService;
    @Autowired
    public UserServicce UserServicce;


    @RequestMapping(value = "/login")
    @ResponseBody
    public TbAdmin login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account= request.getParameter("userAccount");
        String pwd= request.getParameter("password");
        TbAdmin TbAdmin = new TbAdmin();
        TbAdmin.setAdminPwd(pwd);
        TbAdmin.setAdminAccount(account);
        TbAdmin=adminService.logincheck(TbAdmin);
        if (TbAdmin!=null){
            request.getSession().setAttribute("admin",TbAdmin);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"UTF-8"));
            pw.println("true");
            pw.flush();
            System.out.println("用户："+TbAdmin);
        }else{
            System.out.println("用户为空");
        }
//        admin = adminService.login(admin);
//        Map<String, Object> map = null;
//        if (admin != null) {
//            System.out.println(admin);
//            map = ResultUtil.success();
//            request.getSession().setAttribute("admin", admin.getAdminName());
//
//        } else {
//            System.out.println("登录失败");
//            map = ResultUtil.fail("登录失败");
//        }
//        return JSON.toJSONString(map);
        return null;
    }
@RequestMapping(value = "/adminMenu")
public  ModelAndView selectAdminMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
    TbAdmin admin = (TbAdmin) request.getSession().getAttribute("admin");
            System.out.println("角色id"+admin);
            System.out.println("MenuService:"+MenuService);
    List<TbRole> list = MenuService.findAllByIdResult(admin.getRoleId());

    List<Integer> menuIdList = new ArrayList<Integer>();
    for (TbMenu tabMenu : list.get(0).getMenuList()) {
        Integer menuID = tabMenu.getId();
        menuIdList.add(menuID);
    }
    List<TbMenu> menuList = MenuService.findSecondMenu(menuIdList);
//    sqlSession.close();
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
    request.getSession().setAttribute("list",menuMap);
} catch (Exception e) {
        e.printStackTrace();
    }
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("/jsp/text");
    return modelAndView;
//        request.getRequestDispatcher("back/jsp/text.jsp").forward(request, response);

}
@RequestMapping(value = "/userList")
public void selectUserList(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<TbUser> userList= UserServicce.findById();
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
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"UTF-8"));
        pw.println(JSON.toJSONString(layuiData));
        pw.flush();
//        response.getWriter().write();
    } else {
        System.out.println("登录失败");
        response.getWriter().write(JSON.toJSONString(ResultUtil.fail("查询失败")));

    }

}
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Object upload(HttpServletRequest request, HttpServletResponse response, MultipartFile file,String fileName) {
        System.out.println("fileName=" + fileName);
        try {
            //获取文件名
            String originalName = file.getOriginalFilename();
            //扩展名
            String prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
            Date date = new Date();
            //使用UUID+后缀名保存文件名，防止中文乱码问题
            String uuid = UUID.randomUUID() + "";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = simpleDateFormat.format(date);
            String savePath = request.getSession().getServletContext().getRealPath("/upload/");
            //要保存的问题件路径和名称
            String projectPath = savePath + dateStr + File.separator + uuid + "." + prefix;
            System.out.println("projectPath==" + projectPath);
            File files = new File(projectPath);
            //打印查看上传路径
            if (!files.getParentFile().exists()) {//判断目录是否存在
                System.out.println("files11111=" + files.getPath());
                files.getParentFile().mkdirs();
            }
            file.transferTo(files); // 将接收的文件保存到指定文件中
            System.out.println(projectPath);
            LayuiData layuiData = new LayuiData();
            layuiData.setCode(0);
            layuiData.setMsg("上传成功");
            return JSON.toJSONString(layuiData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        @PostMapping(value = "/findMenu")
        @ResponseBody
        public Object findPower(){

            List<TbMenu> menuList = new ArrayList<>();
            menuList.add(new TbMenu(1, 0, "用户管理", 1));
            menuList.add(new TbMenu(2, 0, "文档管理", 1));
            menuList.add(new TbMenu(3, 1, "用户查询", 2));
            menuList.add(new TbMenu(4, 1, "管理员查询", 2));
            menuList.add(new TbMenu(5, 3, "111", 3));
            menuList.add(new TbMenu(6, 2, "文档查询", 2));

            List<Integer> ids = new ArrayList<>();
            ids.add(1); 
            return menuList.stream()
                    .filter(m -> m.getMenuLevel() == 1)
                    .map(m -> {
                        MenuNode node = new MenuNode();
                        node.setId(m.getId());
                        node.setTitle(m.getMenuName());
                        if (ids.contains(m.getId())) {
                            node.setChecked(true);
                        }
                        setChildren(node, menuList, ids);
                        return node;
                    }).collect(Collectors.toList());

        }
    private  void setChildren(MenuNode n, List<TbMenu> menuList, List<Integer> ids) {
        boolean parentChecked = false;
        List<TbMenu> c = menuList.stream()
                .filter(m -> n.getId() == m.getUpid()).collect(Collectors.toList());
        if (c.isEmpty()) {
            return;
        }
        List<MenuNode> nodes = new ArrayList<>();
        for (TbMenu m : c) {
            MenuNode node = new MenuNode();
            node.setTitle(m.getMenuName());
            node.setId(m.getId());
            if (ids.contains(m.getId()) || n.isChecked()) {
                parentChecked = true;
                node.setChecked(true);
            }
            setChildren(node, menuList, ids);
            nodes.add(node);
        }
        n.setChildren(nodes);
        n.setChecked(parentChecked);
    }

    @RequestMapping(value = "/aa")
    @ResponseBody
    public Object aa(){
        return  "aa";
    }

}
