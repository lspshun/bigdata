$(function () {
   $("#show").click(function () {
       $.ajax({
           url : basePath + "/SalaryServlet",
           type : "post",
           dataType : "json",
           success : function (data) {
               var xAxisData = [];
               var seriesData = [];
               // for(in) -> 如果遍历的对象是数组 -> 每次取出的元素为数组下标
               // for(in) -> 如果遍历的对象是json -> 每次取出的元素为json中的key
               for (index in data){
                   console.log(index)
                   xAxisData.push(data[index].name);
                   seriesData.push(data[index].salary);
               }
               // Jquery对象转换为js对象
               var div = $("#main")[0];
               // 在初始化Echarts对象时必须使用js对象
               var myChart = echarts.init(div);
               option = {
                   color: ['#3398DB'],
                   tooltip : {
                       trigger: 'axis',
                       axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                           type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                       }
                   },
                   grid: {
                       left: '3%',
                       right: '4%',
                       bottom: '3%',
                       containLabel: true
                   },
                   xAxis : [
                       {
                           type : 'category',
                           data : xAxisData,
                           axisTick: {
                               alignWithLabel: true
                           }
                       }
                   ],
                   yAxis : [
                       {
                           type : 'value'
                       }
                   ],
                   series : [
                       {
                           name:'工资',
                           type:'bar',
                           barWidth: '60%',
                           data:seriesData
                       }
                   ]
               };
               myChart.setOption(option);
           }
       })
   }) 
});