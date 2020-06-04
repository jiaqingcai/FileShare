<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Layui</title>
    <meta name="renderer" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <%--        <link rel="stylesheet" href="<%=path+"/layui/css/layui.css"%>"  media="all">--%>
    <%--        <link rel="stylesheet" href=<%=path+"/css/layui.css"%>  media="all">--%>
    <link rel="stylesheet" href="<%=path%>/css/layui.css">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>基本演示</legend>
</fieldset>
<div class="layui-btn-container">
    <button type="button" class="layui-btn layui-btn-sm" lay-demo="getChecked">获取选中节点数据</button>
    <button type="button" class="layui-btn layui-btn-sm" lay-demo="setChecked">勾选指定节点</button>
    <button type="button" class="layui-btn layui-btn-sm" lay-demo="reload">重载实例</button>
</div>

<div id="test12" class="demo-tree-more"></div>
<script type="text/javascript" src="<%=path%>/js/layui.js"></script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

    layui.use(['tree', 'util'], function () {
        $ = layui.jquery;
        var tree = layui.tree
            , layer = layui.layer
            , util = layui.util
            , element = layui.element
        //模拟数据1
        let rend = function (d) {
            d = JSON.parse(d);
            tree.render({
                elem: '#test12'
                , data: d
                , showCheckbox: true  //是否显示复选框
                , id: 'demoId1'
                // ,isJump: true //是否允许点击节点时弹出新窗口跳转
                // ,click: function(obj){
                //     var data = obj.data;  //获取当前点击的节点数据
                //     layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
                // }
            });
            // element.render();
        }
        $.ajax({
            url: "/FileShare/adminControl/findMenu",
//dataType: 'text',
            contentType: "application/json",
            // data: user, //请求的附加参数，用json对象
            method: 'POST',
            async: false,
            success: function (res) {
                // alert(res);
                rend(res)
            }
        });


        //按钮事件
        // util.event('lay-demo', {
        //     getChecked: function(othis){
        //         var checkedData = tree.getChecked('demoId1'); //获取选中节点的数据
        //
        //         layer.alert(JSON.stringify(checkedData), {shade:0});
        //         console.log(checkedData);
        //     }
        //     ,setChecked: function(){
        //         tree.setChecked('demoId1', [12, 16]); //勾选指定节点
        //     }
        //     ,reload: function(){
        //         //重载实例
        //         tree.reload('demoId1', {
        //
        //         });
        //
        //     }
        // });
        tree.reload('demoId1');


    });
</script>

</body>
</html>