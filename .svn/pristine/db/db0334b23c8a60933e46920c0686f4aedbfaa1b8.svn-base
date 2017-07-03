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
</style>
<script type="text/javascript">
	function logo_in() {
		var bd = document.fm;
		var userid = bd.userid.value;
		if (userid == "") {
			alert("请输入您的工号/用户ID");
			return false;
		}
		var password = bd.password.value;
		if (password == "") {
			alert("请输入您的密码");
			return false;
		}
		var pswd = bd.pswd.value;
		if (password != pswd) {
			alert("两次密码输入不一致,请重新输入");
			return false;
		}
		var username = bd.username.value;
		if (username == "") {
			alert("请输入您的姓名");
			return false;
		}
		var officename = bd.officename.value;
		if (officename == "") {
			alert("请输入您的单位名称");
			return false;
		}

		var roleid = bd.roleid.value;
		if (roleid == "") {
			alert("请输入角色ID");
			return false;
		}
	}
</script>
<script>
	function changeFunc() {

		var selectBox = document.getElementById("role");
		var selectedValue = selectBox.options[selectBox.selectedIndex].value;
		//    alert(selectedValue);
		if (selectedValue == "1") {

			document.getElementById("Ccontact").style.display = "none";
			document.getElementById("Mcontact").style.display = "none";
			document.getElementById("corname").style.display = "table-row";
		} else {
			document.getElementById("corname").style.display = "none";
			document.getElementById("Ccontact").style.display = "table-row";
			document.getElementById("Mcontact").style.display = "table-row";
		}
	}
</script>
</head>
<body class="container-fluid">
	<div id="div2">
		<form name="fm" method="post" action="super!add_user.action">
			<table class="table table-striped table-bordered">
				<thead>
					<tr height="35px">
						<th colspan="2" class="text-center"><h4>添加用户</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>工号/用户ID:</td>
						<td><input name="userid" type="text"></td>
					</tr>
					<tr>
						<td>登录密码:</td>
						<td><input name="password" type="password"></td>
					</tr>
					<tr>
						<td>确认密码:</td>
						<td><input name="pswd" type="password"></td>
					</tr>
					<tr>
						<td>用户姓名:</td>
						<td><input name="username" type="text"></td>
					</tr>
					<tr>
						<td>角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色:</td>
						<td><select id="role" name="roleid"
							style="width: 176px; height:30px" onchange="changeFunc();">
								<option value="1">客户</option>
								<option value="2">商务</option>
								<option value="3">主任</option>
								<option value="4">测评师</option>
						</select></td>
					</tr>
					<tr height="30px" id="corname">
						<td>单位 名称:</td>
						<td>
							<!-- <input name="officename" type="text"> --> <select
							name="officename" style="width: 176px; height:30px">
								<s:iterator value="companys">
									<option value="${corId}">${corName}</option>
								</s:iterator>
						</select>
						</td>
					</tr>
					<tr height="30px" id="Ccontact" style="display:none">
						<td>联系方式:</td>
						<td><input name="telephone" type="text"></td>
					</tr>
					<tr id="Mcontact" style="display:none">
						<td>电子邮箱:</td>
						<td><input name="email" type="text"></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit" value="添加"
							onClick="return logo_in()" class="btn btn-info"
							style=" margin-left:300px;"> <input type="reset"
							value="重置" class="btn btn-info" style="margin-left:200px;">
							<input type="button" class="btn btn-info" value="取消"
							onclick="window.history.go(-1)" style="margin-left:200px;"></a>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>
