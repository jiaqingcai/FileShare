<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/10
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
	<title>文件上传</title>
	<%
		String path=request.getContextPath();
	%>
<%--	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/layui/css/layui.css" media="all">--%>
	<link rel="stylesheet" href=<%=path+"/css/layui.css"%>>
	<script type="text/javascript" src=<%=path+"/js/jquerystaff.js"%>></script>
<%--	<script charset="UTF-8" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>--%>
</head>
<body>
<%--<form action="adminControl/upload" enctype="multipart/form-data">--%>
<input type="hidden" id="path" value="<%=path%>">
<button type="button" class="layui-btn" id="test1">
	<i class="layui-icon">&#xe67c;</i>上传文件
</button>
<div class="layui-form">
	<div class="layui-form-item">
		<label class="layui-form-label">文档标题</label>
		<div class="layui-input-inline">
			<input type="text" name="name1" id="name1" lay-verify="required" placeholder="请输入文档标题" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">下载积分</label>
		<div class="layui-input-inline">
			<input type="text" name="score" id="score" lay-verify="required" placeholder="请输入下载积分" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-inline">
			<input type="button" class="layui-input" id="btn" value="立即上传">
		</div>
	</div>
</div>

<%--</form>--%>
<script src=<%=path+"/js/layui.js"%>></script>
<%--<script src="${pageContext.request.contextPath}/js/layui/layui.js"></script>--%>
<script>
	layui.use(['upload','jquery'] ,function(){
		var upload = layui.upload;
		$=layui.jquery;
		var path=$("#path").val();
		//执行实例
		var uploadInst = upload.render({
			elem: '#test1' //绑定元素
			// ,accept: 'file'
			,auto: false
			,bindAction: '#btn'
			,before:function () {
				// this.data={
				//
				// 	name:$("#name1").val(),
				// 	score:$("#score").val()
				// }
			}
			,url:"adminControl/upload"
			,done: function(res){
				alert(res.msg);
			}
			,error: function(){
				alert("上传失败")
				//请求异常回调
			}
		});
	});
</script>
</body>
</html>
