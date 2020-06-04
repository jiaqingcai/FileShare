
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path=request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>后台登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximnm-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/css/zui.min.css">

    <!-- ZUI Javascript 依赖 jQuery -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/lib/jquery/jquery.js"></script>
    <!-- ZUI 标准版压缩后的 JavaScript 文件 -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/js/zui.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"> </script>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        body{
            /*background-image: linear-gradient(to right,#fbc2eb, #a6c1ee);*/
            background-image: linear-gradient(to right,#e66465, #9198e5);
        }
        .my-panel {
            width: 500px;
            margin: 0 auto;
            margin-top: 260px;
        }

        .my-panel .panel-body>* {
            margin-top: 10px;
        }
        @media only screen and (min-width: 900px) {
        }

        @media only screen and (max-width: 768px) {
            .my-panel{
                width: 300px;
            }
        }

    </style>
</head>


<body>
<div class="panel my-panel">
    <div class="panel-heading">欢迎登录</div>
    <form action="LoginCheckServlet" method="post" id="loginform">
    <div class="panel-body">

        <div class="input-control has-icon-left">
            <input id="username" type="text" class="form-control" placeholder="用户名" name="username">
            <label for="username" class="input-control-icon-left"><i class="icon icon-user " ></i></label>
        </div>

        <div class="input-control has-icon-left">
            <input id="password" type="password" class="form-control" placeholder="密码" name="pwd">
            <label for="password" class="input-control-icon-left"><i class="icon icon-lock "></i></label>
        </div>

        <input class="btn btn-block " type="button" id="btnLogin" value="登录">
<%--        <button class="btn btn-block " type="button">立即注册</button>--%>
    </div>
        <div id="messageBox" style="color: red"></div>
    </form>

</div>
</body>

<script type="text/javascript">

    var msg=new $.zui.Messager('这是一个浮动消息。', {
        icon: 'bell', // 定义消息图标
        placement: 'center' // 定义显示位置
    });
    $(document).ready(function(){

        $("#btnLogin").click(function () {
            if (!validate()) {
                return;
            }
            alert("123");
            $.ajax({
                url: "LoginCheckServlet",
                type: 'POST',
                dataType: 'text',//预期服务器返回的数据类型text、json
                data: {
                    userAccount: $("#username").val(),
                    password: $("#password").val()
                },

                success: function (data, textStatus, xhr) {
                    alert(data);
                    if (data.trim()==="true") {
                        msg.show("登录成功");
                        window.location.href = "admin/jsp/backmain.jsp";
                    } else {
                        msg.show("登录失败");
                    }
                },
                beforeSend: function(){


                },
                error: function (xhr, textStatus, errorThrown) {

                },
                complete: function () {

                }
            });
        })});
    function validate() {
        return $("#loginform").validate({
            //把错误信息统一放在一个容器里面。
            errorLabelContainer: "#messageBox",
            //用什么标签再把上边的 errorELement 包起来。
            wrapper: "li",
            rules: {
                username: {
                    required: true,
                    rangelength: [2, 8]
                },
                pwd: {
                    required: true,
                    rangelength: [2, 8]
                }
            },
            messages: {
                username: {
                    required: "请输入用户名",
                    rangelength: "长度2到8个字符"
                }, pwd: {
                    required: "请输入密码",
                    rangelength: "长度2到8个字符"
                }
            }
        }).form();
    }


</script>

</html>

