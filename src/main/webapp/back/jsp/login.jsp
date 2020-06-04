
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    -
<%--        <script type="text/javascript" src=<%=path+"/js/jquerystaff.js"%>></script>--%>
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/css/zui.min.css">

         <link rel="stylesheet" href=<%=path+"/css/login.css"%>>
        <!-- ZUI Javascript 依赖 jQuery -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/lib/jquery/jquery.js"></script>
        <!-- ZUI 标准版压缩后的 JavaScript 文件 -->

        <script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/js/zui.min.js"></script>
        <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"> </script>
        <script type="text/javascript" src=<%=path+"/js/util.js"%>></script>
        <script type="text/javascript" src=<%=path+"/js/login.js"%>></script>
    <title>文件共享系统登录</title>
</head>
<body>
<div class="login-box">
    <form class="" id="formLogin">
<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">标签区域</label>--%>
<%--            <div class="layui-input-block">--%>
<%--                原始表单元素区域--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="border-radius">
            <h1>文件共享系统登录</h1>
        </div>
<%--        <input type="text" name="title" required lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">--%>
        <input type="text" name="userAccount" placeholder="用户名" id="username">
        <input type="password" name="password" placeholder="密码" id="pwd">
        <input type="button" name="login" value="登录" class="btn">
    </form>
    <div class="messageBox">
    </div>
</div>
<%--<form class="layui-form" action="">--%>
<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">标签区域</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <label class="layui-form-label">账号</label>--%>
<%--            <div class="layui-input-block">--%>
<%--                <input type="text" name="title" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">密码</label>--%>
<%--            <div class="layui-input-inline">--%>
<%--                <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">--%>
<%--            </div>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--    </form>--%>

</body>
</html>

