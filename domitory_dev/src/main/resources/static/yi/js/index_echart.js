        var dom = document.getElementById("mychart");
var myChart = echarts.init(dom);
var app = {};

var option;
option = {
    title: {
        text: '学院人数统计',
        subtext: '',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c} ({d}%)'
    },
    legend: {
        bottom: 10,
        left: 'center',
        data: []
    },
    series: [
        {
            type: 'pie',
            radius: '63%',
            center: ['50%', '50%'],
            selectedMode: 'single',
            data: [
                
                {value: 65, name: '电子信息学院'},
                {value: 49, name: '艺术学院'},
                {value: 34, name: '管理学院'},
                {value: 44, name: '国际商学院'},
                {value: 115, name: '计算机科学院'}
            ],
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};

if (option && typeof option === 'object') {
    myChart.setOption(option);
}





var dom1 = document.getElementById("mychart1");
var myChart1 = echarts.init(dom1);
var app1 = {};

var option1;
option1 = {
    title: {
        subtext: '一周内维修情况',
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {
        data: ['待维修宿舍', '已维修宿舍']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
         data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    series: [
        {
            name: '待维修宿舍',
            type: 'bar',
            data: [3, 2, 4, 8, 9, 6,2]
        },
        {
            name: '已维修宿舍',
            type: 'bar',
            data: [1, 2, 3, 5, 7, 6,1]
        }
    ]
};
if (option1 && typeof option1 === 'object') {
    myChart1.setOption(option1);
}


var dom2 = document.getElementById("mychart2");
var myChart2 = echarts.init(dom2);
var app2 = {};

var option2;
option2 = {title: {
       subtext: '宿舍入住和就寝情况'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['入住人数', '空余床位','缺寝人数']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
    },
    yAxis: {
        type: 'value'
    },
    series: [ 
        {
            name: '缺寝人数',
            type: 'line',
            stack: '总量',
           data: [0, 5, 8, 13, 2, 3, 10,2, 7, 12, 3, 9]
        },
        {
            name: '空余床位',
            type: 'line',
            stack: '总量',
           data: [22, 18, 11, 23, 29, 33, 30,22, 18, 11, 23, 29]
        },

        {
            name: '入住人数',
            type: 'line',
            stack: '总量',
            
             data: [312, 338, 310, 320, 308, 310,330, 311,318, 320, 330, 310]
        }]
};
if (option2 && typeof option2 === 'object') {
    myChart2.setOption(option2);
}
