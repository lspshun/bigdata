$(function () {
    var div = $("#main")[0];
    var myChart = echarts.init(div);
    var innerData = [];
    var outerData = [];
    var legendData = [];
    $.ajax({
        url: basePath + "/CarServlet",
        type: "post",
        async: false,
        dataType: "json",
        success: function (data) {
            var innerJsonObject = data.innerData;
            for (key in innerJsonObject) {
                innerData.push({
                    name: key,
                    value: innerJsonObject[key]
                })
                legendData.push(key);
            }
            var outerJsonArray = data.outerData;
            for (index in outerJsonArray) {
                var jsonData = outerJsonArray[index];
                var name = "";
                var value = 0;
                for (key in jsonData) {
                    name = key;
                    value = jsonData[key];
                    legendData.push(key);
                }
                outerData.push({
                    name: name,
                    value: value
                })
            }
            console.log(innerData);
            console.log(outerData);
            console.log(legendData);
        }
    });
    var option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data: legendData
        },
        series: [
            {
                name: '访问来源-一级',
                type: 'pie',
                selectedMode: 'single',
                radius: [0, '30%'],

                label: {
                    normal: {
                        position: 'inner'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: innerData
            },
            {
                name: '品牌销量',
                type: 'pie',
                radius: ['40%', '60%'],
                label: {
                    normal: {
                        show : false
                    }
                },
                data: outerData
            }
        ]
    };
    myChart.setOption(option);
});