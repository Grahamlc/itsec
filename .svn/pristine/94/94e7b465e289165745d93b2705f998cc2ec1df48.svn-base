<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  <title>USTC-ITSEC信息管理平台</title>
		<meta  http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
		<link rel="shortcut icon" href="images/title.jpg" type="image/x-icon">
		<base target="_blank"/>	
		<style type="text/css">
			.nav{float:left;padding-left:100px;padding-bottom:7px;background:#f0f9fd;width:100%;}
			.nav li{float:left;width:87px;height:78px; text-align:center;}
			.nav li a{display:block;width:87px;height:85px; }
			.nav li a.selected{background:url(../images/navbg.png) no-repeat;}
			.nav li a:hover{display:block;background:#3fafe1;color:#fff;}
			.nav li img{margin-top:0px;margin-bottom:-15px;}
			.nav a h2{font-size:14px;color:#000;}
		</style>
	</head>
	<body>
		 <ul id="row" class="nav">			
		 	<%request.setCharacterEncoding("utf-8"); %>
		 	
		 	<s:iterator value="#session.menuPriv">
		 		<li><a href="Cp_${menu.autoId}.jsp" target="right"><img src="images/icon0${menu.autoId}.png" /><h2>${menu.name}</h2></a></li>
		 	</s:iterator>
			 
		 </ul>
	</body>
</html>
