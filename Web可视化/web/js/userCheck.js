$(function () {
    $("input[name='userName']").keyup(function () {
        // $(this)代表当前触发事件的元素
        var userName = $(this).val();
        // 向服务端发起Ajax请求
        $.ajax({
            // 请求路径
            url : basePath + '/UserCheckServlet',
            // 请求方式
            type : "post",
            // 发送数据
            data : {
                userName : userName
            },
            // 成功时的回调函数
            success : function (data) {
                var msg = $("span[name='msg']");
                if (data == "1"){
                    msg.html("恭喜!可以注册");
                    msg.css("color","green");
                }else {
                    msg.html("用户名已存在");
                    msg.css("color","red");
                }
            },
            // 服务端异常时的回调函数
            error : function (arg1, arg2, arg3) {

            }
        });
    })
});