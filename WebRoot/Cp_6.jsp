<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <base target="_blank"/> 
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
			 .nav button.selected{background:url(images/navbg.png) no-repeat;}
			.nav button:hover{display:block;background:#000;color:#fff;background: none repeat scroll 0% 0% rgb(43, 127, 181);}
			.nav {float:left;}
			.object {float: right; margin-top: 100px}
			
			}
		</style>
		<script type="text/javascript">
			function shanchu(){
			var r=confirm('您确定要删除吗？');
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
		<script type="text/javascript">

			function getTab(mm){
				for(var i=0;i<=11;i++){
					if(i==mm){
						document.getElementById("test" +mm).style.display="block";
					}else{
						document.getElementById("test" +i).style.display="none";	
					}
				}
			}
		</script>
		<script type="text/javascript">
		$(function(){	
			//顶部导航切换
			$(".nav li button").click(function(){
				$(".nav li button.selected").removeClass("selected")
				$(this).addClass("selected");
			})	
		})	
		var list = new Array("phy","ass","hms","net","rps","mfs");
		
		
		function choose(str){
			
			for(i=0; i<list.length;i++){
				if(list[i] == str){
					document.getElementById(list[i]).style.display="table-row";
				}else{
					document.getElementById(list[i]).style.display="none";
				}
				
			}
		}
		function changeFunc() {
		 	
		    var selectBox = document.getElementById("object");
		    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
		
		   if(selectedValue == "0"){
		 
		   		choose("phy");
		   	
		   }else if(selectedValue == "1" || selectedValue == "10"){
		   		choose("net");
		  
		   }else if (selectedValue == "2" || selectedValue == "11"){
		   		choose("hms");
		   		
		   }else if (selectedValue == "3"){
		   		
		   		choose("ass");
		   }else if (selectedValue == "4"){
		   		
		   		choose("hms");
		   }else if (selectedValue == "7"){
		   		
		   		choose("rps");
		   }else{
		   
		   		choose("mfs");
		   }
		}	
		
		
	</script>
	</head>
	<body class="container-fluid">
	<br><br>
		<div class="row-fluid">
		 <ul class="toolbar1">
		 	
			 <button data-toggle="modal" data-target="#newTestObject">
			 	<span><img src="images/t01.png" /></span>创建对象
			 </button>
		
	 		<s:iterator value="objects">
				<button class="btn btn-info" onclick = "getTab(${autoId})">${name}
				</button>
			</s:iterator>	
		</ul>
		</div>

		<s:iterator value="objects" id="ob">
			<div class="object" id="test${autoId}">
				<center>
			 	<table class="table table-bordered" style="width:95%;" >
			 		<thead>
			 		<tr height="40px" class="success">
		 				<th colspan = "2" ><b>${ob.name}</b></th>				 		
			 		</tr>
					</thead>
			 		<tbody>
			 		<s:iterator value="CpObject">
		 			<s:if test = "object.autoId == #ob.autoId ">
			 		<tr height="30px">
			 			<td width="50%">
				 			<h4>
						 		<a href="showItem?id=${autoId}&object=${name}" target="_blank">
						 			${name}
						 		</a>
						 	</h4>
			 			</td>
				 		<td width="45%">
				 			<h4>
				 				<a href="delete!delete_object.action?objectId=${autoId}&sysId=${param.sysId}&url=${param.url}&mark=${param.mark}&corId=${param.corId}" onclick="return shanchu()" target="right">删除</a> || 作业指导书
				 			</h4>
				 		</td>				 		
			 		</tr>
			 		</s:if>
					</s:iterator>	
					</tbody>
					<s:iterator value="system">
					<c:set var="level" value="${level}"/>
					</s:iterator>
					
			 	</table>
			 </center>
			 
			</div>
		</s:iterator>
		
		<input type="button" class="btn btn-info" value="后退" onclick="window.history.go(-1)" style ="margin-left:20px;margin-top:50px">
		
		<div class="modal fade" id="newTestObject" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	 <form action="newObject" method = "post">
	   	<div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="myModalLabel">	            	
	             		 <b>添加测评对象</b>					
	            </h4>
	         </div>
	        		        	
         		<input type="hidden" name="testSysId" value="${testSysId}">

         		<input type="hidden" name="sysId" value="${param.sysId}">
         		<input type="hidden" name="mark" value="${param.mark}">
         		<input type="hidden" name="corId" value="${param.corId}">
         		<input type="hidden" name="url" value="${param.url}">
	         		
		         <div class="modal-body">
		         	
					
				<select id="object" name="object"  onchange="">
					<optgroup label="测评对象">
					<s:iterator value="objects">
						<option value="${autoId}" >${name}</option>
					</s:iterator>
					
					</optgroup>
				</select>

				<select name="dName" id="phy" style="display:table-row">
					 
					<s:iterator id="sto" value="sysTestObject">
						
						<s:iterator value="#sto.value" id ="stov">
							<s:if test="status == 1">
								<option value='${name}' id="<s:property value='#sto.key'/>">
								${name}
								</option>
							</s:if>
						</s:iterator>
						
					</s:iterator>
					<option value="网络全局">网络全局</option>
					<option value="数据安全及备份恢复">数据安全及备份恢复</option>
					<option value="人员安全管理">人员安全管理</option>
					<option value="安全管理制度">安全管理制度</option>
					<option value="安全管理机构">安全管理机构</option>
					<option value="系统建设管理">系统建设管理</option>
					<option value="系统运维管理">系统运维管理</option>
				</select>
					
				<br><br>
				<b>S</b>
				<select name="sLevel">
					<option value="${fn:substring(level, 0, 2)}">
							${fn:substring(level, 0, 2)}
					</option>
					<option value="S1">S1</option>
					<option value="S2">S2</option>
					<option value="S3">S3</option>
					<option value="S4">S4</option>
					<option value="S5">S5</option>
					
				</select>&nbsp;&nbsp;
				<b>G</b>&nbsp;
				<select name="gLevel">
					
					<option value="${fn:substring(level, 4, 6)}">
						${fn:substring(level, 4, 6)}
					</option>
					<option value="G1">G1</option>
					<option value="G2">G2</option>
					<option value="G3">G3</option>
					<option value="G4">G4</option>
					<option value="G5">G5</option>
					
				</select>&nbsp;&nbsp;
				<b>A</b>&nbsp;
				<select name="aLevel">
					<option value="${fn:substring(level, 2, 4)}">
						${fn:substring(level, 2, 4)}
					</option>
					<option value="A1">A1</option>
					<option value="A2">A2</option>
					<option value="A3">A3</option>
					<option value="A4">A4</option>
					<option value="A5">A5</option>
					
				</select>
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

		<div class="navbar-fixed-bottom container span12 ">
			<p class=" text-center ">&copy;中国科学技术大学信息安全测评中心&nbsp;&nbsp;&nbsp;&nbsp;地址：邮编：  <a href="http://itsec.ustc.edu.cn/contact.php">联系我们</a></p>
			<p class="text-center"></p>
		</div>
	</body>
</html>
