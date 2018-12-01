$(function () {
    $("#sourceSelect").change(function () {
        var sourceType = $(this).val();
        $.ajax({
            url: basePath + "/getHiveSource",
            type: "post",
            data: {
                sourceType: sourceType
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
                var select = $("#hiveSource");
                select.html("");
                select.append("<option value='-1'>请选择</option>");
                for (index in data) {
                    select.append("<option data-column='" + data[index].hive_column + "' value='" + data[index].hive_table + "'>" + data[index].source_name + "</option>");
                }
            }
        })
    });
    $("#showColumn").click(function () {
        // select下拉菜单当前被选中的元素 -> jquery对象
        var option = $("#hiveSource").find("option:selected");
        // 取出option元素的data-column属性 -> 字符串
        var columns = option.data("column");
        var array = columns.split(",");
        var tableColumn = $("#tableColumn");
        tableColumn.html("");
        for (index in array) {
            var column = array[index];
            tableColumn.append(column + "<br \><br >");
        }
    });
    $("#showData").click(function () {
        var tableName = $("#hiveSource").val();
        $.ajax({
            url: basePath + "/getHiveTableData",
            type: "post",
            data: {
                tableName: tableName
            },
            dataType: "json",
            success: function (data) {
                var tableData = $("#tableData");
                tableData.html("");
                for (index in data) {
                    tableData.append(data[index] + "<br />");
                }
            }
        })
    });
    $("#submit").click(function () {
        var formData = $("#dataFlowForm").serialize();
        var tableName = $("#hiveSource").val();
        $.ajax({
            url: basePath + "/createHiveDataFlow?" + formData + "&tableName=" + tableName,
            type: "post",
            dataType : "text",
            success: function (data) {
                if (data == "success"){
                    alert("新建成功");
                }
            }
        })
    })
});