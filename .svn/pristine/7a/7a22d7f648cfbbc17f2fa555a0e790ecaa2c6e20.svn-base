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
			table {border-bottom: 1px;}
			table thead tr {height: 40px;}
			.my-table{width:95%}
		</style>
	</head>
	<body class="container-fluid">
		<br><br>
		<center>
		<table class="table table-striped table-bordered my-table">
			<thead>
				<tr class="success">					
					<th>开始日期</th>					
					<th>测评系统</th>
					<th>测评状态</th>	
					<th>责任人</th>				
				</tr>
			</thead>
			<s:iterator value="allProjects" id="pro">
				<s:iterator value="#pro.testSystems" id="testSys">
				<tr>					
					<td>${pro.date}</td>
					<td>${system.sysName}</td>
					<td>
						<s:if test="testSys.cpState == 10">
							测评结束
						</s:if>
						<s:else>
							正在测评
						</s:else>
					</td>	
					<td>${pro.responsor.name}</td>			
				</tr>
				</s:iterator>
			</s:iterator>
		</table>
		</center>
		<div class="navbar-fixed-bottom container span12 ">
        <p class=" text-center ">&copy;中国科学技术大学信息安全测评中心&nbsp;&nbsp;&nbsp;&nbsp;地址：邮编：  <a href="http://itsec.ustc.edu.cn/contact.php">联系我们</a></p>
        <p class="text-center"></p>
		</div>
	</body>
</html>
