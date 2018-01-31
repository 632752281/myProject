<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/jquery-easyui-1.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/jquery-easyui-1.5/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/jquery-easyui-1.5/demo/demo.css">
	<script type="text/javascript" src="<%=basePath%>static/jquery-easyui-1.5/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/jquery-easyui-1.5/jquery.easyui.min.js"></script>
	
	<script type="text/javascript">  
          
           $(function(){  
        	   initData();
        	});  
  
           function initData()
           {
               var url = "user/getUserPageList";
               var datagrid = $("#dataGrid").datagrid({  
                   title: "用户列表管理",  
                   border: false,  
                   locale: "zh_CN",  
                   iconCls: 'icon-save',  
                   width : 'auto',
                   height : $(this).height()-85,
                   striped: true,  
                   sortOrder: "desc",  
                   collapsible: false,  
                   url: url,  
                   queryParams:{id:'',name:''},
                   loadMsg: "正在加载数据，请稍后",
                   columns: [[  
                       { field: 'id', title: 'ID', width: '5%', algin: 'center' },  
                       { field: 'name', title: '编号', width: '10%', align: 'center' },  
                       {  
                    	   field: 'action',
                           title: '操作',
                           align: 'center',
                           formatter: function (value, row, index) 
                           {
                              return "<button  onclick='editRow("+row.id+")'>修改</button> <button onclick='javascript:deleteRow("+row.id+")'>删除</button>";
                        	  // return row.id;
                           }
                       }  
                   ]],  
                   toolbar: [{  
                       id: 'btnAdd',  
                       text: "添加",  
                       iconCls: 'icon-add',  
                       handler: function () {  
                           /* $("#winAdd").window("open");   */
                           alert("添加");  
                       }  
                   }, {  
                       id: 'btnEdit',  
                       text: "修改",  
                       iconCls: 'icon-edit',  
                       handler: function () {  
                           alert("修改"); 
                           editData();
                       }  
                   }],  
                   pagination: true,//表示在datagrid设置分页              
                   rownumbers: true,  //hanghao
                   fit:true,
                   singleSelect: true,  
               });  
        	   
        	   //设置分页控件  
               $("#dataGrid").datagrid("getPager").pagination({  
                   pageSize: 10,  
                   pageNumber: 1,  
                   pageList: [1,10, 20, 30, 40, 50],  
                   beforePageText: '第',//页数文本框前显示的汉字   
                   afterPageText: '页    共 {pages} 页',  
                   displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',  
              });  
           }
           
           
           
           //条件查询  
           function Search() {  
              var queryParameter = $('#dataGrid').datagrid("options").queryParams;  
               queryParameter.id = $("#id").val();  
               queryParameter.name = $("#name").val();  
        	   $("#dataGrid").datagrid("reload"); 
           }
           
           
           function reloadgrid() 
           {  
               //查询参数直接添加在queryParams中      
   				var queryParameter = $('#dataGrid').datagrid("options").queryParams;  
               queryParameter.id = $("#id").val();  
               queryParameter.name = $("#name").val();  
               
               $("#dataGrid").datagrid('reload');//重新加载table  
           }
           
           
           function editRow(data)
           {
               if(data == "" || data == null)
               {
                   alert("请选择要修改的记录，只能选取单行！");
                   return ;
               }
               //设置默认选中
               
               
                
           }
           
           function deleteRow()
		      {
		           var data = $('#dataGrid').datagrid("getSelections");
		           //删除 
		           var delurl = "${contextPath}/cardGift/cardGift.do?method=deleteCardGift&activeId="+data[0].activeId+"&giftGoodId="+data[0].giftGoodId;
		           //发送删除请求
		           $.ajax({
		              type: "POST",
		              dataType:'json',
		              url: delurl,
		              success: function(msg){
		                if(msg.success)
		                   {
		                       //保存回调函数使用的数据
		                       XW_dialog.addData('callbackData',msg.map);
		                       //删除成功
		                       XW_dialog.tips(msg.errorMsg, 3);
		                       deleteCallBack();
		                   }
		                   else
		                   {
		                       XW_dialog.alert('',msg.errorMsg);
		                   }
		              }
		       });
		   }   

           function editData()
           {
               var row = $('#dataGrid').datagrid("getSelections");
               alert(row);
               if($(row).length < 1 || $(row).length > 1)
               {
                   alert("请选择要查看的记录，只能选取单行！");
                   return ;
               }
               //设置默认选中
               $('#goodsSelect').combogrid('grid').datagrid('selectRecord',row[0].giftGoodId);
               $('#goodsSelect').hide();
               //设置选中值
               $('#giftCodeTotal').val(row[0].giftCodeTotal);
               $('#memoData').html(row[0].memo);
               $('#submitBtn').html("更新");
               $('#submitBtn').attr('onclick',"addSubmit('update');");
               $('#resetBtn').hide();
           }
           
           
		      function deleteData()
		      {
		           var data = $('#dataGrid').datagrid("getSelections");
		           //删除 
		           var delurl = "${contextPath}/cardGift/cardGift.do?method=deleteCardGift&activeId="+data[0].activeId+"&giftGoodId="+data[0].giftGoodId;
		           //发送删除请求
		           $.ajax({
		              type: "POST",
		              dataType:'json',
		              url: delurl,
		              success: function(msg){
		                if(msg.success)
		                   {
		                       //保存回调函数使用的数据
		                       XW_dialog.addData('callbackData',msg.map);
		                       //删除成功
		                       XW_dialog.tips(msg.errorMsg, 3);
		                       deleteCallBack();
		                   }
		                   else
		                   {
		                       XW_dialog.alert('',msg.errorMsg);
		                   }
		              }
		       });
		   }    
           
           //删除记录回调函数，默认调用刷新记录方法，
           function deleteCallBack(){
        	   reloadgrid();
           }
          
           
       </script>  
  
  
  </head>
  
  <body>
    
   <%-- <br> 
    查询列表
<table>
   <thead>
   	<th>序号</th>
   	<th>id</th>
   	<th>name</th>
   	<th>操作</th>
   </thead>
   <c:forEach items="${page.results}" var="user" varStatus="status">
   <tr>
    <td>
		${status.index+1}
	</td>
	<td>
		${user.id}
	</td>
	<td>
		${user.name}
	</td>
	<td>
		<a href="user/form?id=${user.id}">修改</a>
		<a href="#">删除</a>
	</td>
	</tr>
	</c:forEach>
</table>

 --%>
    
  <br>  
-数据展示 

<div data-options="region:'north',split:false,border:false,title:'查询条件',collapsed:false,iconCls:'icon-search'" style="height:60px;margin:5px 5px 0 5px">  
        id:<input type="text"  name="id" id="id" class="easyui-validatebox" maxlength="10" style="height:15px;margin:0 5px 0 5px" />  
       name:<input type="text"  name="name" id="name" class="easyui-validatebox" maxlength="10" style="height:15px;margin:0 5px 0 5px" />  
       &nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'"  onclick="Search()">查询</a>  
    </div>  
    
   <!--数据展示 -->  
<div data-options="region:'center',fit:true,split:false,border:false" style="width:100%;min-height:400px;" >  
    <table id="dataGrid" style="width:100%;" >
    </table>  
</div>   
    
  </body>
</html>
