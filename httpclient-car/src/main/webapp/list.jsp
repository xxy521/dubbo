<%--
  Created by IntelliJ IDEA.
  User: ch
  Date: 2018/4/7
  Time: 8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="boot.jsp"flush="true"></jsp:include>
    <script type="text/javascript"  src="<%=request.getContextPath() %>/jquery/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/icon.css">
    <%-- <script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery-1.7.2.min.js"></script>  --%>
    <script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="<%=request.getContextPath() %>/easyui/locale/easyui-lang-zh_CN.js"></script>
    <link    href="<%=request.getContextPath() %>/artDialog-master/css/dialog.css"  />
    <script type="text/javascript"  src="<%=request.getContextPath() %>/artDialog-master/dist/dialog.js"></script>

</head>
<body>
<%--工具栏--%>
<div id="tabToolBar">
    <div class="btn-group">
        <button type="button"  class="btn btn-success"  data-toggle="modal" data-target="#myModal" >
            <span class="glyphicon glyphicon-plane">新增</span>
        </button>
    </div>
</div>
<!--新增页面  -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form id="ff" >
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="form-signin-heading">新增</h4>
                </div>
                <div class="input-group">
                    <table   border=1>
                        <tr>
                            <td>日志类型</td>
                            <td>
                                <select id="rtype">
                                    <option value="">--请选择--</option>
                                    <option value="操作日志">操作日志</option>
                                    <option value="系统日志">系统日志</option>
                                    <option value="未知日志">未知日志</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>日志时间</td>
                            <td>
                                <select id="rtime">
                                    <option value="">--请选择--</option>
                                    <option value="2016">2016</option>
                                    <option value="2017">2017</option>
                                    <option value="2018">2018</option>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>日志名称</td>
                            <td>
                                <input type="text" id="rname"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="button" value="新增" onclick="addRiZhi()"/>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>
    </div>
</div>

<!--修改页面  -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form  id="ff2">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="form-signin-heading">修改区域信息</h4>
                </div>
                <table   border=1>
                    <tr>
                        <td>
                            <input type="hidden" id="rid"/>
                        </td>
                    </tr>
                    <tr>
                        <td>日志类型</td>
                        <td>
                            <select id="rtype1">
                                <option value="">--请选择--</option>
                                <option value="操作日志">操作日志</option>
                                <option value="系统日志">系统日志</option>
                                <option value="未知日志">未知日志</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>日志时间</td>
                        <td>
                            <select id="rtime1">
                                <option value="">--请选择--</option>
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>日志名称</td>
                        <td>
                            <input type="text" id="rname1"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="button" value="修改" onclick="updateRiZhi()"/>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>

<table id="btable"></table>
<script type="text/javascript">
/* ==================================================
================查询+分页============================== */
$(function (){
    $('#btable').datagrid({
        url:'<%=request.getContextPath()%>/rizhi/queryrizhi',
        columns:[[
            {field:'rid',title:'编号',width:'15%',align:'center'},
            {field:'rtype',title:'日志类型',width:'15%',align:'center'},
            {field:'rname',title:'日志名称',width:'10%',align:'center'},
            {field:'rtime',title:'日志时间',width:'10%',align:'center'},
            {field:'caozuo',title:'操作',width:100,align:'center',

                formatter : function (val,row,index){
                    return "<a href='javascript:huiRiZhi()' class='tubiao icon-edit'></a><a href='javascript:deleteRiZhi("+row.rid+")'  class='tubiao icon-remove'></a>";
                }
            },

        ]],
        pagination:false,
        pageNumber:1,
        pageSize:3,
        pageList:[3,4,5],
        singleSelect:false,
        checkOnSelect:false,
    });
                })

function deleteRiZhi(rid){


    $.ajax({
        url:"<%=request.getContextPath()%>/rizhi/deleterizhi",
        type:"post",
        data:{"rid":rid},
        success:function(result){
            if (result) {

                alert("删除成功")

                $("#hotel").datagrid("reload");
            }
        }
    })


}


function addRiZhi(){

    $.ajax({
        url:"<%=request.getContextPath()%>/rizhi/addrizhi",
        type:"post",
        data:{"rtype":$("#rtype").val(),"rtime":$("#rtime").val(),"rname":$("#rname").val()},
        success:function(result){
            if (result) {
                alert("新增成功")
                $("#hotel").datagrid("reload");
            }
        }
    })

}

function huiRiZhi() {
    var aa = $("#hotel").datagrid("getSelected")

    $("#rtype1").val(aa.rtype);
    $("#rname1").val(aa.rname);
    $("#rtime1").val(aa.rtime);
    $("#rid").val(aa.rid);



}

function updateRiZhi() {

    $.ajax({
        url:"<%=request.getContextPath()%>/rizhi/updaterizhi",
        type:"post",
        data:{"rid":$("#rid").val(),"rtime":$("#rtime1").val(),"rname":$("#rname1").val(),"rtype":$("#rtype1").val()},
        success:function(result){
            if (result) {

                alert("修改成功")

                $("#hotel").datagrid("reload");
            }
        }
    })




</script>
</body>
</html>
