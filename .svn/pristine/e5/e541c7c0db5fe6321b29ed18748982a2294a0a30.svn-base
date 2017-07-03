<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 	<head>
		<title>USTC-ITSEC信息管理平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
		<script src="bootstrap/js/jquery.min.js"></script>
		<link rel="shortcut icon" href="images/title.jpg" type="image/x-icon">
		<link href="login/style.css" rel="stylesheet" type="text/css" />
		
		<style type="text/css">
			a{text-decoration:none;font-weight:bold;}
			a:hover{text-decoration:none;display:block;color:#3fafe1;}
			.selected{display:block;background:#f0f9fd;}
		</style>
		<script type="text/javascript">
			$(function(){	
				//顶部导航切换
				$("a").click(function(){
					$("a.selected").removeClass("selected")
					$(this).addClass("selected");
				})	
			})	
	</script>
	</head>
	<body style="background:#f0f9fd;">
		<div class="lefttop"><span></span>后台管理</div>
		<c:if test="${role eq 5}">
		<dl class="leftmenu">
		<dd>
		<div class="title">
		<span><img src="images/leftico01.png" /></span><a href="showCompanys?url=Maleft.jsp" target="right" class="selected">单位管理</a>
		</div>
		</dd>
		<dd>
		<div class="title">
		<span><img src="images/leftico01.png" /></span><a href="super!showUser.action" target="right">用户管理</a>
		</div>
		</dd>
		<dd>
		<div class="title">
		<span><img src="images/leftico02.png" /></span><a href="super!showRole.action" target="right">角色管理</a>
		</div>
		</dd>
		<dd>
		<div class="title">
		<span><img src="images/leftico01.png" /></span><a href="super!showTester.action" target="right">测评师管理</a>
		</div>
		</dd>
		<dd>
		<div class="title">
		<span><img src="images/leftico03.png" /></span><a href="adduser?url=adduser.jsp" target="right">添加用户</a>
		</div>
		</dd>
		<!-- 
		<dd>
			<div class="title">
			<span><img src="images/leftico04.png" /></span><a href="/itsecProject/addrole.html" target="right">添加角色</a>
			</div>		 
		</dd>
				
		<dd>
			<div class="title">
			<span><img src="images/leftico04.png" /></span><a href="/itsecProject/addtester.html" target="right">添加测评师</a>		
			</div>	 
		</dd>
		 -->
		</dl>
		</c:if>
	</body>
</html>
