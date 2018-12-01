$(function () {
    $("#testConnection").click(function () {
        var formData = $("#database").serialize();
        $.ajax({
            url: basePath + "/getDatabaseList?" + formData,
            type: "post",
            dataType: "json",
            success: function (data) {
                // 通过已有的数据生成select标签
                var select = $("<select id='databases'><option value='-1'>请选择</option></select>");
                for (index in data) {
                    select.append("<option value='" + data[index] + "'>" + data[index] + "</option>");
                }
                $("#databaseSelect").html("");
                $("#dataTableSelect").html("");
                $("#databaseSelect").append(select);
            }
        });
    });
    /* 数据库列表的select - 用户选择数据元(数据库)时触发的操作 - 根据数据库名称查询对应的数据元下的所有数据表 */
    $("#databaseSelect").on("change", "#databases", function () {
        var databaseName = $(this).val();
        var formData = $("#database").serialize();
        $.ajax({
            url: basePath + "/getDataTableList?" + formData + "&databaseName=" + databaseName,
            type: "post",
            dataType: "json",
            success: function (data) {
                var select = $("<select id='dataTables'><option value='-1'>请选择</option></select>");
                for (index in data) {
                    select.append("<option value='" + data[index] + "'>" + data[index] + "</option>");
                }
                $("#dataTableSelect").html("");
                $("#dataTableSelect").append(select);
            }
        });
    });
    /* 数据表列表的select - 用户选择数据表后添加一个导入数据的按钮 */
    $("#dataTableSelect").on("change", "#dataTables", function () {
        var submit = $("<input id='import' type='button' value='导入数据' />");
        $("#button").html("");
        $("#button").append(submit);
    });
    $("#button").on("click", "#import", function () {
        var formData = $("#database").serialize();
        var databaseName = $("#databases").val();
        var dataTableName = $("#dataTables").val();
        var sourceName = $("#sourceName").val();
        var groupId = $("#groupId").val();
        console.log(dataTableName);
        $.ajax({
            url: basePath + "/importFromRDBMS?" + formData + "&databaseName=" + databaseName + "&dataTableName=" + dataTableName + "&sourceName=" + sourceName + "&groupId=" + groupId,
            type: "post",
            dataType: "text",
            success: function (data) {
                if (data == "success"){
                    alert("导入成功")
                }
            }
        });
    })
});