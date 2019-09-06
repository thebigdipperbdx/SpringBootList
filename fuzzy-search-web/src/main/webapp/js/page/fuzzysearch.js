$(function () {
    //根据窗口调整表格高度
    setTableHeight();
    $("#search").click(function () {
        //判断日期
        var scanDayStart = $('#scanDayStart').val();
        var scanDayEnd = $('#scanDayEnd').val();
        if ($.trim(scanDayStart) == '') {
            layer.msg("请选择统计开始日期!");
            return;
        }
        if ($.trim(scanDayEnd) == '') {
            layer.msg("请选择统计结束日期!");
            return;
        }

        if (timeDiff(getTodayDate(), scanDayStart) < 0) {
            layer.msg("统计开始日期大于当前日期");
            return;
        }
        if (timeDiff(getTodayDate(), scanDayEnd) < 0) {
            layer.msg("统计结束日期大于当前日期");
            return;
        }
        if (timeDiff(scanDayEnd, scanDayStart) < 0) {
            layer.msg("统计开始日期大于统计结束日期");
            return;
        }
        if (dateDiff(getTodayDate(), scanDayEnd) < 3) {
            layer.msg("统计结束日期不能取最近的3天");
            return;
        }
        if (dateDiff(scanDayEnd, scanDayStart) >= 3) {
            layer.msg("日期范围不能超过3天");
            return;
        }
        $("#queryExpressCount").val('');
        $('#table').bootstrapTable('refresh', {url: 'carExpressQuery/queryData'});
    });

    $('body').on('click', '.bootstrap-table .fixed-table-container .pagination li a', function (e) {
        e.preventDefault();
    });

});


layui.use(['layer', 'form', 'layedit', 'laydate', 'test', 'autocomplete', 'element'], function () {
    var form = layui.form()
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        , test = layui.test
        , autocomplete = layui.autocomplete
        , element = layui.element()
        , clipboard = layui.clipboard;
    layedits = layui.layedit;
    test.restVal();


    //发件网点
    $("#fuzzySearch").on("input propertychange", function () {
        var sendData = {id: $(this).val()};
        $.ajax({
            url: '/fuzzySearch/getText',
            type: 'post',
            dataType: 'json',
            contentType: "application/json",
            async: true,//异步请求
            cache: false,
            data: JSON.stringify(sendData),//使用变量sendData
            //执行成功的回调函数
            success: function (data) {
                console.log(data.rows)
                $("#searchText").text("");
                $("#searchText").text(data.rows);
            },
            //执行失败或错误的回调函数
            error: function (data) {
                alert("查找失败");
            }
        });

    })

});

