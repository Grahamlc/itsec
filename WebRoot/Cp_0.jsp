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
			body {margin: 0px;padding:0; background-color:#eef3f7;}
			.my-table{width:95%}
			
		</style>
		<script type="text/javascript">
			function stayback(){
				var r=confirm('您确定要撤销吗？');
				if (r==true)
				  {
				    return true;
				  }
				else
				  {
					return false;
				  }
			}
			}

		</script>
	</head>
	<body class="container-fluid" border="1px">
	<br><br>
		<div class="tag" id="d1">
			
			<center>
				<table class="table table-bordered my-table">
					<thead>
						<tr>
							<th width="40%">被测系统</th>
							<th width="15%">等级</th>
							<th width="30%">操作</th>
							<th width="15%">								
								<button data-toggle="modal" data-target="#newJob" class="btn btn-info">
								追加任务单
								 </button>		
				 			</th>		
						</tr>
					</thead>
					<tbody>
						
							<s:iterator value="testSystem" id = "testSys">
								
									<tr>
										<td>
											${system.sysName}
										</td>
										<td>${system.level}</td>
										<td colspan = "2">
											
											<s:if test="cpState == 10">测评已结束	</s:if>
											<s:else>
												<a href="MO!Undo?testSysId=${autoId}&sysId=${system.autoId}" onclick = "return stayback()">撤回</a>&nbsp;&nbsp;&nbsp;&nbsp;||
												<s:if test="cpState == 0">
													<a href="showTester?url=testers.jsp&testSysId=${autoId}&proId=${param.proId}&backUrl=${param.url}" target = "proright">项目经理</a>
												</s:if>
												<s:else>
													<a href="showTester?url=testers.jsp&testSysId=${autoId}&proId=${param.proId}&backUrl=${param.url}" target = "proright">更换项目经理</a>
												</s:else>
								 		
									 			&nbsp;&nbsp;&nbsp;&nbsp;||
									 		
												<a href="showSysteminfo?sysId=${system.autoId}&url=Cp_7.jsp"  target="proright">进展</a>
											
												&nbsp;&nbsp;&nbsp;&nbsp;||
												<a href="MO!Finish?testSysId=${autoId}&proId=${param.proId}">测评结束</a>
											</s:else>
										</td>
									</tr>
								
								</s:iterator>
						
						
						
					</tbody>
				</table>			
			</center>
		</div>
		
		<div class="modal fade" id="newJob" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	 <form action="MO!Distribute" method = "post">
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
					<input type="hidden" name="proId" value="${param.proId}" />
					<table>
					 
					<s:iterator value="nonSystems" id = "nonSys">							
														
							<tr>
								<td>
								<input type="checkbox" name="sysId" value="${autoId}"  />
								</td>
								<td>
								${sysName}
								</td>
							</tr>
					
					</s:iterator>
				
					</table>		
			 </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" 
	               data-dismiss="modal">取消
	            </button>
	            <button type="submit" class="btn btn-success">
	         	  追加
	            </button>
	         </div>	         
	      </div>
	</div>
	</form>
</div>

<!-- 商务人员指定项目经理 -->
		<div class="modal fade" id="setManager" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   	 <form action="MO!Distribute" method = "post">
	   	<div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            	派发项目经理
	         </div>	
	         <input type="hidden" name="corId" value="${param.corId}" /> 
	         <input type="hidden" name="proId" value="${param.proId}" />        	
		     <div class="modal-body">		    			
					<table>
					<s:iterator value="testers" id = "tester">							
						<s:if test="company.corId == 1">									
							<tr>
								<td>
								<input type="checkbox" name="testerId" value="${userId}"  />
								</td>
								<td>
								${name}
								</td>
							</tr>
						</s:if>
						
					</s:iterator>

					</table>		
			 </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" 
	               data-dismiss="modal">取消
	            </button>
	            <button type="submit" class="btn btn-success">
	         	  派发	
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
