<%--
  Created by IntelliJ IDEA.
  Date: 2020/5/12
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=<%=path+"/css/layui.css"%>>
    <link rel="stylesheet" href=<%=path+"/css/layui.mobile.css"%>>
    <script type="text/javascript" src=<%=path+"/js/jquerystaff.js"%>></script>
    <script type="text/javascript" src=<%=path+"/js/layui.js"%>></script>
    <script type="text/javascript" src=<%=path+"/js/layui.all.js"%>></script>
    <script type="text/javascript" src=<%=path+"/js/util.js"%>></script>
    <link rel="stylesheet" href=<%=path+"/css/tese.css"%>>
<%--    <script type="text/javascript" src=<%=path+"/css/tese.css"%>></script>--%>


</head>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">

<c:forEach var="i" step="1" begin="0" items="${sessionScope.list}">
    <li class="layui-nav-item">
    <a class="" href="javascript:;">${i.key}</a>

    <c:forEach var="j" step="1" begin="0" items="${i.value}">
        <dl class="layui-nav-child">
            <dd>
                <a href="<%=path+"/back/jsp/userselect.jsp"%>" target="myiframe">${j.menuName}</a>
            </dd>
        </dl>
    </c:forEach>

        </c:forEach>

<%--                <li class="layui-nav-item layui-nav-itemed">--%>
<%--                    <a class="" href="javascript:;">用户管理</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="javascript:;">用户查询</a></dd>--%>
<%--                        <dd><a href="<%=path+"/back/jsp/userselect.jsp"%>" target="myiframe">用户管控</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
<%--                <li class="layui-nav-item">--%>
<%--                    <a href="javascript:;">文档管理</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="javascript:;">文档审核</a></dd>--%>
<%--                        <dd><a href="javascript:;">文档配置</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
<%--                <li class="layui-nav-item">--%>
<%--                    <a href="javascript:;">日志管理</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="javascript:;">日志列表</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
<%--                <li class="layui-nav-item">--%>
<%--                    <a href="javascript:;">系统配置</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="javascript:;">上传奖励配置</a></dd>--%>
<%--                        <dd><a href="javascript:;">注册奖励配置</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
<%--        <div style="padding: 15px;">内容主体区域</div>--%>
        <iframe id="main" src="" name="myiframe"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src=<%=path+"/js/layui.js"%>></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>