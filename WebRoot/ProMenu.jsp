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
			.nav{float:left;padding-left:50px;padding-bottom:7px;background:#f0f9fd;width:100%;}
			.nav li{float:left;width:130px;height:78px; text-align:center;}
			.nav li a{display:block;width:120px;height:85px; }
			.nav li a.selected{background:url(images/navbg.png) no-repeat;}
			.nav li a:hover{display:block;background:#3fafe1;color:#fff;}
			.nav li img{margin-top:0px;margin-bottom:-15px;}
			.nav a h2{font-size:16px;color:#000;}
			.selected{display:block;background:#3fafe1;color:#fff;}
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

		<script type="text/javascript">
			function getUrlParam(name)
			{
				var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
				var r = window.location.search.substr(1).match(reg);  //匹配目标参数
				if (r!=null) 
					return unescape(r[2]); 
				return null; //返回参数值
			} 
			function check(){
				if (getUrlParam("sysId") == null) {
					var r=confirm('您确定选择单位和系统了吗？');
					if (r==true)
					  {
					    return true;
					  }
					else
					  {
						return false;
					  }
					return true;
				}
				
			}
			function checkSys(){
				if (getUrlParam("corId") == null) {
					var r=confirm('您确定选择单位了吗？');
					if (r==true)
					  {
					    return true;
					  }
					else
					  {
						return false;
					  }
					return true;
				}
				
			}
		</script>

	</head>
	<body>
		<ul id="row" class="nav">	
			
			<li><a href="showMPro?proId=${param.proId}&url=Cp_0.jsp" target="proright" ><img src="images/icon01.png" title="项目信息" /><h2>项目信息</h2></a></li>
			
			<li><a href="showSysteminfo?sysId=${param.sysId}&url=Cp_2.jsp" target="proright" onclick="return check()"><img src="images/icon02.png" title="系统信息" /><h2>系统信息</h2></a></li>
			
		
			<li><a href="showInformation?corId=${param.corId}&url=Cp_3.jsp"  target="proright"><img src="images/icon03.png" title="测评方案" /><h2>测评方案</h2></a></li>
			
			<li><a href="showObject?corId=${param.corId}&testSysId=${param.testSysId}&url=Cp_4.jsp&mark=1"  target="proright" onclick="return check()"><img src="images/icon04.png" title="测评人员" /><h2>测评人员</h2></a></li>

			<li><a href="showObject?corId=${param.corId}&testSysId=${param.testSysId}&url=Cp_6.jsp&mark=1"  target="proright" onclick="return check()"><img src="images/icon06.png" title="测评结果" /><h2>测评结果</h2></a></li>
	
			<li><a href="report?testSysId=${param.testSysId}" target="proright" onclick="return check()"><img src="images/icon05.png" title="测评报告" /><h2>测评报告</h2></a></li>
		
		<!-- 
		<%request.setCharacterEncoding("utf-8"); %>
		<s:iterator value="#session.menuPriv" id="mpriv">	
		
		<s:if test="menu.autoId == 0">
			<li><a href="showMCor?corId=${param.corId}&url=Cp_0.jsp" target="right" ><img src="images/icon01.png" title="项目信息" /><h2>项目信息</h2></a></li>
		</s:if>
		<s:if test="menu.autoId == 1">
			<li><a href="showMCor?corId=${param.corId}&url=Cp_1.jsp" target="right" onclick="return checkSys()"><img src="images/icon01.png" title="单位信息" /><h2>单位信息</h2></a></li>
		</s:if>
		<s:if test="menu.autoId == 2">
			<li><a href="showSysteminfo?sysId=${param.sysId}&url=Cp_2.jsp" target="right" onclick="return check()"><img src="images/icon02.png" title="系统信息" /><h2>系统信息</h2></a></li>
		</s:if>
		<s:if test="menu.autoId == 3">
			<li><a href="showInformation?corId=${param.corId}&url=Cp_3.jsp"  target="right"><img src="images/icon03.png" title="测评方案" /><h2>测评方案</h2></a></li>
		</s:if>
		<s:if test="menu.autoId == 4">
			<li><a href="showObject?corId=${param.corId}&sysId=${param.sysId}&url=Cp_4.jsp&mark=1"  target="right" onclick="return check()"><img src="images/icon04.png" title="测评人员" /><h2>测评人员</h2></a></li>
		</s:if>		
		<s:if test="menu.autoId == 5">
			<li><a href="showObject?corId=${param.corId}&sysId=${param.sysId}&url=Cp_6.jsp&mark=1"  target="right" onclick="return check()"><img src="images/icon06.png" title="测评结果" /><h2>测评结果</h2></a></li>
		</s:if>
		<s:if test="menu.autoId == 6">
			<li><a href="report?sysId=${param.sysId}" target="right" onclick="return check()"><img src="images/icon05.png" title="测评报告" /><h2>测评报告</h2></a></li>
		</s:if>
		<s:if test="menu.autoId == 7">
			<li><a href="showSysteminfo?sysId=${param.sysId}&url=Cp_7.jsp"  target="right" onclick="return check()"><img src="images/icon07.png" title="测评进展" /><h2>测评进展</h2></a></li>
		</s:if>
		<s:if test="menu.autoId == 8">
			<li><a href="showObject!showHistory.action?sysId=${param.sysId}&url=Cp_8.jsp&mark=0" target="right" onclick="return check()"><img src="images/icon08.png" title="历史测评" /><h2>历史测评</h2></a></li>
		</s:if>
		<s:if test="menu.autoId == 9">
			<li><a href="showDevice"  target="right"><img src="images/icon09.png" title="测评指导" /><h2>测评指导</h2></a></li>
		</s:if>
		 
		</s:iterator>
		-->
		</ul>
	</body>
</html>
