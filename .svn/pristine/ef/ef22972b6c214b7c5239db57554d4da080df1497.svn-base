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
		当前位置：项目管理		
	</div>
       <dl class="leftmenu">  		
	
		 <%request.setCharacterEncoding("utf-8"); %>
		<s:iterator id="allPro" value="allProjects">
		<!-- 通过JavaScript实现不同frame之间的传值 -->
		
		<!-- 商务 或者  主任 -->
    <c:if test="${role eq 2 or role eq 3}">
    <dd>  	
	    <div class="title">
			<!--<span><img src="images/leftico01.png" /></span>	-->
			<cite></cite>&nbsp;&nbsp;&nbsp;
			<a href="ProMenu.jsp?corId=${allPro.company.corId}&proId=${allPro.autoId}" target="protop">${allPro.company.corName}</a>
		    		
	    </div>
    	<ul class="menuson" style="display:block">	
						
			<s:iterator value="#allPro.testSystems" id="tsys">
		
				<li><a href='ProMenu.jsp?corId=${allPro.company.corId}&testSysId=${tsys.autoId}&proId=${allPro.autoId}&sysId=${tsys.system.autoId}' target="protop" >
					<cite></cite>${tsys.system.sysName}<i></i>
				</a>
				</li>

			</s:iterator>
							
		</ul>  
    </dd>
    </c:if>
    
    <!-- 测评师  客户 -->
     <c:if test="${role eq 4 or role eq 1}">
    	 你没有权限，请联系管理员~
    </c:if>
    </s:iterator>

    </dl>
   
</body>
</html>


