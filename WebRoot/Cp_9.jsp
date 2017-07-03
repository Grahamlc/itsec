<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>USTC-ITSEC信息管理平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
		<link rel="shortcut icon" href="images/title.jpg" type="image/x-icon">
		<style type="text/css">
			body {
			 margin: 0px;padding:0;
			 background-color:#eef3f7;
			}
		</style>
	</head>
	<body class="container-fluid">
		<br><br>
		<div class="tag" id="d9" >
				<!-- 测评指导书 --><br>
				<center>
				<table class="table table-striped table-bordered">
					<thead><tr height="30px" class="success"><th>对象</th><th>测评方法</th></tr></thead>
					<tbody>	
						<s:iterator id="devc" value="device">
						<tr height="25px">
							<td>${deviceName}</td>
							<td>${method}</td>
							<input type="hidden" value="${autoId}" name="deviceId" />
						</tr>
						</s:iterator>
				</tbody>
				</table>
				</center>
			</div> 
		<div class="navbar-fixed-bottom container span12 ">
        <p class=" text-center ">&copy;中国科学技术大学信息安全测评中心&nbsp;&nbsp;&nbsp;&nbsp;地址：邮编：  <a href="http://itsec.ustc.edu.cn/contact.php">联系我们</a></p>
        <p class="text-center"></p>
		</div>
	</body>
</html>
