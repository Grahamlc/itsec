<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>USTC-ITSEC信息管理平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
		<script  type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js" ></script>
		<link rel="shortcut icon" href="images/title.png" type="image/x-icon">
		<base target="_blank"/>	
		<base href="<%=basePath%>">
		<script type="text/javascript">
			function getTab(mm){
				for(var i=1;i<=5;i++){
					if(i==mm){
						document.getElementById("d" +mm).style.display="block";
					}else{
						document.getElementById("d" +i).style.display="none";	
					}
				}
			}
		</script>
		<style type="text/css">
			body{background-image:url("images/wood.jpg");background-repeat:repeat;}
			.all{margin-top:30px;}
			.bt button{width:170px;height:80px;margin-top:30px;}
			.topright{height:88px;float:right;margin-top:-70px;}
			.topright ul{padding-top:15px; float:right; padding-right:12px;list-style:none;}
			.topright ul li{float:left; padding-left:9px; padding-right:9px; background:url(images/line.gif) no-repeat right;}
			.topright ul li:last-child{background:none;}
			.topright ul li a{font-size:13px; color:#e9f2f7;}
			.topright ul li a:hover{color:#fff;}
			.topright ul li span{margin-top:2px;float:left;padding-right:3px;}
			.user{height:30px;background:url(images/ub1.png) repeat-x;clear:both;margin-top:10px;float:right; margin-right:20px;border-radius:30px; behavior:url(js/pie.htc); white-space:nowrap;position:relative;}
			.user span{display:inline-block;background:url(images/user.png) no-repeat 15px 10px; line-height:30px; font-size:14px;color:#b8ceda; padding-left:20px; padding-left:35px;}
			.user i{display:inline-block;margin-right:15px;font-style:normal;line-height:30px; font-size:14px;color:#b8ceda;}
			.my-table{width:800px;margin-left:auto;margin-right:auto;}
			.modal-dialog{width:1000px;}
		</style>
</head>
<body class="container-fliued">
	<div style="height:150px;background-color:#056eb0">
		<p style="margin-left:20px;padding-top:12px;color:#fff;font-weight:bold;font-size:20px;">中国科学技术大学信息安全测评中心管理平台</p>
		<p style="color:#fff;margin-left:20px;margin-top:-10px;font-size:13px;word-spacing:2px;">Management Platform of USTC Information Security Evaluation Center</p>
		<div class="col-lg-6" style="margin-top:20px;">
							<div class="input-group">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">搜索条件&nbsp;<span class="caret"></span></button>
									
									<ul class="dropdown-menu">
										<li><a href="#">被测单位</a></li>
										<li><a href="#">项目时间</a></li>
										<li><a href="#">测评对象</a></li>
									</ul>
								</div>
								<input type="text" class="form-control">
							</div>
		</div>
					<span style="margin-top:25px;"><a href="#"><img src="images/tb5.png" /></a></span>
	
	<div class="topright">    
	    <ul>
	    <li><a href="showCompanys?url=guide.jsp">首页</a></li>
	    <li><a href="http://itsec.ustc.edu.cn">微博</a></li>
	    <li><a href="http://itsec.ustc.edu.cn">官网</a></li>
	    <li><a data-toggle="modal" data-target="#changePass">修改密码</a></li>
	    <!-- <li><a href="Logout" onclick="return check()">退出</a></li>-->
	    <li><a href="Login!logout.action" onclick="return check()" target="_self">退出</a></li>
	    </ul>
	     
	    <div class="user">
		    <span><c:out value="${user.tester.name}" default="您还没有登录"/></span>
		    <i></i>
	    </div>    
    </div>
	</div>
	
	
	
	 <div class="text-center bt">
	 		<button class="btn btn-info" onclick="getTab(4)"><img src="images/tb4.png" /><b>漏洞信息</b></button>
	 		&nbsp;&nbsp;&nbsp;&nbsp;
	 	<c:if test="${role eq 2 or role eq 3}">
			<button class="btn btn-info" onclick="getTab(1)"><img src="images/tb1.png" /><b>客户单位</b></button>
			&nbsp;&nbsp;&nbsp;&nbsp;
		
			<button class="btn btn-info" onclick="getTab(2)"><img src="images/tb2.png" /><b>所有项目</b></button>
			&nbsp;&nbsp;&nbsp;&nbsp;
		</c:if>
			<button class="btn btn-info" onclick="getTab(5)"><img src="images/tb4.png" /><b>测评工作</b></button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			
			<button class="btn btn-info" onclick="getTab(3)"><img src="images/tb3.png" /><b>测评指导</b></button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			
			
	 </div>
		<div class="text-center all">
			<div id="d1" style="display:none">
					<table class="table table-striped my-table " >
						<thead>
							<tr>
							<th>#</th>
							<th class="text-center">单位名称</th>
							<th class = "text-center">项目编号
							<button data-toggle="modal" data-target="#newCompany" class="btn btn-info">
				 				<span><img src="images/t01.png"></span>新建单位
							</button>
							<button data-toggle="modal" data-target="#newProjectNum" class="btn btn-info">
				 				<span><img src="images/t01.png"></span>申请编号
							</button>
							</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator id="com" value="companys" status = "st">
						<tr>
							<td><s:property value="#st.count" /></td>
							<td  class="text-center"><a href="Welcome.jsp?corId=${com.corId}">${com.corName}</a></td>
							<td  class="text-center">2016-0000</td>
							</tr>
						</s:iterator>
						</tbody>
					</table>
					<div>
						<ul class="pagination pagination-sm">
							<li class="disabled"><a href="#">&laquo;</a></li>
							<li class="active"><span>1<span class="sr-only">(current)</span></span></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
					</div>
			</div>
			<div id="d2"  style="display:none;">
				<table class="table table-striped my-table">
					<thead>
						<tr><th class="text-center">#</th><th class="text-center">单位名称</th><th>日期</th>
						<th class = "text-right">
							<button data-toggle="modal" data-target="#newProject" class="btn btn-info">
				 				<span><img src="images/t01.png"></span>新建项目
							</button>
							</th>
						</tr>
					</thead>
					<tbody>
					<s:iterator id="allPro" value="allProjects" status="project">
						<tr>
							<td><s:property value="#project.count" /></td>
							
							<!-- <a href="Main.jsp?corId=${allPro.company.corId}"> -->
							
							<td><a href="Main.jsp?proId=${allPro.autoId}">${allPro.company.corName}</a> </td>
							<td>${allPro.date}</td>
						</tr>
					</s:iterator>
					</tbody>
				</table>
				<div>
						<ul class="pagination pagination-sm">
							<li class="disabled"><a href="#">&laquo;</a></li>
							<li class="active"><span>1<span class="sr-only">(current)</span></span></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
					</div>
			</div>
				
			<div id="d3" style="display:none;">
				<table class="table table-striped my-table">
					<thead>
						<tr><th class="text-center">#</th><th class="text-center">设备</th><th class="text-center">日期</th></tr>
					</thead>
					<tbody>
						<tr><td>1</td><td><a href="#">XXXXXXXXXXXXXXX 路由器1</a></td><td>2015-06-07</td></tr>
						<tr><td>2</td><td><a href="#">XXXXXXXXXXXXXXX 交换机2</a></td><td>2015-06-07</td></tr>
						<tr><td>3</td><td><a href="#">XXXXXXXXXXXXXXX 防火墙3</a></td><td>2015-06-07</td></tr>
						<tr><td>4</td><td><a href="#">XXXXXXXXXXXXXXX 操作系统4</a></td><td>2015-06-07</td></tr>
						<tr><td>5</td><td><a href="#">XXXXXXXXXXXXXXX LINUX 5</a></td><td>2015-06-07</td></tr>
						<tr><td>6</td><td><a href="#">XXXXXXXXXXXXXXX 物理6</a></td><td>2015-06-07</td></tr>
						<tr><td>7</td><td><a href="#">XXXXXXXXXXXXXXX 网络全局7</a></td><td>2015-06-07</td></tr>
					</tbody>
				</table>
				<div>
						<ul class="pagination pagination-sm">
							<li class="disabled"><a href="#">&laquo;</a></li>
							<li class="active"><span>1<span class="sr-only">(current)</span></span></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
					</div>
			</div>
				<div class="clear"></div>
	
			<div id="d4" style="display:block;">
				<table class="table table-striped my-table">
						<thead>
							<tr><th class="text-center">最新安全事件</th><th class="text-center">漏洞资讯</th></tr>
						</thead>
						<tbody>
						<tr><td><a href="#">#</a></td><td>#</td></tr>
						<tr><td><a href="#">#</a></td><td>#</td></tr>
						<tr><td><a href="#">#</a></td><td>#</td></tr>
						<tr><td><a href="#">#</a></td><td>#</td></tr>
						<tr><td><a href="#">#</a></td><td>#</td></tr>
						</tbody>
					</table>
					<div>
						<ul class="pagination pagination-sm">
							<li class="disabled"><a href="#">&laquo;</a></li>
							<li class="active"><span>1<span class="sr-only">(current)</span></span></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
					</div>
			</div>
			<div id="d5" style="display:none;">
			
					<table class="table table-striped my-table">
						<thead>
							<tr>
							<th>#</th>
							<th>被测单位------------------被测系统</th></tr>
						</thead>
						<tbody>
						
						<%request.setCharacterEncoding("utf-8"); %>
						<s:iterator id="tos" value="#session.user.tester.testerToSystem" status = "tostatus">	
									
						<tr>
							<td><s:property value="#tostatus.count" /></td>
							<td><a href="Myjob.jsp?testSysId=${tos.testSys.autoId}">${tos.testSys.project.company.corName}---------------${tos.testSys.system.sysName}</a></td>
						</tr>
						
						</s:iterator>
						 
						 <tr><td></td></tr>
						</tbody>
					</table>
					<div>
						<ul class="pagination pagination-sm">
							<li class="disabled"><a href="#">&laquo;</a></li>
							<li class="active"><span>1<span class="sr-only">(current)</span></span></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
					</div>
			</div>
		</div>
		
		<!-- 创建新的单位 -->
		<div class="modal fade" id="newCompany" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	 <form action="addCompany" method = "post">
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
<!-- 申请项目编号 -->
<div class="modal fade" id="newProjectNum" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	 <form action="GetProNumbers" method = "post">
	   	<div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	         	   申请项目编号
	         </div>	        	
		     <div class="modal-body">		    			
				<table class="table table-bordered">
				<tr height="40px">
					<td style="text-align:center" width="15%">编号个数：</td>
					 
					<td><input type="text" pattern="[1-9]"> <p class="mark">注*输入值必须是 0 与 9 之间的数字</p></td>
				</tr>
				<tr height="40px">
					<td style="text-align:center" width="15%">申请备注：</td>
					 
					<td><textarea name="comment" rows="5" cols="100" required ></textarea></td>
				</tr>	
				
			</table>				
			 </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default"  data-dismiss="modal">关闭
		            </button>
		            <button type="submit" class="btn btn-success">
		         	    确认申请	
		            </button>
		            <input type="hidden" name="responsor" value="${user.tester.userId}"/>
		         </div>	         
	      </div>
	</div>
	</form>
</div>


<!-- 新建测评项目 派发任务单 -->
<div class="modal fade" id="newProject" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	 <form action="newProject" method = "post">
	   	<div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            	派发任务单
	         </div>	
	               	
		     <div class="modal-body">
		   		<input type="hidden" name="responsor" value="${user.tester.userId}"/>
			     <s:iterator id="com" value="companys" status = "st">	
			     <dd>  	
				    <div class="title">
						<b>
						<input type="checkbox" name="corId" value="${corId}"  />
						<s:property value="#st.count" />${corName}
						</b>
					    		
				    </div>
			    	 
			    </dd>	
			    </s:iterator>    
			    <hr/>			
				<a>更多---</a>
			 </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" 
	               data-dismiss="modal">取消
	            </button>
	            <button type="submit" class="btn btn-success">
	         	  派发	任务单
	            </button>
	         </div>	         
	      </div>
	</div>
	</form>
</div>
<div class="modal fade" id="changePass" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	<form action="changePass" method = "post" name="changePass">
	   	<div class="modal-dialog">
	      <div class="modal-content">
	               	
		     <div class="modal-body">		    			
				<table class="table table-bordered">
					<input type="hidden" value="${session.user.userId}" name="userId"/>	
					<tr>
					<td><b>当前密码</b></td>
					<td>
						<input type="password" name="oldPass" />
					</td>
					
					<td><b>新密码</b></td>
					<td>
						<input type="password" name="newPass" />
					</td>
					
					<td><b>确认密码</b></td>
					<td>
						<input type="password" name="checkPass" />
					</td>
					<tr>
				</table>	
				<button type="button" class="btn btn-default" data-dismiss="modal">
					关闭
		         </button>
		         <button type="submit" class="btn btn-success"">
		         	      确认	
		         </button>			
			 </div>
		                
	      </div>
	</div>
	</form>
</div>	
</body>
</html>