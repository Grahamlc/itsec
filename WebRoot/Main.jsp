<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
    <head>
		<title>项目管理</title>
		<meta  http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="shortcut icon" href="images/title.jpg" type="image/x-icon">
		<base target="_blank"/>	
		<base href="<%=basePath%>">
	</head>
		
		<frameset rows="150px,*" frameborder="no"  framespacing="0">
			<frame src="top.jsp" scrolling="No" noresize="noresize" name="top"/>
				<frameset cols="300px,*" frameborder="no" border="0" framespacing="0">
					<frame src="showMPro?proId=${param.proId}&url=Pro_left.jsp" scrolling="No" noresize frameborder="0" name="proleft"/>				
						<frameset rows="88px,*" frameborder="no"  framespacing="0">
							<frame src="ProMenu.jsp?proId=${param.proId}" noresize frameborder="0" name="protop"/>
							
							<frame src="exploitInfo.jsp" noresize frameborder="0" name="proright"/>	
						</frameset>
				</frameset>
		</frameset>

</html>
