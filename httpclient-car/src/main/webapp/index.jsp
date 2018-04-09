<%--
  Created by IntelliJ IDEA.
  User: ch
  Date: 2018/4/7
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript"  src="<%=request.getContextPath() %>/jquery/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/icon.css">
    <%-- <script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery-1.7.2.min.js"></script>  --%>
    <script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/easyui/util-js.js"></script>
</head>
<body>



<div id="cc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',split:true" style="height: 100px;">

        <h1>金科日志管理系统</h1>

    </div>

    <div data-options="region:'west',title:'菜单',split:true"style="width: 200px;">

        <div id="tree"></div>

    </div>
    <div data-options="region:'center'" style="padding: 5px; background: #eee;">

        <div id="tabs" class="easyui-tabs" data-options="fit:true"></div>

    </div>
</div>

<script type="text/javascript">
    $('#tree').tree({
        data : [ {
            "text" : "日志管理",
            "state" : "open",
            "children" : [ {
                "text" : "日志展示",
                "url" : "listRiZhi.jsp",
                "state" : "open",
            }]

        }

        ],
        onClick : function(node) {

            //alert(node.url)

            //获取title为node.text 的选项卡

            var tabsObj = $("#tabs").tabs("getTab", node.text);

            if (tabsObj == null) {

                $('#tabs').tabs('add', {
                    title : node.text,
                    href : '<%=request.getContextPath() %>/'+node.url,
                    closable:true,
                    tools:[{
                        iconCls:'icon-mini-refresh',
                        handler:function(){
                            alert('刷新');
                        }
                    }]
                });

            }else{

                $("#tabs").tabs("select",node.text);

            }

        }

    });






</script>
</body>
<style>

    .tubiao{ width:25px; height:25px; float:left; cursor:pointer; margin-right:10px; margin-left:10px;}
    .tubiao:hover
    {
        opacity: 1;
        filter: alpha(opacity=100);
        background-color: #000000;
        -moz-border-radius: 3px 3px 3px 3px;
        -webkit-border-radius: 3px 3px 3px 3px;
        border-radius: 3px 3px 3px 3px;
    }
</style>
</html>