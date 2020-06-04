var msg=new $.zui.Messager('这是一个浮动消息。', {
    icon: 'bell', // 定义消息图标
    placement: 'center' // 定义显示位置
});



$(function () {
    $("input[name='login']").click(function () {
        msg.show("点击登录");
        if(!validate()){
            return;
        }
        var account = $("input[name='username']").val();
        var pwd = $("input[name='pwd']").val();
       var data={
            account:account,
            pwd:pwd
        }
      ajaxmethd("LoginCheckServlet",data,function (sendmsg) {
        if (sendmsg.trim()==1){
            msg.show("登录成功");
        }else{
            msg.show("登录失败");
        }
      },function () {


      },function () {


      });
    });
});

function validate() {
    return $("#formLogin").validate({
        //把错误信息统一放在一个容器里面。
        errorLabelContainer: ".messageBox",
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

