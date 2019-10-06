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
    <style type="text/css" rel="stylesheet">
        body {
            height: 100%;
            box-sizing: border-box;
        }
    </style>

</head>
<body class="pd-10 bg_white overflow_x_h">

<div class="page_head">
    <span class="page_title">查询 > 模糊查询</span>
    <div class="layui-btn-group f-r mr-15">
        <button class="layui-btn layui-btn-primary layui-btn-small btnName" id="search" style="margin-top:5px;"><i
                class="iconfont icon-search"></i> 查询
        </button>
        <button class="layui-btn layui-btn-primary layui-btn-small btnName" id="downLoad" style="margin-top:5px;"><i
                class="iconfont icon-add"></i> 导出
        </button>
        <button class="layui-btn layui-btn-primary layui-btn-small btnName" id="downLoadCenter" style="margin-top:5px;">
            <i class="iconfont icon-add"></i> 下载中心
        </button>
    </div>
</div>
<div class="main_b mt-40 animated fadeInRight overflow_x_h">
    <div id="ibox" class="ibox mb-10">
        <div class="ibox_form" id="form">
            <form class="layui-form pl-20 pb-20 pt-10" action="" id="queryform" method="POST">

                <div class="layui-form-item layui-form-pane">


                    <div class="layui-inline">
                        <label class="layui-form-label width_90 f-12">模糊搜索</label>
                        <div class="layui-input-inline">
                            <input type="text" autocomplete="off" class="layui-input" id="fuzzySearch"
                                   name="fuzzySearch">
                        </div>
                    </div>

                </div>


            </form>
        </div>
    </div>
    <div id="iText" class="ibox mb-10">
        <div id="searchText"></div>
    </div>
</div>
<script type="text/javascript" src="lib/jquery/jquery.js"></script>
<script type="text/javascript" src="lib/bootstrapTable/bootstrap-table.js"></script>
<script type="text/javascript" src="lib/bootstrapTable/bootstrap.min.js"></script>
<script type="text/javascript" src="lib/bootstrapTable/bootstrap-table-export.js"></script>
<script type="text/javascript" src="lib/bootstrapTable/tableExport.js"></script>
<script src="lib/bootstrapTable/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="lib/layerui/layui.js"></script>
<script type="text/javascript" src="lib/sto/sto.js"></script>
<script type="text/javascript" src="js/page/fuzzysearch.js?version=${timestamp }"></script>
</body>
</html>