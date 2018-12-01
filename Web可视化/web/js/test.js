$(function () {
    $("#show").click(function () {
        $.ajax({
            url : basePath + "/BarServlet",
            type : "post",
            // 对于服务端返回的数据的解析方式
            dataType : "json",
            success : function (data) {
                // Jquery对象转换为js对象
                var div = $("#main")[0];
                // 在初始化Echarts对象时必须使用js对象
                var myChart = echarts.init(div);
                var option = {
                    // 图表主标题
                    title: {
                        text: '柱形图'
                    },
                    // 鼠标滑上时显示的效果
                    tooltip: {},
                    // 图例
                    legend: {
                        // 数组中存放系列的名称
                        data:['销量']
                    },
                    // x轴相关的配置
                    xAxis: {
                        // x轴数据
                        data: data.xData
                    },
                    // y轴相关数据
                    yAxis: {},
                    // 图表系列
                    series: [
                        // 每组数据单独配置
                        {
                            // 系列名称
                            name: '销量',
                            // 图表类型
                            type: 'bar',
                            // y轴数据
                            data: data.sData
                        }
                    ]
                };
                myChart.setOption(option);
            }
        })
    });
});