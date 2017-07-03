<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="login/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="login/jquery.js"></script>
<script type="text/javascript">
	$(function(){	
		//导航切换
		$(".menuson li").click(function(){
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});
		
		$('.title').click(function(){
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if($ul.is(':visible')){
				$(this).next('ul').slideUp();
			}else{
				$(this).next('ul').slideDown();
			}
		});
	})
</script>
</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span></div>
       <dl class="leftmenu">  		
		 
		 <%request.setCharacterEncoding("utf-8"); %>
		
		<!-- 通过JavaScript实现不同frame之间的传值 -->
    
    <c:if test="${session.corId eq project.corId}">
    <dd>  	
    <div class="title">
		<span><img src="images/leftico01.png" /></span>	
		<center>
		<a href="caidan.jsp?corId=${session.corId}" target="cpstop"><h3>${project.corName}</h3></a>
		
		</center>	    		
    </div>
    	<ul class="menuson" style="display:block">
    	 <li>		
			<a href="NewSystem.jsp?id=${session.corId}" target="right">
			<cite></cite><h4><b>创建系统</b></h4><i></i>
			</a>
		 </li>					
			<s:iterator id="sys" value="#session.systems">																		
				<!--
				<s:url value="/showSysteminfo" var="mySys" >
					<s:param name="sysId" value="#sys.autoId" />
				</s:url>
				-->
				<li><a href='caidan.jsp?corId=${session.corId}&sysId=${sys.autoId}' target="cpstop" >
						<cite></cite><h2>${sys.sysName}</h2><i></i>
					</a>
				</li>
			</s:iterator>						
		</ul>  
    </dd>
 	</c:if>
    </dl>
   
</body>
</html>

	
