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
			.my-table{width:95%;margin-left:auto;margin-right:auto;}
		</style>
		<script>
			function xiugai(){
				document.getElementById("company").style.display="none";
				document.getElementById("updatecompany").style.display="block";
				
			}
		</script>
	</head>
	<body class="container-fluid">
	<br><br>
	
		<div id="company">
		
				<s:iterator id="com" value="companys">
				<table class="table table-bordered table-striped my-table">
				<thead>
					<tr height="50px" class="success">
						<th colspan="4" class="text-center"><b>单位信息</b></th>
					</tr>
				</thead>
				<tbody>
					<tr height="40px">
						<td  class="text-center"><b>单位名称</b></td>
						<td>${com.corName}</td>
						<td class="text-center"><b>所属地市</b></td>
						<td>
							${com.area}
						</td>
					</tr>
					<tr height="40px">
						<td class="text-center"><b>单位地址</b></td>
						<td>${com.corAdd}</td>
						<td class="text-center"><b>邮政编码</b></td>
						<td>${com.postCode}</td>
					</tr>
					<tr height="180px">
						<td height="90px"  class="text-center"><b>联系人</b></td>
						<td  colspan="3">
							<table style="width:80%;background-color:#eef3f7;" class="table table-bordered table-striped">
								<tr height="60px">
									<td class="text-center"><b>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</b></td>
									<td>${com.connUser}</td>
									<td  class="text-center"><b>职务/职称</b></td><td>${com.userTitle}</td>
								</tr>
								<tr height="60px">
									<td  class="text-center"><b>所属部门</b></td><td>${com.userBm}</td>
									<td class="text-center"><b>办公电话&nbsp;</b></td><td>${com.corTel}</td>
								</tr>
								<tr height="60px">
									<td class="text-center"><b>移动电话</b></td><td>${com.connPhon}</td>
									<td class="text-center"><b>电子邮件&nbsp;</b></td><td>${com.connMail}</td>
								</tr>
							</table>
						</td>
					</tr>	
				</tbody>
				</table>
			</s:iterator>
				<br>
				<input type=button class="btn btn-info" value="后退" onclick="window.history.go(-1)" style ="margin-left:2.5%;">
				<c:if test="${role eq 2 or role eq 3}">
				<button class="btn btn-warning" style ="margin-left:70%;" onclick="xiugai()">编辑</button>
				</c:if>
				
		
			
			
		</div>
	
		<div id="updatecompany" style="display:none;">
			
			<form action="editCompany" method = "post">
				<s:iterator id="com" value="companys">
				<input type="hidden" name="corId" value="${com.corId}" />
				<table class="table table-bordered my-table">
				<thead>
					<tr height="50px" class="success">
						<th colspan="4" class="text-center"><b>单位信息</b></th>
					</tr>
				</thead>
				<tbody>
					<tr height="40px">
						<td  class="text-center">单位名称</td>
						<td><input type="text" value="${com.corName}" class="input-large" name = "corName"></td>
						<td class="text-center">所属地市</td>
						<td>
							<input name="area" value="${com.area}"/>
						</td>
					</tr>
					<tr height="40px">
						<td class="text-center">单位地址</td>
						<td><input type="text" value="${com.corAdd}" class = "input-large" name = "corAdd" ></td>
						<td class="text-center">邮政编码</td>
						<td><input type="text" value="${com.postCode}" class = "input-large" name = "postId" ></td>
					</tr>
					<tr height="180px">
						<td height="90px"  class="text-center">联系人</td>
						<td  colspan="3">
							<table style="width:80%;">
								<tr height="60px">
									<td class="text-center">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
										<input type="text" value="${com.connUser}"  class = "input-large" style="height:24px;" name = "connUser">
									</td>
									<td  class="text-center">职务/职称<input type="text" value = "${com.userTitle}" class = "input-large" style="height:24px;" name="userTitle"></td>
								</tr>
								<tr height="60px">
									<td  class="text-center">所属部门<input type="text" value="${com.userBm}" class = "input-large" style="height:24px;" name="userBm"></td>
									<td class="text-center">办公电话&nbsp;<input type="text" value="${com.corTel}"  class = "input-large" style="height:24px;" name="corTel"></td>
								</tr>
								<tr height="60px">
									<td class="text-center">移动电话<input type="text" value="${com.connPhon}" name = "connPhon"></td>
									<td class="text-center">电子邮件&nbsp;<input type="text" value="${com.connMail}" name="connMail"></td>
								</tr>
							</table>
						</td>
					</tr>	
				</tbody>
				</table>
			</s:iterator>
				<br>
				<input type=button class="btn btn-info" value="后退" onclick="window.history.go(-1)" style ="margin-left:2.5%;">
				<c:if test="${role eq 2 or role eq 3}">
				<button class="btn btn-warning" class="submit" style ="margin-left:70%;">修改</button>
				</c:if>
				
			</form>
			
			
		</div>

	
		<div class="navbar-fixed-bottom container span12 ">
        <p class=" text-center ">&copy;中国科学技术大学信息安全测评中心&nbsp;&nbsp;&nbsp;&nbsp;地址：邮编：  <a href="http://itsec.ustc.edu.cn/contact.php">联系我们</a></p>
        <p class="text-center"></p>
		</div>
	</body>
</html>
