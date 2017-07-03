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
		
		/*
		$('.title').click(function(){
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if($ul.is(':visible')){
				$(this).next('ul').slideUp();
			}else{
				$(this).next('ul').slideDown();
			}
		});
		*/
	})
</script>
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
		当前位置：客户管理		
	</div>
	
    <dl class="leftmenu">  		

		 <%request.setCharacterEncoding("utf-8"); %>
		<s:iterator id="com" value="companys">
		<!-- 通过JavaScript实现不同frame之间的传值 -->
		<!-- 商务 或者  主任 -->
	    <c:if test="${role eq 2 or role eq 3}">
	    <dd>  	
	    <div class="title">
			<!--<span><img src="images/leftico01.png" /></span>	-->
			<cite></cite>&nbsp;&nbsp;&nbsp;
			<a href="caidan.jsp?corId=${com.corId}" target="cpstop">${com.corName}</a>
		    		
	    </div>
    	<ul class="menuson" style="display:block">	
			 				
			<s:iterator value="#com.systems" id="sys">		
				<li><a href='caidan.jsp?corId=${com.corId}&sysId=${sys.autoId}' target="cpstop" >
					<cite></cite>${sys.sysName}<i></i>
				</a>
				</li>
			</s:iterator>
			<li>		
				<a href="NewSystem.jsp?id=${com.corId}" target="right">
				<cite></cite><h4>创建系统</h4><i></i>
				</a>
			</li>				
		</ul>  
    	</dd>
    </c:if>
    
    <!-- 测评师 -->
    <c:if test="${role eq 4}">
    <dd>  	
    <div class="title">
		<!--<span><img src="images/leftico01.png" /></span>	-->
		<cite></cite>&nbsp;&nbsp;&nbsp;
		<a href="caidan.jsp?corId=${corId}" target="cpstop">${com.corName}</a>
	    		
    </div>
    <!--  -->
    	<ul class="menuson">
				
			 <li>		
			<a href="/itsecProject/NewSystem.jsp?id=${com.corId}" target="right">
			<cite></cite><h4><b>创建系统</b></h4><i></i>
			</a>
			</li>				
			<s:iterator value="#com.systems" id="sys">		
				<c:if test="${sys.state eq 1}"	>
				<li>
					<a href='caidan.jsp?corId=${com.corId}&sysId=${sys.autoId}' target="cpstop" >
						<cite></cite><h2>${sys.sysName}</h2><i></i>
					</a>
				</li>
				</c:if>
			</s:iterator>
							
		</ul>  
    </dd>
    </c:if>
    </s:iterator>

    </dl>
   
</body>
</html>


