<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%
    String path=request.getContextPath();
    String basePath=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8"/>
    <meta name="renderer" content="webkit|ie-comp|ie-stand"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>查询-快件查询-有装无到异常监控报表</title>
    <link rel="stylesheet" href="lib/sto/css/sto.css"/>
    <link rel="stylesheet" href="lib/sto/css/resume.css"/>
    <style type="text/css" rel="stylesheet">
        body {
            height: 100%;
            box-sizing: border-box;
        }
    </style>

</head>
<body class="pd-10 bg_white overflow_x_h">

<div class="">
    <div class=".topDiv"></div>

</div>

<script type="text/javascript" src="lib/jquery/jquery.js"></script>
<script type="text/javascript" src="lib/bootstrapTable/bootstrap-table.js"></script>
<script type="text/javascript" src="lib/bootstrapTable/bootstrap.min.js"></script>
<script type="text/javascript" src="lib/bootstrapTable/bootstrap-table-export.js"></script>
<script type="text/javascript" src="lib/bootstrapTable/tableExport.js"></script>
<script src="lib/bootstrapTable/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="lib/layerui/layui.js"></script>
<script type="text/javascript" src="lib/sto/sto.js"></script>
</body>
</html>