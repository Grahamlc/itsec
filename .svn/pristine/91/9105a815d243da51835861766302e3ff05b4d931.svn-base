<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>USTC-ITSEC信息管理平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<script  type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js" ></script>		
		<link rel="shortcut icon" href="images/title.png" type="image/x-icon">
		<style type="text/css">
			body {
			 margin: 0px;padding:0;
			 background-color:#eef3f7; 
			}
			.my-table{width:95%}
		</style>
		<script>
		$(function(){
			$("select").get(0).selectedIndex = S3;
		}
		</script>
	</head>
	<body class="container-fluid">
		<br><br>
		<div class="tag" id="d2">
			<br>
			<!-- 项目信息-->					
			<center>
			<s:iterator value="system" id = "ss">
			<table class="table table-striped table-bordered my-table" >    			
				
				<tr height="30px">
					<td width="10%">系统名称:</td>							
					<td class="text-left">${sysName}</td>	
				</tr>						
				<tr height="30px">
					<td>安全等级:</td>
					<td id="sysLevel" width=20%>
						${secLevel}
					</td>
				</tr>
			
				<tr height="30px">							
					<td>等级组合：</td>
					<td>${level}</td>							
				</tr>
				<tr height="30px">							
					<td>系统备案号：</td>
					<td>${backId}</td>							
				</tr>
				<s:iterator value="testSystem" id="testSys">
				
					<tr height="30px">						
						<td>测评结果:</td>	
						<s:if test="#testSys.cpState == 10"> <!-- 表示测评结束 -->
							<td>${testSys.testResult}</td>
						</s:if>
						<s:else>
							<td>测评中</td>
						</s:else>						
						
					</tr>
					
					
					<tr>	
						<td>测评时间:</td>
						<td>				
							${testSys.startDate} ———— ${testSys.overDate}
						
						</td>
					</tr>
					
					<c:if test="${role eq 4 }">
					<s:if test="#testSys.cpState == 1">
						<tr>		
							<td>
								<button  data-toggle="modal" data-target="#startTest"><span><img src="images/ceping.png"></span>安排测评人员
								</button>
								<c:set value="${testSys.autoId}" var="testSysId"/>
							</td>								
						</tr>
					</s:if>
					</c:if>			
				</s:iterator>			 		
			</table>
		</s:iterator>
			</center>
			<input type=button class="btn btn-info" value="后退" onclick="window.history.go(-1)" style ="margin-left:2.5%;margin-top:50px">					
		</div>

		<div class="modal fade" id="startTest" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	 <form action="startTest" method = "post">
	   	<div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="myModalLabel">	            	
	             		开始测评				
	            </h4>
	         </div>	        		        	
	         	<input type="hidden" name="sys" value="${param.sysId}">	
	         	<input type="hidden" name="testSysId" value="${testSysId}">         	
		         <div class="modal-body">
		         	<s:iterator value="system" id = "ss">
		         	<b>备案编号</b>
		         	<input type="text" name="#ss.backId" value="${backId}">
		         	<button>上传</button><hr>
		         	<b>等级组合</b>
		         	<select name="sLevel">
						<option value="${fn:substring(level, 0, 2)}">
							${fn:substring(level, 0, 2)}
						</option>
						<option value="S1">S1</option>
						<option value="S2">S2</option>
						<option value="S3">S3</option>
						<option value="S4">S4</option>
						<option value="S5">S5</option>
						
					</select>				
				<select name="gLevel">
					<option value="${fn:substring(level, 4, 6)}">
						${fn:substring(level, 4, 6)}
					</option>
					<option value="G1">G1</option>
					<option value="G2">G2</option>
					<option value="G3">G3</option>
					<option value="G4">G4</option>
					<option value="G5">G5</option>
					</optgroup>
				</select>	
				<select name="aLevel">
					<option value="${fn:substring(level, 2, 4)}">
						${fn:substring(level, 2, 4)}
					</option>
					<option value="A1">A1</option>
					<option value="A2">A2</option>
					<option value="A3">A3</option>
					<option value="A4">A4</option>
					<option value="A5">A5</option>
					</optgroup>
				</select>
				</s:iterator>
				<hr>
				<!--  
		         	<b name="manager" value="4">项目经理</b>
		         	<select name="manager_p">
						<s:iterator id="testers" value="testers">
							<option value='${userId}'><s:property value="name" /></option>
						</s:iterator>
					</select><hr>
				-->
					<b name="host" value="6">主机</b>
		         	<select name="host_p">
						<s:iterator id="" value="testers">
							<option value='<s:property value="userId" />'><s:property value="name" /></option>
						</s:iterator>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;
					<b name="db" value="7">数据库</b>
		         	<select name="db_p">
						<s:iterator value="testers">
							<option value='<s:property value="userId" />'><s:property value="name" /></option>
						</s:iterator>
					</select><br><br>

					<b name="app" value="8">应用</b>
		         	<select name="app_p">
						<s:iterator id="" value="testers">
							<option value='<s:property value="userId" />'><s:property value="name" /></option>
						</s:iterator>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;
					<b name="net" value="9">网络</b>
		         	<select name="net_p">
						<s:iterator value="testers">
							<option value='<s:property value="userId" />'><s:property value="name" /></option>
						</s:iterator>
					</select><br><br>

					<b name="ph" value="10">物理</b>
		         	<select name="ph_p">
						<s:iterator value="testers">
							<option value='<s:property value="userId" />'><s:property value="name" /></option>
						</s:iterator>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;
					<b name="manag" value="11">管理</b>
		         	<select name="manag_p">
						<s:iterator id="" value="testers">
							<option value='<s:property value="userId" />'><s:property value="name" /></option>
						</s:iterator>
					</select>

		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭
		            </button>
		            <button type="submit" class="btn btn-success">
		         	      开始测评	
		            </button>
		         </div>
	         
	      </div>
	</div>
	</form>
</div>		
		<div class="navbar-fixed-bottom container span12 ">
        <p class=" text-center ">&copy;中国科学技术大学信息安全测评中心&nbsp;&nbsp;&nbsp;&nbsp;地址：邮编：  <a href="http://itsec.ustc.edu.cn/contact.php">联系我们</a></p>
        <p class="text-center"></p>
		</div>
	</body>
</html>
