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
			.my-table{width:95%;}
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
			.big{width:772px; margin-top:100px}
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
	<br><br>
		
			<!-- 如何获取到当前的单位ID，然后根据这个Id新建系统  -->
			
			<form method="post" action="/itsecProject/addSystem?id=4">
			<input type="hidden" name = "corId" value="${param.id}"/>
			
				<table class="table table-bordered my-table">
				<thead>
				<tr  class="success" height="50px">
					<th colspan="4" class="text-center"><h4>添加信息系统</h4></th>
				</tr>
				</thead>
				<tbody>
				<tr height="40px">
					<td style="text-align:center" width="110px">系统名称</td>
					<td width="200px"><input type="text" class = "input-large jiachang" name="sysName"></td>
					<td style="text-align:center" width="110px">安全保护等级</td>
					<td><select  class = "input-large" name="secLevel">
							<option value="一级">一级</option>
							<option value="二级">二级</option>
							<option value="三级">三级</option>
							<option value="四级">四级</option>
							<option value="五级">五级</option>
						</select>
					</td>
				</tr>
				<tr height="40px">
					<td style="text-align:center" height="32px">备案证明编号</td>
					<td ><input type="text"  class = "input-large jiachang" name="backId"></td>
					<td style="text-align:center">等级组合</td>
					<td >
						<select name="sLevel">
					
					<option value="S1">S1</option>
					<option value="S2">S2</option>
					<option value="S3">S3</option>
					<option value="S4">S4</option>
					<option value="S5">S5</option>
					
				</select>				
				<select name="gLevel">
					<option value="G1">G1</option>
					<option value="G2">G2</option>
					<option value="G3">G3</option>
					<option value="G4">G4</option>
					<option value="G5">G5</option>
					
				</select>	
				<select name="aLevel">
					
					<option value="A1">A1</option>
					<option value="A2">A2</option>
					<option value="A3">A3</option>
					<option value="A4">A4</option>
					<option value="A5">A5</option>
					
				</select>
					</td>
				</tr>
				</tbody>
			</table>
		
		<br />
		
		<input type="hidden" name="url" value="Cp_1.jsp"/>
		<input type="submit" class="btn btn-warning" value="添加" style="margin-left:2.5%; height:40px"/>
		<input type=button class="btn btn-info" value=后退 style="margin-left:50%;height:40px" onclick="window.history.go(-1)">
		
		</form>
		
		
	</body>
</html>
