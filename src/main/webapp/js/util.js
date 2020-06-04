




function createCode(length) {
  var code = "";
  var codeLength = parseInt(length); //验证码的长度
  var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
      'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
  //循环组成验证码的字符串
  for (var i = 0; i < codeLength; i++)
  {
    //获取随机验证码下标
    var charNum = Math.floor(Math.random() * 62);
    //组合成指定字符验证码
    code += codeChars[charNum];
  }
  return code;
}





function jujge(name) {
  if ($("name").val()==""){
    alert("llllllll");
    $("name").attr("class","empty");
  }else{
    $("name").attr("class","notempty");
  }
}

function filterSpaceNode(nodes){
  for(var i = 0;i<nodes.length;i++){
    if(nodes[i].nodeType==3 && /^\s+$/.test(nodes[i].nodeValue))
    {
      //得到空白节点之后，返回父节点删除子节点
      nodes[i].parentNode.removeChild(nodes[i]);
    }
  }
  return nodes;
}

//ajax方法
function ajaxmethd(sendUrl,sendData,fun,beforsendfun,completefun) {
  $.ajax({
    type:"POST",
    url:sendUrl,
    data:sendData,
    dataType:"text",
    success:fun,
    error:function(){
      alert("服务器正忙");
    }
  });
}

//dialog方法
function dialogmethd(divName,title,cfun) {
  $(divName).dialog({
    modal: true,
    autoOpen: false,
    width: 400,
    height: 500,
    title: title,
    position: {my: "center", at: "center", of: window},
    hide: {effect: "highlight", duration: 1000},
    show: {effect: "highlight", duration: 1000},
    maxWidth: 270,
    minWidth: 270,
    minHeight: 370,
    buttons: [
      {
        text: "确定",
        icon: "ui-icon-check",
        click: cfun

      },
      {
        text: "取消",
        icon: "ui-icon-closethick",
        click: function () {
          $(this).dialog("close");
        }
      }

    ]
  });
}

//判断内容是否是数字
function checkNumber(theObj) {
  var reg = /^[0-9]+.?[0-9]*$/;
  if (reg.test(theObj)) {
    return true;
  }
  return false;
}

//判断时间
function compareDate(dateTime1, dateTime2) {
  var formatDate1 = new Date(dateTime1);
  var formatDate2 = new Date(dateTime2);

  if (formatDate1 > formatDate2) {
    alert("开始时间不能大于截止时间，请重新输入")
    return false;
  }
  return true;
}

//获取时间
function gettime() {
  var d = new Date();//获取当前时间
  var n = d.getFullYear();
  var day = d.getDate();//获取当前时间中的年月日
  var mo = d.getMonth() + 1;
  if (mo < 10) {
    mo = '0' + mo;
  }
  var currdate = n + "-" + mo + "-" + day;
  return currdate;
}

// function validateIdCard(idCard) {
//   //15位和18位身份证号码的正则表达式
//   var regIdCard = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
//   //如果通过该验证，说明身份证格式正确，但准确性还需计算
//   if (regIdCard.test(idCard)) {
//     if (idCard.length == 18) {
//       var idCardWi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); //将前17位加权因子保存在数组里
//       var idCardY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
//       var idCardWiSum = 0; //用来保存前17位各自乖以加权因子后的总和
//       for (var i = 0; i < 17; i++) {
//         idCardWiSum += idCard.substring(i, i + 1) * idCardWi[i];
//       }
//       var idCardMod = idCardWiSum % 11;//计算出校验码所在数组的位置
//       var idCardLast = idCard.substring(17);//得到最后一位身份证号码
//       //如果等于2，则说明校验码是10，身份证号码最后一位应该是X
//       if (idCardMod == 2) {
//         if (idCardLast == "X" || idCardLast == "x") {
//           return true;
//           //alert("恭喜通过验证啦！");
//         } else {
//           return false;
//           //alert("身份证号码错误！");
//         }
//       } else {
//         //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
//         if (idCardLast == idCardY[idCardMod]) {
//           //alert("恭喜通过验证啦！");
//           return true;
//         } else {
//           return false;
//           //alert("身份证号码错误！");
//         }
//       }
//     }
//   } else {
//     //alert("身份证格式不正确!");
//     return false;
//   }
// }

var regBox = {
  regEmail : /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/,//邮箱
  regName : /^[a-z0-9_-]{3,16}$/,//用户名
  regMobile : /^0?1[2|3|4|5|7|8][0-9]\d{8}$/,//手机
  regTel : /^0[\d]{2,3}-[\d]{7,8}$/,
  regIdNo : /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
};


