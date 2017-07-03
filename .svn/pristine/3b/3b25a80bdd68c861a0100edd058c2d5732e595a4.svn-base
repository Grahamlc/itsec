<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp"%>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">

<title>USTC-ITSEC信息管理平台</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="images/title.png" type="image/x-icon">
<link href="login/style.css" rel="stylesheet" type="text/css" />
<base target="_blank" />
<style type="text/css">
			body {		
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
			.btn-warning{color:#000 !important;}
			.btn-danger{color:#000 !important;}
		</style>
<script>
	function shanchu() {
		var r = confirm('您确定要改记录吗？');
		if (r == true) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body class="container-fluid">


	<br />
	<div class="row pull-right ">
		<button class="btn btn-info">全选</button>
	</div>

	<s:form action="insert" method="post">

		<s:submit method="delKeyData" class=" btn btn-danger"
			onclick="return shanchu()" value="删除" />

		<div id="editInfor">
			<table class="table table-bordered my-table">
				<thead>
					<tr height="35px" class="success">
						<th colspan="4" class="text-center">物理机房</th>
					</tr>
					<tr height=30px>
						<th class="text-center">编号</th>
						<th class="text-center">机房名称</th>
						<th class="text-center">物理位置</th>
						<th class="text-center" style="width:100px;">
							<table>
								<s:submit name="insertPhy" class="btn-danger" value="添加"
									method="insertPhy" />									
							</table>

						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="phy">
						<tr>
							<td class="text-center" width="10%"><input type="checkbox"
								name="delphyId" value="${autoId}" /></td>
							<td><input type="text" name="phy_name${autoId}"
								value="${name}" class="input-large" style="width: 200px; " /></td>
							<td><input type="text" name="phy_location${autoId}"
								value="${location}" class="input-large" style="width: 200px; " />
							</td>
							<input type="hidden" name="phyId" value="${autoId}">
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<table class="table table-bordered  my-table" style="display:">
				<thead>
					<tr height="35px" class="success">
						<th colspan="6" class="text-center"><b>关键数据类型</b></th>
					</tr>
					<tr height=30px>
						<th class="text-center">编号</th>
						<th class="text-center">数据类型</th>
						<th class="text-center" style="width:140px;">所属业务应用</th>
						<th class="text-center" style="width:140px;">主机/存储设备</th>
						<th class="text-center" style="width:100px;">重要程度</th>
						<th class="text-center" style="width:100px;">
							<table>
								<s:submit name="insertMainData" class="btn-danger" value="添加"
									method="insertMainData" />
							</table>

						</th>

					</tr>
				</thead>
				<tbody>
					<s:iterator status="md" value="md">

						<tr height="40px">
							<td class="text-center" width="10%"><input type="checkbox"
								name="delmdId" value="${autoId}" /></td>
							<td class="text-center"><input type="text"
								name="md_dataType${autoId}" value="${name}" class="input-large"
								style="width: 200px; " /></td>
							<td style="text-align:center"><input type="text"
								name="md_appSoft${autoId}" value="${appSoft}"
								class="input-large" placeholder="" style="width: 200px;">
							</td>
							<td style="text-align:center"><input type="text"
								name="md_hostMemory${autoId}" value="${hostMemory}"
								class="input-large" placeholder="" style="width: 200px; "></td>
							<td style="text-align:center"><input type="text"
								name="md_important${autoId}" value="${important}"
								class="input-large" placeholder="'重要'，'不重要'"></td>
							<input type="hidden" name="mdId" value="${autoId}">
							<td style="text-align:center">
								<!-- 
						<table>
							<s:submit method="delMainData" value="删除"/>
						</table>
						 -->
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<table class="table table-bordered  my-table">
				<thead>
					<tr height="35px" class="success">
						<th colspan="6" class="text-center"><b>业务应用软件</b></th>
					</tr>

					<tr height=30px>
						<th class="text-center">编号</th>
						<th class="text-center">软件名称</th>
						<th class="text-center" colspan="2">主要功能</th>
						<th class="text-center">重要程度</th>
						<th class="text-center">
							<table>
								<s:submit name="insertAppSoft" class="btn-danger" value="添加"
									method="insertAppSoft" />
								<!--
							<s:submit method="delAppSoft" onclick="return shanchu()" value="删除"/>	
							-->
							</table>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator status="as" value="as">
						<tr height="40px">
							<td class="text-center"><input type="checkbox"
								name="delasId" value="${autoId}" /></td>
							<td width="200px" style="text-align:center"><input
								type="text" name="as_name${autoId}" value="${name}"
								class="input-large" style="width: 200px; "></td>
							<td colspan="2" style="text-align:center"><input type="text"
								name="as_usedFor${autoId}" value="${usedFor}"
								class="input-large " style="width:420px;"></td>
							<td style="text-align:center"><input type="text"
								name="as_important${autoId}" value="${important}"
								class="input-large" placeholder="'重要'，'不重要'"></td>
							<td style="text-align:center">
								<!-- 
						<table>
							<s:submit method="delAppSoft" value="删除"/>
						</table>
					 -->
							</td>
							<input type="hidden" name="asId" value="${autoId}">
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<table class="table table-bordered  my-table">
				<thead>
					<tr height="35px" class="success">
						<th colspan="6" class="text-center"><b>主机/存储设备</b></th>
					</tr>
					<tr height=30px>
						<th class="text-center">编号</th>
						<th class="text-center">设备名称</th>
						<th class="text-center" colspan="2">操作系统/数据库管理系统</th>
						<th class="text-center">业务应用</th>
						<th class="text-center">
							<table>
								<s:submit value="添加" class="btn-danger"
									method="insertHostMemory" />
								<!--
							<s:submit method="delHostMemory" onclick="return shanchu()" value="删除"/>	
							-->
							</table>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator status="hm" value="hm">
						<tr height="40px">
							<td class="text-center"><input type="checkbox"
								name="delhmId" value="${autoId}" /></td>
							<td width="200px" style="text-align:center"><input
								type="text" name="hm_name${autoId}" value="${name}"
								class="input-large" placeholder="" style="width: 200px; ">
							</td>
							<td colspan="2" style="text-align:center"><input type="text"
								name="hm_osSystem${autoId}" value="${osSystem}"
								class="input-large" style="width: 420px; "></td>
							<td style="text-align:center"><input type="text"
								name="hm_usedFor${autoId}" class="input-large"
								value="${usedFor}"></td>

							<input type="hidden" name="hmId" value="${autoId}">
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<table class="table table-bordered  my-table">
				<thead>
					<tr height="35px" class="info">
						<th colspan="6" style=" text-align:center" id="tb"><b>网络互联设备</b>
						</th>
					</tr>
					<tr height=30px>
						<th class="text-center">编号</th>
						<th class="text-center">设备名称</th>
						<th class="text-center" colspan="2">用途</th>
						<th class="text-center">重要程度</th>
						<th class="text-center">
							<table>
								<s:submit value="添加" class="btn-danger" method="insertNetDevice" />
								<!-- 
							<s:submit method="delNetDevice" onclick="return shanchu()" value="删除"/>	
							 -->
							</table>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator status="nd" value="nd">
						<tr height="40px">
							<td class="text-center"><input type="checkbox"
								name="delndId" value="${autoId}" /></td>
							<td width="200px" style="text-align:center"><input
								type="text" name="nd_madeFrom${autoId}" value="${name}"
								class="input-large" style="width: 200px; "></td>
							<td colspan="2" style="text-align:center"><input type="text"
								name="nd_usedFor${autoId}" value="${usedFor}"
								class="input-large" style="width: 420px; "></td>
							<td style="text-align:center"><input type="text"
								name="nd_important${autoId}" value="${important}"
								class="input-large" placeholder="'重要'，'不重要'"></td>
							<td style="text-align:center">
								<!-- 
						<table>
							<s:submit method="delNetDevice" value="删除"/>
						</table>
						 -->
							</td>
							<input type="hidden" name="ndId" value="${autoId}">
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<table class="table table-bordered  my-table">
				<thead>
					<tr height="35px" class="success">
						<th colspan="6" class="text-center"><b>安全设备</b></th>
					</tr>
					<tr height=30px>
						<th class="text-center">编号</th>
						<th class="text-center">设备名称</th>
						<th class="text-center" colspan="2">用途</th>
						<th class="text-center">重要程度</th>
						<th class="text-center">
							<table>
								<s:submit value="添加" class="btn-danger" method="insertSecDevice" />
								<!--
							<s:submit method="delSecDevice" onclick="return shanchu()" value="删除"/>	
							-->
							</table>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator status="sd" value="sd">
						<tr height="40px">
							<td class="text-center"><input type="checkbox"
								name="delsdId" value="${autoId}" /></td>
							<td width="200px" style="text-align:center"><input
								type="text" name="sd_madeFrom${autoId}" value="${name}"
								class="input-large" placeholder="" style="width: 200px; ">
							</td>
							<td colspan="2" style="text-align:center"><input type="text"
								name="sd_usedFor${autoId}" value="${usedFor}"
								class="input-large" placeholder="" style="width: 420px;" /></td>
							<td style="text-align:center"><input type="text"
								name="sd_important${autoId}" value="${important}"
								class="input-large" placeholder="'重要'，'不重要'"></td>
							<td style="text-align:center">
								<!--  
						<table>
							<s:submit method="delSecDevice" value="删除"/>
						</table>
						-->
							</td>
							<input type="hidden" name="sdId" value="${autoId}">
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<table class="table table-bordered  my-table">
				<thead>
					<tr height="35px" class="success">
						<th colspan="6" class="text-center"><b>安全相关人员</b></th>
					</tr>
					<tr height=30px>
						<th class="text-center">编号</th>
						<th class="text-center">姓名</th>
						<th class="text-center" colspan="2">岗位/角色</th>
						<th class="text-center">联系方式</th>
						<th class="text-center">
							<table>
								<s:submit value="添加" class="btn-danger"
									method="insertRelaPeople" />
								<!--
							<s:submit method="delRelaPeople" onclick="return shanchu()" value="删除"/>	
							-->
							</table>
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator status="rp" value="rp">
						<tr height="40px">
							<td class="text-center"><input type="checkbox"
								name="delrpId" value="${autoId}" /></td>
							<td width="200px" style="text-align:center"><input
								type="text" name="rp_name${autoId}" value="${name}"
								class="input-large" style="width: 200px; "></td>
							<td colspan="2" style="text-align:center"><input type="text"
								name="rp_position${autoId}" value="${position}"
								class="input-large" placeholder="" style="width: 420px;" /></td>
							<td style="text-align:center"><input type="text"
								name="rp_contact${autoId}" value="${contact}"
								class="input-large"></td>
							<td style="text-align:center">
								<!-- 
						<table>
							<s:submit method="delRelaPeople" value="删除"/>
						</table>
						 -->
							</td>
							<input type="hidden" name="rpId" value="${autoId}">
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<table class="table table-bordered  my-table">
				<thead>
					<tr height="35px" class="success">
						<th colspan="6" class="text-center"><b>安全管理文档</b></th>
					</tr>
					<tr height=30px>
						<th class="text-center">编号</th>
						<th class="text-center" colspan="4">文档名称</th>
						<th class="text-center">
							<table>
								<s:submit value="添加" class="btn-danger"
									method="insertManageFile" />
								<!--
							<s:submit method="delManageFile" onclick="return shanchu()" value="删除"/>	
							-->
							</table>

						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator status="mf" value="mf">
						<tr height="40px">
							<td class="text-center"><input type="checkbox"
								name="delmfId" value="${autoId}" /></td>
							<td width="200px" colspan="4" style="text-align:center"><input
								type="text" name="mf_name${autoId}" value="${name}"
								class="input-large" style="width: 600px; "></td>
							<td style="text-align:center">
								<!-- 
						<table>
							<s:submit method="delManageFile" value="删除"/>
						</table>
						 -->
							</td>
							<input type="hidden" name="mfId" value="${autoId}" />
						</tr>
					</s:iterator>
				</tbody>

			</table>
		</div>
		<input type="hidden" name="url" value="Information.jsp" />
		<input type="hidden" name="corId" value="${param.corId}" />
		<br />

		<s:submit type="button" value="提交" class="btn btn-warning"
			method="submit" />

	</s:form>


	<input type="button" class="btn-info btn" value="后退"
		onclick="window.history.go(-1)"
		style="margin-left:20px;margin-top:-40px; font-color:black;">
</body>
</html>
