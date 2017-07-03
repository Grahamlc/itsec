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
				$(".bt1").click(function(){
				   $("#bt").val(function(){ 
					  $(".title") 
								.hide() 
								.filter(":contains('"+( $(this).val() )+"')") 
								.show(); 
				   }).val(); 
			  });
				})
</script>
<style>
	.lefttop{height:auto;}
	.title{height:auto}
</style>
</head>

<body style="background:#f0f9fd;">
	
	<div class="lefttop"><span></span>
		当前位置：测评工作		
	</div>
       <dl class="leftmenu">  		
	
		 <%request.setCharacterEncoding("utf-8"); %>
		<s:iterator id="testSys" value="testSystem">
			<dd>  	
			    <div class="title">
					<!--<span><img src="images/leftico01.png" /></span>	-->
					<cite></cite>&nbsp;&nbsp;&nbsp;
					<a href="CpMenu.jsp?corId=${testSys.system.company.corId}" target="cptop">${testSys.system.company.corName}</a>
				    		
			    </div>
		    	<ul class="menuson" style="display:block">					 									
					<li>
					<a href="CpMenu.jsp?testSysId=${testSys.autoId}&sysId=${testSys.system.autoId}&corId=${testSys.system.company.corId}" target="cptop">
						<cite></cite>${testSys.system.sysName}<i></i>
					</a>
					</li>							
				</ul>  
	    	</dd>
    </s:iterator>

    </dl>
   
</body>
</html>


