<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>USTC-ITSEC信息管理平台</title>
		<meta  http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<script  type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js" ></script>
		<link rel="shortcut icon" href="images/title.png" type="image/x-icon">
		<link href="login/style.css" rel="stylesheet" type="text/css" />
		<base target="_blank"/>	
		<script>
			function check(){
			var r=confirm('您确定要退出吗？');
			if (r==true)
			  {
			    return true;
			  }
			else
			  {
				return false;
			  }
		}
		</script>
		<style type="text/css">
			body {
			 margin: 0px;padding:0;
			 background-color:#eef3f7;
			}
			.all{margin-top:30px;}
			.bt button{width:170px;height:80px;margin-top:30px;}
			.topright{height:88px;float:right;margin-top:-70px;}
			.topright ul{padding-top:15px; float:right; padding-right:12px;list-style:none;}
			.topright ul li{float:left; padding-left:9px; padding-right:9px; background:url(images/line.gif) no-repeat right;}
			.topright ul li:last-child{background:none;}
			.topright ul li a{font-size:13px; color:#e9f2f7;}
			.topright ul li a:hover{color:#fff;}
			.topright ul li span{margin-top:2px;float:left;padding-right:3px;}
			.user{height:30px;background:url(images/ub1.png) repeat-x;clear:both;margin-top:10px;float:right; margin-right:20px;border-radius:30px; behavior:url(js/pie.htc); white-space:nowrap;position:relative;}
			.user span{display:inline-block;background:url(images/user.png) no-repeat 15px 10px; line-height:30px; font-size:14px;color:#b8ceda; padding-left:20px; padding-left:35px;}
			.user i{display:inline-block;margin-right:15px;font-style:normal;line-height:30px; font-size:14px;color:#b8ceda;}
			.modal-dialog{width:1000px;}
			.btn-success{color:#000 !important;}
			.btn-default{color:#000 !important;}
		</style>
	</head>
	<body>

    <div style="height:150px;background-color:#056eb0">
		<p style="margin-left:20px;padding-top:12px;color:#fff;font-weight:bold;font-size:20px;">中国科学技术大学信息安全测评中心管理平台</p>
		<p style="color:#fff;margin-left:20px;margin-top:-10px;font-size:13px;word-spacing:2px;">Management Platform of USTC Information Security Evaluation Center</p>
	
	<div class="topright">    
	    <ul>
	    <li><a href="showCompanys?url=guide.jsp">首页</a></li>
	    <li><a href="http://itsec.ustc.edu.cn">微博</a></li>
	    <li><a href="http://itsec.ustc.edu.cn">官网</a></li>
	    <li><a data-toggle="modal" data-target="#changePass">修改密码</a></li>
	    
	    <li><a href="Login!logout.action" onclick="return check()" target="_self">退出</a></li>
	    </ul>
	     
	    <div class="user">
		    <span><c:out value="${user.tester.name}" default="您还没有登录"/></span>
		    <i></i>
	    </div>    
    </div>
	</div>
	<div class="modal fade" id="changePass" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	<form action="changePass" method = "post" name="changePass">
	   	<div class="modal-dialog">
	      <div class="modal-content">
	               	
		     <div class="modal-body">		    			
				<table class="table table-bordered">
					<input type="hidden" value="${session.user.userId}" name="userId"/>	
					<tr>
					<td><b>当前密码</b></td>
					<td>
						<input type="password" name="oldPass" />
					</td>
					
					<td><b>新密码</b></td>
					<td>
						<input type="password" name="newPass" />
					</td>
					
					<td><b>确认密码</b></td>
					<td>
						<input type="password" name="checkPass" />
					</td>
					<tr>
				</table>	
				<button type="button" class="btn btn-default" data-dismiss="modal">
					关闭
		         </button>
		         <button type="submit" class="btn btn-success"">
		         	      确认	
		         </button>			
			 </div>
		                
	      </div>
	</div>
	</form>
</div>	
</body>
</html>