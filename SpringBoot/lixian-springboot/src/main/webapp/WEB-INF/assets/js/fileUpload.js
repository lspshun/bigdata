$(function () {
    $("#submit").click(function () {
        // 获取文件对象
        var file = $("input[type='file']")[0].files;
        if (file.length == 0) {
            alert("未选择上传文件");
            return;
        }
        // 序列化表单数据
        var formFieldData = $("#form").serialize();
        // 初始化FormData对象
        var formData = new FormData();
        // 将文件对象追加到FormData对象
        formData.append("file", file[0]);
        // Ajax方式提交
        $.ajax({
            // 在地址后直接拼接序列化后的表单数据
            url: basePath + "/upload?" + formFieldData,
            type: "POST",
            // 使用data属性发送文件数据
            data: formData,
            // 必填，关闭对data数据的序列化处理
            processData: false,
            // 必填，关闭Jquery对于contentType的操作
            contentType: false,
            success: function (data) {
                if (data == "success"){
                    alert("文件上传成功");
                    $("input[type='file']").val("");
                }
            }

        })
    });
});