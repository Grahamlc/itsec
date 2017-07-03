<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <head>
		<title>USTC-ITSEC信息管理平台</title>
		<link rel="shortcut icon" href="images/title.jpg" type="image/x-icon";>
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
		<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/jqueryw.js"></script>
		<style type="text/css">
			body {
			 margin: 0px;padding:0;
			 background-color:#eef3f7;
			}
			.djcpb{font-family:黑体;
				font-size:20px;
				margin-bottom:10px;
				margin-top:5px;
				margin-top:20px;
			}
			table{height:30px;background-color:white;font-size:15px;}
			input{height:24px;width:160px;margin:5px 10px;}
			input.tj{height:25px;line-height:20px;width:55px;}
			input.jiachang{width:330px;}
			select{margin-left:10px;width:100px;height:24px;}
			.tjia{width:50px;height:23px;line-height:10px;}
			.small{background-color:#fff;font-size:15px;}
			.text{text-align:center;}
			.sc{margin-left:-78px;}
			.top{border-top:1px solid #7d7d7d;}
			.bottom{border-bottom:1px solid #7d7d7d;}
			.right{border-right:1px solid #7d7d7d;}
			.big{width:772px;}
			a{color:#2b2a2f;}
			a:hover{color:black;}
		</style>
		<script type="text/javascript">
			function add(){
				var tmp = '';
				tmp += '<table class="small"><tr><td class="text top bottom right" width="109px">系统名称</td><td class="top bottom right"><input type="text" class="jiachang"></td><td class="text top bottom right" width="110px">安全保护等级</td><td width="200px" class="top bottom"><select  class = "select sc"><option>一级</option><option>二级</option><option>三级</option><option>四级</option><option>五级</option></select></td></tr><tr><td class="text right">备案证明编号</td><td class="right"><input type="text" class="jiachang"></td><td class="text right">测评结果</td><td class=""><select  class = "select sc"><option>不符合</option><option>基本符合</option><option>符合</option></select></td></tr></table>';
				$('#tb').append(tmp);
			}
  </script>
	</head>
	<body class="container-fluid">
		<center><form method="post" action="#"><div class="djcpb">信息系统等级测评基本信息表</div>
		<table border="1px solid #7d7d7d;"class="big">
			<tr height="35px">
				<td colspan="4" style="background:url(images/th.gif) repeat-x;text-align:center"><b>被测单位</b></td>
			</tr>
			<tr height="40px">
				<td style="text-align:center">单位名称</td>
				<td colspan="3"><input type="text" class="input-large jiachang"></td>
			</tr>
			<tr height="40px">
				<td style="text-align:center"height="32px">单位地址</td>
				<td><input type="text" class = "input-large jiachang"></td>
				<td style="text-align:center">邮政编码</td>
				<td><input type="tel" class = "input-large" ></td>
			</tr>
			<tr height="120px">
				<td height="90px" style="text-align:center"height="32px">联系人</td>
				<td  colspan="3"><table style="margin-left:40px"><tr><td width="300px">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名<input type="text"  class = "input-large" style="height:24px;"></td>
					<td>职务/职称<input type="text"  class = "input-large" style="height:24px;"></td></tr>
					<tr><td>所属部门<input type="text"  class = "input-large" style="height:24px;"></td>
					<td>办公电话&nbsp;<input type="text"  class = "input-large" style="height:24px;"></td></tr>
					<tr><td>移动电话<input type="text"  class = "input-large" style="height:24px;"></td>
					<td>电子邮件&nbsp;<input type="text"  class = "input-large" style="height:24px;"></td></tr></table>
				</td>
			</tr>
			<tr height="35px">
				<td colspan="4" style="background-color:#8acf52; text-align:center" id="tb"><b>被测信息系统</b><input type="button" value="添加" class="tjia" onclick="add()"></td>
			</tr>
			<tr height="40px">
				<td style="text-align:center" width="110px">系统名称</td>
				<td width="200px"><input type="text" class = "input-large jiachang"></td>
				<td style="text-align:center" width="110px">安全保护等级</td>
				<td><select  class = "input-large">
						<option>一级</option>
						<option>二级</option>
						<option>三级</option>
						<option>四级</option>
						<option>五级</option>
					</select>
				</td>
			</tr>
			<tr height="40px">
				<td style="text-align:center" height="32px">备案证明编号</td>
				<td ><input type="text"  class = "input-large jiachang" ></td>
				<td style="text-align:center">测评结果</td>
				<td ><select  class = "input-large">
						<option>不符合</option>
						<option>基本符合</option>
						<option>符合</option>
					</select>
				</td>
			</tr>
			<tr height="35px">
					<td colspan="4" style="background-color:#8acf52; text-align:center"><b>项目人员分配</b></td>
				</tr>
				<tr height="40px">
					<td style="text-align:center">项目经理</td>
					<td colspan="3"><input type="text" class="input-large"></td>
				</tr>
				<tr style="height:80px">
					<td style="text-align:center">测评人员</td>
					<td colspan="3"><table style="margin-left:10px"><tr>
					<td>主&nbsp;&nbsp;&nbsp;&nbsp;机<input type="text" class="input-large"></td>
					<td>管理<input type="text" class="input-large"></td>
					<td>应用<input type="text" class="input-large"></td></tr>
					<tr><td>数据库<input type="text" class="input-large"></td> 
					<td>物理<input type="text" class="input-large"></td> 
					<td>网络<input type="text" class="input-large"></td></tr></table>
					</td>
				</tr>
				
				<tr height="35px">
					<td colspan="4" style="background-color:#8acf52; text-align:center"><b>测评单位</b></td>
				</tr>
			<tr height="40px">
				<td style="text-align:center"height="32px">单位名称</td>
				<td ><input type="text" class="jiachang"></td>
				<td style="text-align:center" height="32px">单位代码</td><td><input type="text" style="height:24px;"></td>
			</tr>
			<tr height="40px">
				<td style="text-align:center">单位地址</td>
				<td ><input type="text" class="jiachang"></td>
				<td style="text-align:center">邮政编码</td><td><input type="tel"  class = "input-large" style="height:24px;"></td>
			</tr>
			<tr height="120px">
				<td height="90px" style="text-align:center">联系人</td>
				<td  colspan="3"><table style="margin-left:40px"><tr><td width="300px">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名<input type="text"  class = "input-large" ></td>
					<td>职务/职称<input type="text"  class = "input-large" style="height:24px;"></td></tr>
					<tr><td>所属部门<input type="text"  class = "input-large" style="height:24px;"></td>
					<td>办公电话&nbsp;<input type="text"  class = "input-large" style="height:24px;"></td></tr>
					<tr><td>移动电话<input type="text"  class = "input-large" style="height:24px;"></td>
					<td>电子邮件&nbsp;<input type="text"  class = "input-large" style="height:24px;"></td></tr></table>
				</td>
			</tr>
			<tr height="120px">
				<td height="90px" style="text-align:center">审核标准</td>
				<td colspan="3"><table style="margin-left:40px"><tr><td width="300px">编制人<input type="text"  class = "input-large" style="height:24px;"></td>
				<td>编制日期<input type="text" class="input-large" style="height:24px;"></td></tr>
				<tr><td>审核人<input type="text" style="height:24px;"></td>
				<td>审核日期<input type="text"  class = "input-large"style="height:24px;"></td>
				<tr><td>批准人<input type="text"  class = "input-large" style="height:24px;"></td>
				<td>批准日期<input type="text"style="height:24px;"></td></tr></table></td>
			</tr>
		</table></form></center><br />
		<center><form  method="post" action="#">
		<input type="submit" value="添加" id ="xinzeng" class="tj" />
		<a href="swright.html"><input type="submit" value="取消" id="yichu" class="tj"/></a>
		</center>
	</body>
</html>
