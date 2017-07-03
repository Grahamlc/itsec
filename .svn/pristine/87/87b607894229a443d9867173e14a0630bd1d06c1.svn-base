<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>USTC-ITSEC信息管理平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
		<link rel="shortcut icon" href="images/title.jpg" type="image/x-icon">
		<style type="text/css">
			body {
			 margin: 0px;padding:0;
			 background-color:#eef3f7;
			
			}
			.my-table{width:95%;}
		</style>
	</head>
	<body class="container-fluid">
		<br><br>
		<div class="">
			
			<center>
			<s:form action="insert" method="post">
			<table class="table table-bordered my-table">
				<thead>
				<tr height=30px class="success">
				<th class="text-center" width="10%">选择</th>
				<th class="text-center">机房名称</th>
				<th class="text-center">物理位置</th>
				</tr>
				</thead>
				<tbody>
				<s:iterator value="phy">
				<tr height="40px">
				<td class="text-center"><input type="checkbox" name="phyId" value="${autoId}" <s:if test="status == 1">checked</s:if>  /></td>
				<td class="text-center">${name}</td>
				<td class="text-center">${location}</td>
				</tr>
				</s:iterator>
				</tbody>
			</table>
			<table class="table table-bordered my-table">
			<tr height=30px class="success">
				<th class="text-center" width="10%">选择</th>
				<th class="text-center">数据类型</th>
				<th class="text-center" style="width:140px;">所属业务应用</th>
				<th class="text-center" style="width:140px;">主机/存储设备</th>
				<th class="text-center" style="width:100px;">重要程度</th>																		
			</tr>
				
				<s:iterator status="md" value="md">

				<tr height="40px">
					<td class="text-center">
						<input type="checkbox" name="mdId" value="${autoId}" <s:if test="status == 1">checked</s:if>  />
						
					</td>
					<td class="text-center">${name}</td>
					<td class="text-center">${appSoft}</td>
					<td class="text-center">${hostMemory}</td>
					<td class="text-center">${important}</td>
										
				</tr>				
				</s:iterator>
				
				<tr height=30px class="success">
					<th class="text-center"></th>
					<th class="text-center">软件名称</th>
					<th class="text-center" colspan="2">主要功能</th>
					<th class="text-center">重要程度</th>
					
				</tr>
				<s:iterator status="as" value="as">

				<tr height="40px">
					<td class="text-center"><input type="checkbox" name="asId" value="${autoId}" <s:if test="status == 1">checked</s:if> /></td>
					<td class="text-center">${name}</td>
					<td style="text-align:center" colspan="2">${usedFor}</td>
					
					<td style="text-align:center">${important}</td>
										
				</tr>				
				</s:iterator>
				<tr height=30px class="success">
					<th class="text-center"></th>
					<th class="text-center">设备名称</th>
					<th class="text-center" colspan="2">操作系统/数据库管理系统</th>
					<th class="text-center">业务应用</th>
					
				</tr>
				<s:iterator status="hm" value="hm">
				<tr height="40px">
					<td class="text-center">
						<input type="checkbox" name="hmId" value="${autoId}" <s:if test="status == 1">checked</s:if>/>
					</td>
					<td width="200px" style="text-align:center">
						${name}
					</td>
					<td colspan="2" style="text-align:center">${osSystem}
					</td>
					<td style="text-align:center">
						${usedFor}
					</td>
					
				</tr>
				</s:iterator>
		
			
				<tr height=30px class="success">
					<th class="text-center"></th>
					<th class="text-center">设备名称</th>
					<th class="text-center" colspan="2">用途</th>
					<th class="text-center">重要程度</th>
					
				</tr>
				<s:iterator status="nd" value="nd">
				<tr height="40px">
					<td class="text-center">
						<input type="checkbox" name="ndId" value="${autoId}" <s:if test="status == 1">checked</s:if>/>
					</td>
					<td width="200px" style="text-align:center">
						${name}
					</td>
					<td colspan="2" style="text-align:center">
						${usedFor}
					</td>
					<td style="text-align:center">
						${important}
					</td>
				
				</tr>
				</s:iterator>
				
				<tr height=30px class="success">
					<th class="text-center"></th>
					<th class="text-center">设备名称</th>
					<th class="text-center" colspan="2">用途</th>
					<th class="text-center">重要程度</th>
					
				</tr>
				<s:iterator status="sd" value="sd">
				<tr height="40px">
					<td class="text-center">
						<input type="checkbox" name="sdId" value="${autoId}" <s:if test="status == 1">checked</s:if>/>
					</td>
					<td width="200px" style="text-align:center">
						${name}
					</td>
					<td colspan="2" style="text-align:center">
						${usedFor}
					</td>
					<td style="text-align:center">
					${important}
					</td>
					
					
				</tr>
				</s:iterator>
				
				<tr height=30px class="success">
					<th class="text-center"></th>
					<th class="text-center">姓名</th>
					<th class="text-center" colspan="2">岗位/角色</th>
					<th class="text-center">联系方式</th>
					
				</tr>
				<s:iterator status="rp" value="rp">
				<tr height="40px">
					<td class="text-center">
						<input type="checkbox" name="rpId" value="${autoId}" <s:if test="status == 1">checked</s:if>/>
					</td>
					<td width="200px" style="text-align:center">
						${name}
					<td colspan="2" style="text-align:center">
						${position}
					</td>
					<td style="text-align:center">
						${contact}
					</td>					
				</tr>
				</s:iterator>
		
				<tr height=30px class="success">
					<th class="text-center"></th>
					<th class="text-center" colspan="4">文档名称</th>
					
				</tr>
				<s:iterator status="mf" value="mf">
				<tr height="40px">
					<td class="text-center">
						<input type="checkbox" name="mfId" value="${autoId}" <s:if test="status == 1">checked</s:if> />
					</td>
					<td width="200px" colspan="4" style="text-align:center">
						${name}
					</td>				
				</tr>
				</s:iterator>
				</table>	
				<input type="hidden" name="url" value="Cp_3.jsp"/> 
				<input type="hidden" name="corId" value="${param.corId}"/>
				
				<s:submit type="button" class=" btn btn-warning" value="提交" method="submit"/>			
				</s:form>
				</center>
				<input type="button" value="后退" class=" btn btn-info" onclick="window.history.go(-1)" style ="margin-left:2.5%;margin-top:-40px">
				
		</div> 
		<div class="navbar-fixed-bottom container span12 ">
        <p class=" text-center ">&copy;中国科学技术大学信息安全测评中心&nbsp;&nbsp;&nbsp;&nbsp;地址：邮编：  <a href="http://itsec.ustc.edu.cn/contact.php">联系我们</a></p>
        <p class="text-center"></p>
		</div>
	</body>
</html>
