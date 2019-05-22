<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <style>
        .table1 {
            width: 90%;
            margin-left: 5%;
            margin-top: 10px;
            margin-bottom: 50px;
        }
        
        .table1 td {
            border: 1px solid #ccc;
        }
        
        .table2 {
            width: 100%;
        }
        
        .table2 .layui-bg-orange {
            width: 25%;
        }
        
        .table2 td {
            border: 1px solid #ccc;
        }
        
        .table3 .layui-card {
            height: 250px;
            background-color: #ccc;
        }
        
        .table3 td {
            width: 30%;
            margin-left: 20px;
            border-bottom: 10px solid #fff;
            border-left: 10px solid #fff;
        }
        
        .float {
            float: right;
        }
        
        .headphoto {
            border-radius: 50px;
            width: 50px;
            height: 50px;
            margin: 10px 0;
        }
        
        .authorphoto {
            border-radius: 50px;
            width: 25px;
            height: 25px;
        }
        
        .recommend .layui-card-header {
            font-size: 26px;
            color: chocolate;
        }
    </style>
    <title>Insert title here</title>
</head>

<body>
    <div class="layui-container">
        <div class="layui-row layui-col-space15">
            <div class="">
                <div class="layui-card">
                    <div class="layui-card-header">
                        文章信息 <button class="layui-btn layui-bg-blue float layui-btn-sm">修改文章信息</button>
                    </div>
                    <div class="layui-card-body">
                        <table class="table2">
                            <tr>
                                <td class="layui-bg-orange">文章主标题</td>
                                <td>2019-1-1 12:12:12</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="layui-card">
                    <div class="layui-card-header">
                        文章内容管理
                        <a href="#">
                    </div>
                    <div class="layui-card-body">
                        <table id="demo" lay-filter="test" width="100%"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use(['element', 'carousel', 'table'], function() {
        var element = layui.element;
        var carousel = layui.carousel;
        //导航栏点击
        element.on('nav(filter)', function(elem) {
            console.log(elem); //得到当前点击的DOM对象
        });
        var table = layui.table;
        table.render({
            elem: '#demo',
            height: 500,
            url: 'service/getcontent.action', //数据接口
            cols: [
                [ //表头
                    {
                        field: 'ordernum',
                        title: '内容序号',
                        width: 40,
                    }, {
                        field: '',
                        title: '文章图片',
                        width: 80,
                        templet: function(data) {
                            return "<img src='" + data.photoname + "' style='width:100%'/>"
                        }
                    }, {
                        field: 'textcontent',
                        title: '文章内容',
                        width: 300,
                        sort: true
                    }, {
                        fixed: 'right',
                        title: '操作',
                        width: 140,
                        toolbar: '#barDemo'
                    }
                ]
            ],
            page: true, //开启分页
            even: true, //每行颜色分隔
            skin: 'nob', //无边框
            limit: 10,
            limits: [5, 10, 15]
                /* first:true,
                last:true, */
        });
        //监听工具条
        table.on('tool(demo)', function(obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function(index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });
    });
</script>

</html>