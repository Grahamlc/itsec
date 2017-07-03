<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>USTC-ITSEC信息系统管理平台</title>
	<link rel="shortcut icon" href="images/title.png" type="image/x-icon";>
	<link rel="stylesheet" type="text/css" href="logincss/style.css" />
	<style type="text/css">
		.bt{text-align:center;font-size:22px;font-weight:bold;margin-left:auto; margin-right:auto;color:#fff;margin-top:8%; position:relative;}
	</style>
	<link rel="stylesheet" type="text/css" href="login/style.css" rel="stylesheet"/>
	<script language="JavaScript" src="login/jquery.js"></script>
	<script src="login/cloud.js" type="text/javascript"></script>
	<script language="javascript">
		$(function(){
			$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
			$(window).resize(function(){  
			$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
			})  
		});  
		function checknumabs(abc){
				var zz = new RegExp();   
				zz = /^[A-Za-z0-9]+$/;    
				if(zz.test(abc)){
				   return true;
				}else{
					return false;
				}
			}
		function checkform(){
			var userId=document.getElementById("userId").value;
			var password=document.getElementById("password").value;
			if(!checknumabs(userId)){	
				alert('请输入正确的用户名');
				return false;
			}
			if(!checknumabs(password)){	
				alert('请输入正确的密码');
				return false;
			}
			document.form1.submit();
		}
		function qyDate()
			{
			var d=new Date();
			var yy=d.getFullYear();
			var mm=d.getMonth()+1;
			var dd=d.getDate();
			var h=d.getHours();
			var n=d.getMinutes();
			var s=d.getSeconds();
			if(h<10)
			{
				h="0"+h;
			}
			if(n<10)
			{
				n="0"+n;
			}
			if(s<10)
			{
				s="0"+s;
			}
			var result=yy+"年"+mm+"月"+dd+"日"+h+":"+n+":"+s;
			return result;
		}
			function showDate()
			{
				var sysDate=qyDate();   //
				document.getElementById("myTime").innerHTML=sysDate;
			}
		window.onload=showDate;
		setInterval("showDate()",1000);
	</script> 
</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
    </div>  
	<div class="logintop">    
    <span>欢迎使用中国科学技术大学信息安全测评中心管理平台</span>    
    <ul>
    <li><a>当地时间：</a></li>
    <li><a id="myTime"></a></li>
    </ul>    
    </div>
    
    <div class="loginbody">

    <div class="bt">USTC-ITSEC信息系统管理平台</div>
       
    <div class="loginbox">
		<form method="post" action="Login!login.action">
			<ul>
			<li><input type="text" name="userId" class="loginuser" id="userId" placeholder = "用户名" onclick="this.value=''" onblur="if(this.value==''){this.value='用户名';}" /></li>
			<li><input input type="password" name="password" class="loginpwd" id="password" placeholder="密码" onclick="this.value=''" onblur="if(this.value==''){this.value='密码';}"/></li>
			<li><input type="submit" class="loginbtn" value="登陆"   onclick="return checkform();" /></li> 
			
			</ul>
		</form>
    
    </div>
    
    </div>
    <div class="loginbm">中国科学技术大学信息安全测评中心&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://itsec.ustc.edu.cn/contact.php">联系我们</a></div>
	
    
</body>

</html>
