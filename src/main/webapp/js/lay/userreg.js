
var msg=new $.zui.Messager('这是一个浮动消息。', {
    icon: 'bell', // 定义消息图标
    placement: 'center' // 定义显示位置
});

$(function () {
    var num = $("input[name='num']").val();
    if (num.trim()==1){
        alert("注册成功");
    }else{
        alert("注册失败");
    }
});