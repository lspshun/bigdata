$(function () {
    // 定义全局变量 - 用户输入的表名
    var tableName = "";
    // 定义全局变量 - 准备接收服务端发送回来的表结构信息
    var tableColumn = "";
    // 定义全局变量 - 准备接收服务端发送回来的表数据
    var tableData = "";
    // 定义全局变量 - 用户选择的图表类型
    var type = "";
    // 定义全局变量 - 根据图表类型更改数据维度描述信息
    var xDesc = "";
    // 定义全局变量 - 根据图表类型更改数据维度描述信息
    var yDesc = "";
    // 定义全局变量 - 用于标识多个纵轴的维度
    var length = 0;
    // 初始化柱形图/折线图的Echarts实例
    var div1 = $("#main");
    var myChart1 = echarts.init(div1[0]);
    // 初始化饼图的Echarts实例
    var div2 = $("#pie");
    var myChart2 = echarts.init(div2[0]);
    $.ajax({
        url : basePath + "/GetDataInfoServlet",
        type : "post",
        async : false,
        data : {
            method : "getDatabase"
        },
        dataType : "json",
        success : function (data) {
            var dataInfo = $("#dataInfo");
            var database = $("<select id='database'></select>");
            database.append("<option value='-1'>请选择</option>")
            for (index in data){
                database.append("<option value='" + data[index] + "'>" + data[index] + "</option>");
            }
            dataInfo.append(database);
            // database.appendTo(dataInfo);
        }
    });
    $("#dataInfo").on("change","#database",function () {
        var databaseName = $(this).val();
        if (databaseName == "-1"){
            return;
        }
        $.ajax({
            url : basePath + "/GetDataInfoServlet",
            type : "post",
            async : false,
            data : {
                method : "getTable",
                databaseName : databaseName
            },
            dataType : "json",
            success : function (data) {
                var dataInfo = $("#dataInfo");
                if ($("#table").length > 0){
                    $("#table").remove();
                }
                var dataTable = $("<select id='table'></select>");
                dataTable.append("<option value='-1'>请选择</option>")
                for (index in data){
                    dataTable.append("<option value='" + data[index] + "'>" + data[index] + "</option>");
                }
                dataInfo.append(dataTable);
            }
        });
    });
    // [按钮]构建图表的点击事件
    $("input[value='构建图表']").click(function () {
        // 获得用户输入的表名称
        // tableName = $("input[name='tableName']").val();
        var databaseName = $("#database").val();
        tableName = $("#table").val();
        // 向服务端发送请求，获得表结构信息
        $.ajax({
            url: basePath + "/TableServlet",
            type: "post",
            data: {
                tableName: databaseName + "." + tableName,
                method: "getTableInfo"
            },
            dataType: "json",
            success: function (data) {
                // 当用户输入的表名称发生变化时，清空上一次查询出的数据
                tableData = "";
                // 将返回的结构信息记录在全局变量中
                tableColumn = data;
                // 获取页面上的div - 用户后续用户的选择操作
                var tableInfo = $("#tableInfo");
                // 清空原有内容
                tableInfo.html("");
                // 构建一个图表类型选择的下拉菜单
                var type = $("<select id='type'></select>");
                // 当用户未选择图表类型时，需要定义一个标识信息，进行清空
                type.append("<option value='-1'>请选择</option>");
                type.append("<option value='bar'>柱形图</option>");
                type.append("<option value='line'>折线图</option>");
                type.append("<option value='pie'>饼形图</option>");
                tableInfo.append("<br /><br />");
                tableInfo.append("<span>图表类型：</span>");
                // 将下拉菜单添加到页面上
                tableInfo.append(type);
            }
        })
    });
    // [下拉菜单]图表类型选择change事件
    $("#tableInfo").on("change", "#type", function () {
        // 获得用户选择的图表类型
        type = $(this).val();
        // 尝试获得页面上的columns元素
        var div = $("#columns");
        // 清空之前的内容
        if (div.length != 0) {
            div.remove();
        }
        // 如果用户切换至未选择选项，不再执行添加操作
        if (type == "-1") {
            return;
        }
        var tableInfo = $("#tableInfo");
        div = $("<div id='columns'></div>");
        // 根据图表类型显示描述信息
        if (type != "pie") {
            xDesc = "x轴：";
            yDesc = "y轴：";
        } else {
            xDesc = "描述：";
            yDesc = "数据：";
        }
        // 创建两个维度的下拉菜单
        var x = $("<select id='x'></select>");
        var y = $("<select id='y' class='y'></select>");
        // 从表结构信息中选择列的名称，填充到select中
        for (key in tableColumn) {
            x.append("<option value='" + key + "'>" + key + "</option>");
            y.append("<option value='" + key + "'>" + key + "</option>");
        }
        div.append("<br /><br />");
        div.append("<span>" + xDesc + "</span>");
        div.append(x);
        div.append("<br /><br />");
        // 定义一个div，在其中操作纵轴的数据维度
        var yDiv = $("<div id='yColumn'>");
        yDiv.append("<span>" + yDesc + "</span>");
        yDiv.append(y);
        yDiv.append("&nbsp;&nbsp;<input class='add' type='button' value='+' />");
        div.append(yDiv);
        div.append("<br /><br />");
        div.append("<input type='button' value='生成图表' />");
        tableInfo.append(div);
    });
    // [按钮]+号的点击事件
    $("#tableInfo").on("click", ".add", function () {
        var yColumn = $("#yColumn");
        // 每次添加时标识自增
        length++;
        // 定义一个新的select
        var addY = $("<select class='y y-" + length + "'></select>");
        // 从已有的select中拷贝
        addY.html($("#y").html());
        // 向指定区域中添加
        yColumn.append("<br  class='y-" + length + "' /><br  class='y-" + length + "'/>");
        yColumn.append("<span class='y-" + length + "'>" + yDesc + "</span>");
        yColumn.append(addY);
        yColumn.append("&nbsp;&nbsp;<input class='y-" + length + "' name='delete' type='button' value='-' />");
    });
    // [按钮]-号的点击事件
    $("#tableInfo").on("click", "input[name='delete']", function () {
        // 根据class属性删除移除元素
        var className = $(this).attr("class");
        $("." + className).remove();
    });
    // $(parent).on("event","child",function())
    // [按钮]生成图表点击事件
    $("#tableInfo").on("click", "input[value='生成图表']", function () {
        // 获得用户给出的数据维度及图表类型的信息
        var x = $("#x").val();
        var y = $(".y");// 选择器返回的是数组类型，数组中的元素为匹配到的元素
        var yColumn = [];
        for (var i = 0; i < y.length; i++) {
            yColumn.push(y.eq(i).val());
        }
        if (type != "pie") {
            div2.hide();
            div1.show();
            // 使用相应的方式构建数据
            var xAxisData = [];
            var series = [];
            // 如果还未执行过数据查询，则向服务端发送请求，带回数据
            /*if (tableData == ""){
                $.ajax({
                    url : basePath + "/TableServlet",
                    type : "post",
                    async : false,
                    data : {
                        tableName : tableName,
                        method : "getTableDataByArray"
                    },
                    dataType : "json",
                    success : function (data) {
                        tableData = data;
                    }
                });
            }
            xAxisData = tableData[x];
            seriesData = tableData[y];
            for (index in seriesData){
                seriesData[index] = parseFloat(seriesData[index]);
            }*/
            var databaseName = $("#database").val();
            if (tableData == "") {
                $.ajax({
                    url: basePath + "/TableServlet",
                    type: "post",
                    // 关闭异步 -> 同步
                    async: false,
                    data: {
                        tableName: databaseName + "." + tableName,
                        method: "getTableDataByJson"
                    },
                    dataType: "json",
                    success: function (data) {
                        tableData = data;
                    }
                });
            }
            // 如果数据已经查询，当目标表无变化时，可以直接从已有的数据中提取出所需要的维度
            // 构建x轴数据
            for (index in tableData) {
                xAxisData.push(tableData[index][x]);
            }
            // 构建y轴的多维度数据
            var series = [];
            // 定义颜色数组
            var color = [];
            // yColumn代表需要取出的y轴上的维度
            // 每个维度需要提取出相应的数据
            for (index2 in yColumn) {
                var seriesData = [];
                for (index1 in tableData) {
                    // 内层循环结束后，即构建完成了一个维度的数据
                    seriesData.push(parseFloat(tableData[index1][yColumn[index2]]));
                }
                // 将该维度的数据放置在series中
                series.push({
                    name: yColumn[index2],
                    type: type,
                    barWidth: '10%',
                    data: seriesData
                });
                // 得到一个随机的颜色
                color.push(getRandomColor());
            }
            var option = {
                color: color,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        data: xAxisData,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: series
            };
            myChart1.setOption(option);
        } else {
            div1.hide();
            div2.show();
            var legendData = [];
            var seriesData = [];
            var databaseName = $("#database").val();
            if (tableData == "") {
                $.ajax({
                    url: basePath + "/TableServlet",
                    type: "post",
                    // 关闭异步 -> 同步
                    async: false,
                    data: {
                        tableName: databaseName + "." + tableName,
                        method: "getTableDataByJson"
                    },
                    dataType: "json",
                    success: function (data) {
                        tableData = data;
                    }
                });
            }
            // 如果数据已经查询，当目标表无变化时，可以直接从已有的数据中提取出所需要的维度
            for (index in tableData) {
                legendData.push(tableData[index][x]);
                seriesData.push({
                    value: parseFloat(tableData[index][y]),
                    name: tableData[index][x]
                });
            }
            var pieOption = {
                title: {
                    text: '教师工资对比',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: legendData
                },
                series: [
                    {
                        // 系列名称
                        name: '工资对比',
                        type: 'pie',
                        radius: '60%',
                        data: seriesData,
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
            myChart2.setOption(pieOption);
        }
    });
});

function getRandomColor() {
    return '#' + (function (h) {
        return new Array(7 - h.length).join("0") + h
    })((Math.random() * 0x1000000 << 0).toString(16))
}