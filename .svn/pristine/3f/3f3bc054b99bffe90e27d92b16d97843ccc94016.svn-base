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
	</head>
	<body class="container-fluid">
	<br><br>
		<div class="row"  style="margin-left:40px;">
			<button class="btn btn-info">信息调查表模板</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span><img src="images/xxdc.png" /></span><a href="showInformation?corId=${param.corId}&url=Information.jsp" target="right">信息调查表</a>
			
			
		</div>
				
				 <s:form id="form1" name="form1" action="roleFileUpload" method="post" enctype="multipart/form-data" theme="simple">
    			<div>
    			<input type="hidden" name="proId" value="${param.corId}"/>
				<table class="table table-bordered my-table">
	 				 <thead>
	 				 <tr class="success" height="50px">
					    <th>文件上传</th>
					  </tr>
					  </thead>
					  <tbody>
					  <tr>
					    <td>
					      <s:file name="upFile" label="文件位置" size="80"/>
					    </td>
					  </tr>
					  <tr>
					    <td colspan="99" align="right">
						<s:submit class="btn btn-warning" value="上传"/>
						<s:reset class="btn btn-info" value="重置"/>
					    </td>
					  </tr>
					  </tbody>
				      </table>
					</div>
				    </s:form>
		

		<div class="modal fade" id="newPro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	 <form action="addProject" method = "post">
	   	<div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            创建单位信息
	         </div>	        	
		     <div class="modal-body">		    			
				<table class="table table-bordered">
				<tr height="40px">
					<td style="text-align:center" width="15%">单位名称</td>
					<td width="40%"><input type="text" name = "corName"></td>
					<td>所属地市</td>
					<td>
						<select name="area">
							<option value="合肥">合肥市</option>
							<option value="芜湖">芜湖市</option>
							<option value="安庆">安庆市</option>
							<option value="铜陵">铜陵市</option>
							<option value="宿州">宿州市</option>
							<option value="六安">六安市</option>
							<option value="黄山">黄山市</option>
							<option value="池州">池州市</option>
							<option value="蚌埠">蚌埠市</option>
						</select>
					</td>
				</tr>
				<tr height="40px">
					<td style="text-align:center"height="32px">单位地址</td>
					<td><input type="text" name = "corAdd"></td>
					<td style="text-align:center">邮政编码</td>
					<td><input type="text" name = "postId" ></td>
				</tr>
				<tr height="120px">
					<td height="90px" style="text-align:center"height="32px">联系人</td>
					<td  colspan="3">
						<table style="margin-left:40px">
							<tr>
								<td width="300px">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
									<input type="text"  class = "input-large" style="height:24px;" name = "connUser">
								</td>
								<td>职务/职称<input type="text"  class = "input-large" style="height:24px;" name="userTitle"></td>
							</tr>
							<tr>
								<td>所属部门<input type="text"  class = "input-large" style="height:24px;" name="userBm"></td>
								<td>办公电话&nbsp;<input type="text"  class = "input-large" style="height:24px;" name="corTel"></td>
							</tr>
							<tr>
								<td>移动电话<input type="text"  class = "input-large" style="height:24px;" name = "connPhon"></td>
								<td>电子邮件&nbsp;<input type="text"  class = "input-large" style="height:24px;" name="connMail"></td>
							</tr>
						</table>
					</td>
				</tr>	
			</table>				
			 </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭
		            </button>
		            <button type="submit" class="btn btn-success">
		         	      新建	
		            </button>
		         </div>	         
	      </div>
	</div>
	</form>
</div>
<input type=button class="btn btn-info" value="后退" onclick="window.history.go(-1)" style ="margin-left:2.5%;margin-top:50px">
	<div class="modal fade" id="changePass" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	 <form action="changePass" method = "post" name="changePass">
	   	<div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            修改密码
	         </div>	        	
		     <div class="modal-body">		    			
				<table>
					<input type="hidden" value="${session.user.userId}" name="userId"/>	
					<tr>
					<td><b>当前密码</b></td>
					<td>
						<input type="text" name="oldPass" />
					</td>
					<tr>
					<tr>
					<td><b>新密码</b></td>
					<td>
						<input type="text" name="newPass" />
					</td>
					<tr>
					<tr>
					<td><b>确认密码</b></td>
					<td>
						<input type="text" name="checkPass" />
					</td>
					<tr>
				</table>				
			 </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭
		            </button>
		            <button type="submit" class="btn btn-success" onClick="return check()">
		         	      确认	
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
