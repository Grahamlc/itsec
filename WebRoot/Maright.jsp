<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>USTC-ITSEC信息管理平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
		<script  type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js" ></script>
		<link rel="stylesheet" href="bootstrap/css/lanrenzhijia.css" media="all">
		<link rel="shortcut icon" href="images/title.jpg" type="image/x-icon">
		<style type="text/css">
			.ma{margin-top:40px;margin-left:0px;}
			
			.tc{position:absolute;top:70px;right:200px;}
			.menuson li{list-style:none;}
			.bg{background-color:blue;}
			
		</style>
	</head>
	<script language="javascript">
		$(function(){	
			//导航切换

			$('.title').click(function(){
				var $ul = $(this).next('ul');
				$('ul').slideUp();
				if($ul.is(':visible')){
					$(this).next('ul').slideUp();
				}else{
					$(this).next('ul').slideDown();
				}
			});
		})	
	</script> 
	<script type="text/javascript">
		function shanchu(){
			var r=confirm('您确定要删除该用户吗？');
			if (r==true)
			  {
			    return true;
			  }
			else
			  {
				return false;
			  }
		}
			/*$(function(){
				$("ul li:has(:checked)").addClass('bg');
				$("ul li").click(function(){
				var yy=$(this).hasClass('bg');
				if(yy){
					$(this).removeClass('bg').find(':input').attr('checked',false);
					}else{
					$(this).addClass('bg').find(':input').attr('checked',true);
					}
					});
				})
			*/
			function check(){
						
				var str ="";
				alert(str);
				for(var i=0; i<document.form1.elements.length;i++){
					if(document.form1.elements[i].checked){					
						str+=document.form1.elements[i].value+"/";
						alert(str);
					}
					else{
						str+="0/";
						alert(str);
					}
					
				}
			}
			function addrole(){
				
				document.getElementById("addrole").style.display="table-row";
			}
			function xiugai(){
				document.getElementById("tester").style.display="none";
				document.getElementById("updatetester").style.display="table";
				
			}
		</script>
	
	<body class="container-fluid">
	<c:if test="${role eq 5}">
		<div class="ma">
		<form action="delete!delete_system" method="post">
			<table class="table table-bordered table-striped">
				<thead>
					<tr height="30px">
						<th class="text-center">单位名称</th>
						<th class="text-center">系统</th>
						
					</tr>
				</thead>
				<tbody>
				
					<%request.setCharacterEncoding("utf-8"); %>
					<s:iterator id="com" value="companys">
					<tr>
						<td>${com.corName}</td>
						<td>
							<s:iterator value="#com.systems" id="sys">
							<input type="checkbox" name="sysIds" value="${sys.autoId}">${sys.sysName}<br/>
							</s:iterator>
						</td>
					</tr>
					</s:iterator>
					<tr class="text-center">
					<td colspan = "2">
						<button type="submit" class="btn btn-info">删除</button>
					</td>
					</tr>
					
				</tbody>
			</table>
			</form>
		</div>
		
		<div class="ma">
			<table  class="table table-bordered table-striped">
				<thead>
					<tr height="30px">
						<th class="text-center">用户单位</th>
						<th class="text-center">用户名</th>
						<th class="text-center">角色</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>
					<%--从服务器将值传入前端 
					存在中文字符乱码问题
					--%>
					<%request.setCharacterEncoding("utf-8"); %>
					<s:iterator id="u" value="users">
					<tr>
						<td class="text-center">${tester.company.corName}</td>
						<td class="text-center">${tester.name}</td>
						<td class="text-center">${level.name}</td>			
						<td class="text-center"><a href="xgmm.jsp" target="right">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;||&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete!delete_user.action?UserId=${autoId}" onclick="return shanchu()">删除</a></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		
		<div class="ma">
			<table id = "role_table"  class="table table-bordered table-striped">
				<thead>
					<tr height="30px">
						<!-- <th class="text-center">ID</th> -->
						<th class="text-center" width="20%">角色
						<button class="btn-info"  onclick="addrole()">添加</button>
						</th>
						<th class="text-center" width="50%">操作</th>
						<th class="text-center" width="30%">功能模块</th>
					</tr>
				</thead>
				<%request.setCharacterEncoding("utf-8"); %>
				<s:iterator id="r" value="roles">
				<s:if test="autoId != 5">
				<tr height=30px>		
					<td class="text-center">${r.name}</td>
					<td>
					<s:iterator id="mP" value="#r.menuPriv">
						${menu.name}\
					</s:iterator>
					</td>
					<td class="text-center">
						<a href="#" class="title">编辑</a>
						<!--  -->
						
						<ul class="menuson" style="display:none">
							<form action="super!editRole.action" method="post" id="form1">
							<input type="hidden" name="roleId" value="${r.autoId}"/>
							<input type="hidden" name="menues" id="dd"/>
							<s:iterator value="menues">
								<input type="checkbox" name="menu" value="${autoId}"/>${name}<br>
							</s:iterator>
							<input type="submit" onclick="return check()" value="确定" id="btn5">
							</form>	
													
						</ul>
						<script>
						/*
							$("#btn5").click(function(){
							var str="";
							$("[name='menu']:checked").each(function(){
							str+=$(this).val()+"/";
							})
							$("#dd").val(str)
							})
						*/
						
						</script>						
					</td>
				</tr>
				</s:if>
				</s:iterator>
				<form action="super!addRole" method="post">
				<tr id="addrole" style="display:none">
				
					<td><input type="text" name="roleName"/></td>
					<td></td>
					<td class="text-center">
						<!-- 
							<input type="hidden" name="roleId" value="${r.autoId}"/>
							<input type="hidden" name="menues" id="dd"/>
							<s:iterator value="menues">
								<input type="checkbox" name="menu" value="${autoId}"/>${name}<br>
							</s:iterator>
						-->			
							<input type="submit" onclick="return check()" value="确定" id="btn5">
					 
					</td>
					
					
				</tr>
				<tr>
				<td>
				
				</td>
				<td></td><td></td>
				</tr>
				
				</form>
			</table>
   		</div>		
		<div class="ma">
			<table class="table table-bordered table-striped">
				<thead>
					<tr height="30px">
						<th class="text-center">测评师</th>
						<th class="text-center">联系方式</th>
						<th class="text-center">邮箱</th>
						<th class="text-center"><button class="btn-info" onclick="xiugai()">编辑</button></th>
					</tr>
				</thead>
				<tbody id="tester">
					<%--从服务器将值传入前端 
					存在中文字符乱码问题
					--%>
					<%request.setCharacterEncoding("utf-8"); %>
					<s:iterator  value="testers">
					
					<tr>
						<td class="text-center">${name}</td>
						<td class="text-center">${pcont}</td>
						<td class="text-center">${mcont}</td>			
						
					</tr>
					</s:iterator>
				</tbody>
				
			</table>
			
			<form action="super!editTester" method="post">
				<table id="updatetester" style="display:none" class="table table-bordered table-striped">
				
				
					<s:iterator  value="testers">
					<tr>
					<input type="hidden" name="testerId" value="${userId}"/>
						<td><input type="text" name="name${userId}" value="${name}"/></td>
						<td><input type="text" name="pcont${userId}" value="${pcont}"/></td>
						<td><input type="text" name="mcont${userId}" value="${mcont}"/></td>
						<td><a href="delete!delete_tester.action?testerId=${userId}" onclick="return shanchu()">删除</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					</s:iterator>
					<tr><td colspan="2">
					<input type="submit" class="btn-info" value="保存"/>
					</td>
					<td colspan="1">
					<input type="button" class="btn-info" value="取消" onclick="window.history.go(-1)"/>
					</td></tr>
					
				</table>
				</form>
		</div>
		</c:if>
	</body>
</html>
