// 获得网页中的div -> dom对象
var div = document.getElementById("main");
// 转换成echarts对象 - 参数只能是js对象
var myChart = echarts.init(div);
// 通过option设置图表配置
var option = {
    // 图表主标题
    title: {
        text: 'ECharts 入门示例'
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
        data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
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
            data: [5, 20, 36, 10, 10, 20]
        }
    ]
};
// 将option放入Echarts对象中
myChart.setOption(option);