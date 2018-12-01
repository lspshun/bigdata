$(function () {
    var div = $("#main")[0];
    var myCharts = echarts.init(div);
    var legendData = [];
    var seriesData = [];
    $.ajax({
        url: basePath + "/SalaryServlet",
        type: "post",
        dataType: "json",
        async: false,
        success : function (data) {
            for (index in data){
                legendData.push(data[index].name);
                seriesData.push({
                    value : data[index].salary,
                    name : data[index].name
                });
            }
        }
    });
    var option = {
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
    myCharts.setOption(option);
});