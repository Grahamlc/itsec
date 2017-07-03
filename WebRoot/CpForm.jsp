<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>USTC-ITSEC信息管理平台</title>
		<meta  http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<script  type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js" ></script>
		<link rel="shortcut icon" href="images/title.png" type="image/x-icon">
		<link href="login/style.css" rel="stylesheet" type="text/css" />
		<base target="_blank"/>	
		<script>
			function check(){
			var r=confirm('您确定要退出吗？');
			if (r==true)
			  {
			    return true;
			  }
			else
			  {
				return false;
			  }
		}
		</script>
		<style type="text/css">
			body {
			 margin: 0px;padding:0;
			 background-color:#eef3f7;
			}
			
			.all{margin-top:30px;}
			
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
			.table-bordered{}
			.my-table{width:95%;margin-left:auto;margin-right:auto;}
			.btn-info{color:#000 !important;}
		</style>
	</head>
	<body>

	   <div style="height:150px;background-color:#056eb0">
		<p style="margin-left:20px;padding-top:12px;color:#fff;font-weight:bold;font-size:20px;">中国科学技术大学信息安全测评中心管理平台</p>
		<p style="color:#fff;margin-left:20px;margin-top:-10px;font-size:13px;word-spacing:2px;">Management Platform of USTC Information Security Evaluation Center</p>
	
	<div class="topright">    
	    <ul>
	    <li><a href="showCompanys?url=guide.jsp">首页</a></li>
	    <li><a href="http://itsec.ustc.edu.cn">微博</a></li>
	    <li><a href="http://itsec.ustc.edu.cn">官网</a></li>
	    <li><a href="xgmm.jsp" target="right">修改密码</a></li>
	    <!-- <li><a href="Logout" onclick="return check()">退出</a></li>-->
	    <li><a href="Login!logout.action" onclick="return check()">退出</a></li>
	    </ul>
	     
	    <div class="user">
		    <span><c:out value="${user.tester.name}" default="您还没有登录"/></span>
		    <i></i>
	    </div>    
    </div>
	</div>
    <br/>
   
    	<div>
		<form action="submitResult" method="post">
		<input type="hidden" name="id" value="${param.id}"/> 
		<!-- 提交测评结果记录 -->
		<%request.setCharacterEncoding("utf-8"); %>	
			
			<table class="table table-striped my-table ">	
				<thead>
			
					<tr class="success">
					<th width="10%">测评对象</th>
					<th width="10%">分类</th>
					<th width="20%">结果</th>
					</tr>		
				
				</thead>
				<tbody>
				<tr>
					<s:iterator value="testObject.device" id="tod">
					<td>${deviceName}</td>
					</s:iterator>
					<s:iterator value="testObject.object">
					<td>${name}</td>
					</s:iterator>
					<td>
						<input class="input" type="text" name="LayResult" placeholder="'符合'/'基本符合'/'不符合'/'不适用'"/>
 					</td>
				</tr>
				</tbody>
			</table>	
			<table class="table table-bordered table-striped my-table">	
			<thead style="background-color:#CCC;">
				<tr height="60px" class="success">
				<th class="text-center">Index</th>
				<th class="text-center">等级</th>
				<th class="text-center">标准内编号</th>
				<th class="text-center">测评指标</th>
				<th class="text-center">测评项</th><th class="text-center">结果记录</th><th  class="text-center">结果判定</th>
				<th  class="text-center">弥补项</th>
				<th  class="text-center">备注</th>
				</tr>
				
			</thead>			
			<tbody>
				<s:iterator id="it" value="itemSelRes" status="i">
				
					<input type="hidden" id="nums" value="<s:property  value="#i.getCount()"/>"/>
					
					<tr <s:if test="notice == '不符合'">class="danger"</s:if> 
						<s:if test="notice == '部分符合'">class="warning"</s:if>
						<s:if test="notice == '不适用'">class="info"</s:if>
						<s:if test="notice == '符合'">class="success"</s:if>
					height="50px" >	
																
							<td width="2%"><s:property  value="#i.getIndex()"/></td>	
							<!--<td width="2%" >${autoId}</td> -->
							<input type="hidden" name="autoId" value="${autoId}"/>											
							<s:iterator value="#it.item" id="item">
							<td width="4%" >${leiBie}</td>
							<td width="8%" >${bianHao}</td>
							<td width="8%" >${cpZhBiao}</td>
							
							<td width="20%"name="">${cpxCon}</td>
							<td width="15%" >
								<input class="input" name="con<s:property value='#it.autoId'/>" value="${result}" placeholder="请填写测评结果" style="width: 380px; height: 48px"/>
							</td>
							<td width=5% name="result" >
							<!-- <input value = "1" type="radio" >符合
							<input value = "0.5" type="radio" >基本符合
							<input value = "0" type="radio" >不符合
							 
							 <select name="notice<s:property value='#it.autoId'/>" value="<s:property value='notice'/>">
							 	<option value="符合">符合</option>
							 	<option value="基本符合">基本符合</option>
							 	<option value="不符合">不符合</option>
							 	
							 </select>
							 -->
							 <input name="notice<s:property value='#it.autoId'/>" value="${notice}" placeholder="0-5" style="height: 46px; ">
							&nbsp;&nbsp;&nbsp;&nbsp;</td>
								
							<td width=20% >
								<select name="" >
							 		<option >弥补项</option>							 								 	
							 	</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							 	<button class="btn btn-info">我要提交</button>
							</td>	
							<td width="15%"><a class="btn-danger" href="#">帮助</a></td>					
						</s:iterator>
					</tr>
					</s:iterator>	<br>							
				<tr height="60px">
				<td colspan="9"><center><button class="btn	btn-info" type="submit">提交</button></center></td>
				
				</tr>
				</tbody>
			</table>
			
			</form>
			</div>
	</body>
</html>
