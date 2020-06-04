$(function () {
    $("input[name='reg']").click(function () {
        var account = $("input[name='user-account']").val();
        var pwd = $("input[name='user-pwd']").val();
        var name=$("input[name='user-name']").val();
        if (account==null||pwd==null||name == null){
            alert("账号或密码为空");
            return false;
        }
        alert(account);
        alert(pwd);
        var data={
            account:account,
            pwd:pwd,
            name:name
        }
        ajaxmethd("../UserRegServlet",data,function (msg) {
            if (msg.trim()==1){
                alert("注册成功");
            }else{
                alert("注册失败");
            }
        });
    });


});