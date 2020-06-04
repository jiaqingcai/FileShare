<%--
  Created by IntelliJ IDEA.
  User: 蔡佳庆
  Date: 2020/5/13
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>

<html>

<head>
    <title>Title</title>
    <script type="text/javascript" src=<%=path+"/js/util.js"%>></script>
    <link rel="stylesheet" href=<%=path+"/css/layui.css"%>>
    <link rel="stylesheet" href=<%=path+"/css/layui.mobile.css"%>>
    <script type="text/javascript" src=<%=path+"/js/jquerystaff.js"%>></script>
    <script type="text/javascript" src=<%=path+"/js/layui.js"%>></script>
    <script type="text/javascript" src=<%=path+"/js/layui.all.js"%>></script>
</head>
<body>
<style>
    .layui-table-page select{
        height: 27px;
    }
</style>
<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
        <button class="layui-btn layui-btn-sm" lay-event="add">增加</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<%--<script src="http//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>--%>
<%--<script src="<%=path+"/js/layui.js"%>" charset="utf-8"></script>--%>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>

    // layui.use('form', function() {
    //     var form = layui.form;
    //
    //     form.on('submit(formDemo)', function(data){
    //         layer.msg(JSON.stringify(data.field));
    //         return false;
    //     });
    //
    // } );
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'../../adminControl/userList'
            // ,url:'/FileShare/demo1.json'
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            // ,data:'resultData'
            ,title: '用户数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'center'}
                ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
                ,{field:'account', title:'账号', width:80, edit: 'text'}
                ,{field:'uemail', title:'邮箱', width:250, edit: 'text'}
                ,{field:'sex', title:'性别', width:80, edit: 'text', sort: true}
                ,{field:'name', title:'用户名', width:100}
                // ,{field:'sign', title:'签名'}
                ,{field:'integral', title:'积分', width:80, sort: true}
                ,{ title:'会员等级', width:100, templet: '<div>{{d.tbLevel.lName}}</div>'}
                ,{field:'phone', title:'电话', width:120}
                // ,{field:'integral', title:'积分', width:100, sort: true}
                ,{field:'regtimr', title:'加入时间', width:200}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            // ,cols: [[
            //     {type: 'checkbox', fixed: 'left'}
            //     ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
            //     ,{field:'account', title:'账号', width:120, edit: 'text'}
            //     // ,{field:'email', title:'邮箱', width:150, edit: 'text', templet: function(res){
            //     //         return '<em>'+ res.email +'</em>'
            //     //     }}
            //     ,{field:'sex', title:'性别', width:80, edit: 'text', sort: true}
            //     ,{field:'phone', title:'电话', width:100}
            //     ,{field:'name', title:'用户名'}
            //     ,{field:'state', title:'状态', width:80, sort: true}
            //     // ,{field:'ip', title:'IP', width:120}
            //     // ,{field:'logins', title:'登入次数', width:100, sort: true}
            //     ,{field:'regtimr', title:'加入时间', width:120}
            //     ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            // ]]
            ,page: {limit: 5,//指定每页显示的条数
                limits: [5, 10, 15, 20,
                    25, 30, 35, 40, 45, 50],},//每页条数的选择项

        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选');
                    break;
                    case 'add':
                        layer.open({
                            type: 1
                            ,title: '增加用户'
                            ,closeBtn:'1'
                            ,area:'500'
                            ,content: '<form class="layui-form" >\n' +
                                '  <div class="layui-form-item">\n' +
                                '    <label class="layui-form-label">账号</label>\n' +
                                '    <div class="layui-input-block">\n' +
                                '      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
                                '    </div>\n' +
                                ' <div class="layui-form-item">\n' +
                                '    <label class="layui-form-label">用户名</label>\n' +
                                '    <div class="layui-input-block">\n' +
                                '      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
                                '    </div>' +
                                ' <div class="layui-form-item">\n' +
                                '    <label class="layui-form-label">电话</label>\n' +
                                '    <div class="layui-input-block">\n' +
                                '      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
                                '    </div>' +
                                '  </div>\n' +
                                '  <div class="layui-form-item">\n' +
                                '    <label class="layui-form-label">密码框</label>\n' +
                                '    <div class="layui-input-inline">\n' +
                                '      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">\n' +
                                '    </div>' +
                                ' <div class="layui-form-item">\n' +
                                '    <label class="layui-form-label">邮箱</label>\n' +
                                '    <div class="layui-input-block">\n' +
                                '      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">\n' +
                                '    </div>' +
                                '<div class="layui-form-item">\n' +
                                '    <label class="layui-form-label">单选框</label>\n' +
                                '    <div class="layui-input-block">\n' +
                                '      <input type="radio" name="sex" value="男" title="男">\n' +
                                '      <input type="radio" name="sex" value="女" title="女" checked>\n' +
                                '    </div>\n' +
                                '  </div>' +

                                ' <div class="layui-form-item">\n' +
                                '    <div class="layui-input-block">\n' +
                                '      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                                '      <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                                '    </div>\n' +
                                '  </div>\n' +
                                '</form>'
                            ,btn: 0
                        });
                        // form.render();
                        layui.use('form',function(){
                        var form = layui.form;
                            form.render();
                            form.on('submit(formDemo)', function(data){
                                layer.msg("123");
                              // layui.form.submit();
                                var data={
                                    "name":"123123",
                                    "userid":data.userid
                                };
                                ajaxmethd("/FileShare/AdminInfoServlet",data,function (msg) {
                                        alert("123343");
                                });
                                // layer.msg(JSON.stringify(data.field));
                                return false;
                            });

                    });


                        break;


                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){

                    ajaxmethd()
                    obj.del();

                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                var userid=data.id;
                alert("data"+data.id)
                layer.open({
                    title: '修改用户信息'
                    ,btn: 0
                    // ,closeBtn:'0'
                    ,area:'500'
                    ,content: '<form class="layui-form" action="">\n' +
                        '  <div class="layui-form-item">\n' +
                        '    <label class="layui-form-label">用户名</label>\n' +
                        '    <div class="layui-input-block">\n' +
                        '      <input type="text" name="username" required  lay-verify="required" autocomplete="off" class="layui-input" value='+data.name+'>\n' +
                        '    </div>\n' +
                        ' <div class="layui-form-item">\n' +
                        '    <label class="layui-form-label">电话</label>\n' +
                        '    <div class="layui-input-block">\n' +
                        '      <input type="text" name="userphone" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" value='+data.phone+'>\n' +
                        '    </div>' +
                        '<div class="layui-form-item">\n' +
                        '    <label class="layui-form-label">单选框</label>\n' +
                        '    <div class="layui-input-block">\n' +
                        '      <input type="radio" name="sex" value="男" title="男">\n' +
                        '      <input type="radio" name="sex" value="女" title="女" >\n' +
                        '    </div>\n' +
                        '  </div>' +
                        ' <div class="layui-form-item">\n' +
                        '    <div class="layui-input-block">\n' +
                        '      <button class="layui-btn" lay-submit lay-filter="formDemo">确认</button>\n' +
                        '      <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                        '    </div>\n' +
                        '  </div>\n' +
                        '</form>'
                });

                layui.use('form',function(){
                    var form = layui.form;
                    form.render();
                    form.on('submit(formDemo)', function(data){
                        // layer.msg("123");
                        // layui.form.submit();
                        var data={
                            "flag":"updateinfo",
                            "phone":$("input[name='userphone']").val(),
                            "username":$("input[name='username']").val(),
                            "userid":userid
                        };
                        ajaxmethd("/FileShare/AdminInfoServlet",data,function (msg) {
                            alert("修改成功");
                        });
                        // layer.msg(JSON.stringify(data.field));
                        return false;
                    });

                });
                // layer.prompt({
                //     formType: 2
                //     ,value: data.name
                // }, function(value, index){
                //     obj.update({
                //         email: value
                //     });
                //     layer.close(index);
                // });
            }
        });



    });







</script>

</body>
</html>
