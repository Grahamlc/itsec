<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>USTC-ITSEC信息管理平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<script  type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js" ></script>		
		<link rel="shortcut icon" href="images/title.png" type="image/x-icon">
		<style type="text/css">
			body {
			 margin: 0px;padding:0;
			 background-color:#eef3f7;
			}
		</style>
	</head>
	<body class="container-fluid" border="1px">
		
			
			<center>
				<div style="width:700px">
				<form action="changePass" method = "post" name="changePass">
				<div class="modal-body">
				<table>
					<input type="hidden" value="${session.user.userId}" name="userId"/>	
					<tr>
					<td><b>当前密码</b></td>
					<td>
						<input type="text" name="oldPass" />
					</td>
					<tr>
					<tr>
					<td><b>新密码</b></td>
					<td>
						<input type="text" name="newPass" />
					</td>
					<tr>
					<tr>
					<td><b>确认密码</b></td>
					<td>
						<input type="text" name="checkPass" />
					</td>
					<tr>
				</table>
				</div>
				<div class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               onclick="window.history.go(-1)">返回
		            </button>
		            <button type="submit" class="btn btn-success" onClick="return check()">
		         	      确认	
		            </button>
		         </div>	
				</form>	
				</div>		
			</center>
		

		
		<div class="navbar-fixed-bottom container span12 ">
        <p class=" text-center ">&copy;中国科学技术大学信息安全测评中心&nbsp;&nbsp;&nbsp;&nbsp;地址：邮编：  <a href="http://itsec.ustc.edu.cn/contact.php">联系我们</a></p>
        <p class="text-center"></p>
		</div>
	</body>
</html>
