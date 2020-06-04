<%--
  Created by IntelliJ IDEA.
  User: ALL BULE
  Date: 2020/5/10
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/css/zui.min.css">
    <!-- ZUI Javascript 依赖 jQuery -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/lib/jquery/jquery.js"></script>
    <!-- ZUI 标准版压缩后的 JavaScript 文件 -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/zui/1.9.1/js/zui.min.js"></script>
    <title>Title</title>

    <style type="text/css">
    *{
        margin: 0;
        padding: 0;
    }
        div{
            box-sizing: border-box;
        }
        body{
            width: 100%;
            height: 100%;
        }
        .headerdiv{
            width: 100%;
            height: 100px;
            background-color:lightskyblue;
        }
    .leftside{
        width: 15%;
        height: 600px;
        float: left;
        background-color: #A9A9A9;
    }
        .rightside{
            width: 85%;
            height: 600px;
            float: right;
            /*background-color: red;*/
        }

    iframe{
        border: 2px solid #a9a9a9;
        margin: 10px;
        padding: 10px;
        width: 98%;
        height: 91%;
    }
    @media only screen and (min-width: 900px) {
    }

    @media only screen and (max-width: 768px) {
        body{
            width: 300px;
        }
    }
    span{
        margin-left: 100px;
        line-height: 100px;
        font-size: 24px;
    }

    </style>
</head>
<body>
<div class="headerdiv">
<%--    <h1>文件共享系统</h1>--%>
    <span>文件共享系统</span>
</div>
<div class="leftside">

    <nav class="menu" data-ride="menu" style="width: 100%">
        <ul id="treeMenu" class="tree tree-menu" data-ride="tree">
            <li><a href="#"><i class="icon icon-user"></i>用户管理</a>
                <ul>
                    <li><a href="#">用户查询</a></li>
                    <li><a href="#">用户管控</a></li>
                </ul>
            </li>
            <li><a href="#"><i class="icon icon-folder-close-alt"></i>文档管理</a>
                <ul>
                    <li><a href="#">文档审核</a></li>
                    <li><a href="#">文档配置</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="icon icon-time"></i>日志管理</a>
                <ul>
                    <li><a href="#">日志列表</a></li>
                </ul>
            </li>
            <li><a href="#"><i class="icon icon-wrench"></i>系统配置</a>
                <ul>
                    <li><a href="#">上传奖励配置</a></li>
                    <li><a href="#">注册奖励配置</a></li>
                </ul>
            </li>
<%--            <li><a href="#"><i class="icon icon-list-ul"></i>全部</a></li>--%>
<%--            <li class="open">--%>
<%--                <a href="#"><i class="icon icon-tasks"></i>状态</a>--%>
<%--                <ul>--%>
<%--                    <li>--%>
<%--                        <a href="#"><i class="icon icon-circle-blank"></i>已就绪</a>--%>
<%--                        <ul>--%>
<%--                            <li><a href="#">已取消</a></li>--%>
<%--                            <li><a href="#">已关闭</a></li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
<%--                    <li class="active"><a href="#"><i class="icon icon-play-sign"></i>进行中</a></li>--%>
<%--                    <li><a href="#"><i class="icon icon-ok-sign"></i>已完成</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>
        </ul>
    </nav>

</div>
<div class="rightside">
    <iframe id="main" src="" name="myiframe"></iframe>
</div>
<script>
    $('#treeMenu').on('click', 'a', function() {
        $('#treeMenu li.active').removeClass('active');
        $(this).closest('li').addClass('active');
    });
</script>
</body>
</html>
