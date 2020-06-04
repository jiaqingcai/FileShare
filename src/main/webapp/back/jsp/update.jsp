<%--
  Created by IntelliJ IDEA.
  User: junlong
  Date: 2019-11-13
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<%
		String path=request.getContextPath();
	%>
	<title>修改</title>
	<link rel="stylesheet" href=<%=path+"/css/layui.css"%>>
	<script type="text/javascript" src=<%=path+"/js/jquerystaff.js"%>></script>
<%--	<link rel="stylesheet" type="text/css" href="../js/layui/css/layui.css"/>--%>
<%--	<script type="text/javascript" src="../js/layui/layui.js"></script>--%>
</head>
<body>
<form class="layui-form" action="" lay-filter="test1" onsubmit="return false;">
	<div class="layui-form-item">
		<label class="layui-form-label">单选框</label>
		<div class="layui-input-block">
			<c:if test="${not empty list}">
				<c:forEach var="test" items="${list}">
					<input type="radio" name="id" value="${test.id}" title="${test.id}">
				</c:forEach>
			</c:if>
		</div>
	</div>
	
	<div class="layui-form-item" style="margin-top: 50px">
		<label class="layui-form-label">用户名</label>
		<div class="layui-input-inline">
			<input type="text" name="name" required  lay-verify="required" placeholder="请输入用户名" autocomplete="on" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">地址</label>
		<div class="layui-input-inline">
			<input type="text" name="address" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">电话</label>
		<div class="layui-input-inline">
			<input type="text" name="tel" required  lay-verify="required|phone|number" placeholder="请输入手机号" autocomplete="on" class="layui-input">
		</div>
	</div>

</form>
<script src=<%=path+"/js/layui.js"%>></script>
<script>
	//Demo
	layui.use('form', function(){
		var form = layui.form;
	});
</script>
</body>
</html>