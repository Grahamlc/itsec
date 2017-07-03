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
			.my-table{width:95%;}
		</style>
	</head>
	<body class="container-fluid">
		<br><br>
		<div class="tag" id="d4">
			
			<center>
			<table class="table table-striped table-bordered my-table" >	
				<thead>
					<tr class="success" height="40px">
					<th class="text-center">分工</th><th class="text-center">测评师</th>
					<th class="text-center">联系方式</th><th class="text-center">邮箱</th>
					</tr>
				</thead>				
				<tbody>
				<br />
				<!-- 从数据库中得到该项目测评师信息输入到对应信息中 -->
					<s:iterator id="st" value="sysTester">
					<tr height=30px>
						<s:iterator value="#st.role" id = "str">
							<td width="25%"><b>${roleName}</b></td>
						</s:iterator>
						<s:iterator value="#st.tester" id="stt">
							<td width="20%">${name }</td>
							<td width="20%">${pcont}</td>
							<td width="35%">${mcont}</td>
						</s:iterator>
					</tr>
					</s:iterator>
				</tbody>
			</table> 
			</center> 
			<input type=button class="btn btn-info" value="后退" onclick="window.history.go(-1)" style ="margin-left:2.5%;margin-top:50px">
		</div> 
		<div class="navbar-fixed-bottom container span12 ">
        <p class=" text-center ">&copy;中国科学技术大学信息安全测评中心&nbsp;&nbsp;&nbsp;&nbsp;地址：邮编：  <a href="http://itsec.ustc.edu.cn/contact.php">联系我们</a></p>
        <p class="text-center"></p>
		</div>
	</body>
</html>
