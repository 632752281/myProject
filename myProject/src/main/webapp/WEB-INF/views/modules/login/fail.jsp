<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/jquery-easyui-1.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/jquery-easyui-1.5/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/jquery-easyui-1.5/demo/demo.css">
	<script type="text/javascript" src="<%=basePath%>static/jquery-easyui-1.5/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/jquery-easyui-1.5/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	
	
	$.messager.progress();	// display the progress bar
	 $(function(){
		var url = "a/login";
  		$('#userForm').form('submit', {
  			url: url,
  			onSubmit: function(){
  				var isValid = $(this).form('validate');
  				if (!isValid){
  					$.messager.progress('close');	// hide progress bar while the form is invalid
  				}
  				return isValid;	// return false will stop the form submission
  			},
  			success: function(){
  				$.messager.progress('close');	// hide progress bar while submit successfully
  			}
  		});
  	});  
	</script>
  </head>
<body>
    
<form id="userForm" method="post" action="a/login">


<p>权限认证失败    没有权限认证提交的地址 页面</p>

${msg}
    <div>
		<label for="name">loginName:</label>
		<input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
    </div>
    <div>
		<label for="email">passWord:</label>
		<input class="easyui-validatebox" type="text" name="pass" data-options="validType:'email'" />
    </div>
    
    <div>
		 <input type="submit" name="Submit" value="登录" />
     <input type="reset" name="Reset" value="重置" />
    </div>
                    
</form>
  </body>
</html>
