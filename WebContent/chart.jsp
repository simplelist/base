<%--
  Created by IntelliJ IDEA.
  User: jackshi
  Date: 16/3/23
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图表展示</title>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.min.css">
    <script type="text/javascript" src="/javascript/less.min.js"></script>
    <script type="text/javascript" src="/javascript/jquery-1.11.2.min.js" ></script>
    <script type="text/javascript" src="/javascript/bootstrap.min.js" ></script>
    <script type="text/javascript" src="/javascript/echarts/echarts.min.js" ></script>
    <script type="text/javascript" src="/javascript/echarts/theme/infographic.js" ></script>
</head>

<body style="margin: 0px; padding: 0px;">
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px; height: 400px;"></div>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'),'infographic');
    // 基于准备好的dom，初始化echarts实例

    myChart.setOption({
        series : [
            {
                name: '访问来源',
                type: 'pie',
                roseType: 'angle',
                radius: '55%',
                data:[
                    {value:400, name:'搜索引擎'},
                    {value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:274, name:'联盟广告'},
                    {value:235, name:'视频广告'}
                ]

            }
        ]
    })
    myChart.hideLoading();
</script>
</body>
</html>
