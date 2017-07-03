<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>USTC-ITSEC信息管理平台</title>
<link rel="shortcut icon" href="images/title.jpg" type="image/x-icon";>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="jqueryw.js"></script>
<style type="text/css">
.my-table{width:50%;}
</style>


</head>
<body class="container-fluid">
<br><br>
	<div id="div2">
		<form method="post" action="startTest!setManager">
		<input type="hidden" name="testSysId" value="${param.testSysId}"/>
		<input type="hidden" name="proId" value="${param.proId}"/>
		<input type="hidden" name="backUrl" value="${param.backUrl}"/>
			<table class="table table-striped my-table">
				<thead>
					<tr height="40px" class="success">
						<th colspan="2" class="text-center"><h4>指派项目经理</h4></th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="manager">
					<tr class="info"><td>该项目经理是：</td><td>${name}</td></tr>
				</s:iterator>
				<s:iterator value="testers">
					<tr>
						<td><input type="radio" name="userId" value="${userId}"<s:if test="userId == managerId">checked</s:if>></td>
						<td><h4>${name}</h4></td>
					</tr>
				</s:iterator>
				<tr>
					<td><button type="submit" class="btn btn-warning">指派</button></td>
					<td>
					<input type="button" value="后退" class=" btn btn-info" onclick="window.history.go(-1)">
					
					</td>
				</tr>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>
