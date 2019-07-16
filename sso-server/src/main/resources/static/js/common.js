//获取url上的请求参数
function getParams() {
    //获取问号及问号后面的内容
    var url = window.location.search;//?id=10&name=1
    var params = new Object();
    if (url.indexOf("?") != -1) {
        //截取问号后面的内容,再使用&分割多个属性
        var arr = url.substr(1).split("&");
        for (var i = 0; i < arr.length; i++) {
            //使用=分割为keyvalue
            var keyValue = arr[i].split("=");
            params[keyValue[0]] = keyValue[1];
        }
    }
    return params;
}

function showMessager(data){
    if(data.success){
        $.messager.confirm("温馨提示","操作成功!",function () {
            window.location.reload();
        })
    }else{
        $.messager.alert("错误信息",data.msg);
    }
}