//报警类型

var predefinedColors = [
    '#426cb4', '#6780c0', '#abb4dd', '#d1d6ec',
];
var legendArray=[]
//
alarmTypeOption = {
    tooltip: {
            trigger: 'item',
            formatter: '{b} : {c}'
        },
    legend: {
        orient: 'vertical',
        left: 'left',
        textStyle: {
            fontSize: 14,
            color: "#FFFFFF",
        },
        data: ["报警", "未连接", "子设备报警"]
    },
    textStyle: {
        fontSize: 14,
        color: "#FFFFFF"
    },
    series: [
        {
            type: 'pie',
            radius: '60%',
            center: ['70%', '50%'],
            data: [],
            itemStyle:{
                normal:{
                    color:function (param) {
                        var colorList=['#333333','#FFCC00','#FF3333']
                        return colorList[param.dataIndex]
                    }
                }
            },
            label: {
                normal: {
                    position: 'outside',
                    show: false //指示线
                }
            },
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
// 设备报警
deviceTypeOption = {
    tooltip: {
        trigger: 'item',
        formatter: '{b} : {c}'
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        textStyle: {
            fontSize: 14,
            color: "#FFFFFF",
        },
        data: []
    },
    textStyle: {
        fontSize: 14,
        fontcolor: "#FFFFFF"
    },

    series: [
        {
            type: 'pie',
            radius: '50%',
            center: ['70%', '50%'],
            data: [],
            label: {
                normal: {
                    position: 'outside',
                    show: false
                }
            },
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(10, 234,10,234)'
                }
            }
        }
    ]
};
//预测
guestOption = {
    title:{
      text:'',
      left:'center',
      textStyle:{
          fontFamily:'SimHei',
          color:'#FF7F00',
          fontSize:'14'
      }
    },
    tooltip: {
        trigger: 'axis'
    },
    legend:{
        data:[]
    },
    xAxis: [{
        type: 'category',
        boundaryGap: false,
        data: [],
        axisLabel: {
            textStyle: {
                color: '#CFB53B',//坐标值得具体的颜色
                fontSize: 13
            }
        },
        axisLine: {
            lineStyle: {
                type: 'solid',
                color: '#fff',//左边线的颜色
                width: '2',//坐标线的宽度
                fontSize: 15
            }
        }
    }],
    yAxis: [{
        type: 'value',
        scale: true,
        splitLine: {
            show: false
        },
        axisLabel: {
            textStyle: {
                color: '#3299CC',//坐标值得具体的颜色
                fontSize: 16
            },

        },
        axisLine: {
            lineStyle: {
                type: 'solid',
                color: '#fff',//左边线的颜色
                width: '2',//坐标线的宽度
                fontSize: 14
            }
        }
    }],
    grid: {
        x: 60,
        y2: 40,
        y: 60,
        x2:40
    },
    series: [{
        name: '报警预测',
        type: 'line',
        smooth: true,
        data: [],
    }]
};
//柱状图
alarmCountOption = {
    color: ['#FF0000'],
    tooltip: {
        trigger: 'axis',
        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
        grid:{
        x:40,
        y2:40,
        y:40
    },
    xAxis: [
        {
            type: 'category',
            data: [],
            axisTick: {
                alignWithLabel: true
            },
            axisLabel: {
                textStyle: {
                    color: '#CFB53B',//坐标值得具体的颜色
                    fontSize: 14
                }
            },
            axisLine: {
                lineStyle: {
                    type: 'solid',
                    color: '#D8D8BF',//左边线的颜色
                    width: '2',//坐标线的宽度
                    fontSize: 16
                }
            }
        },


    ],
    yAxis: [
        {
            type: 'value',
            axisLabel: {
                textStyle: {
                    color: '#3299CC',//坐标值得具体的颜色
                    fontSize: 16
                }
            },
            axisLine: {
                lineStyle: {
                    type: 'solid',
                    color: '#D8D8BF',//左边线的颜色
                    width: '2',//坐标线的宽度
                    fontSize: 16
                }
            }
        }
    ],
    series: [
        {
            name: '报警数量',
            type: 'bar',
            barWidth: '60%',
            data: []
        }
    ]
};

//折线图
// alarmCountOption = {
//     tooltip: {
//         trigger: 'axis'
//     },
//     xAxis: [{
//         name: 'h',
//         type: 'category',
//         boundaryGap: true,
//         data: [],
//         axisLabel: {
//             textStyle: {
//                 color: '#fff',//坐标值得具体的颜色
//                 fontSize: 12
//             }
//         },
//         axisLine: {
//             lineStyle: {
//                 type: 'solid',
//                 color: '#fff',//左边线的颜色
//                 width: '2',//坐标线的宽度
//                 fontSize: 15
//             }
//         }
//     }],
//     yAxis: [{
//         name: 'quantity',
//         type: 'value',
//         scale: true,
//         splitLine: {
//             show:true
//         },
//         axisLabel: {
//             textStyle: {
//                 color: '#fff',//坐标值得具体的颜色
//                 fontSize: 12
//             },
//
//         },
//         axisLine: {
//             lineStyle: {
//                 type: 'solid',
//                 color: '#fff',//左边线的颜色
//                 width: '2',//坐标线的宽度
//                 fontSize: 15
//             }
//         }
//     }],
//     grid:{
//         x:40,
//         y2:80,
//         y:40
//     },
//     series: [{
//         name: '',
//         type: 'line',
//         smooth: true,
//         data:[]
//     }]
// };


//地图
