<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 	<head>
		<title>USTC-ITSEC信息管理平台</title>
		<meta  http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="shortcut icon" href="images/title.jpg" type="image/x-icon">
		<base target="_blank"/>	
	</head>
	<c:if test="${role eq 5}">
		<frameset rows="150px,*" border="0px" framespacing="0">
			<frame src="top.jsp" noresize scrolling="No" name="matop"/>
				<frameset cols="187px,*" border="0px">
					<frame src="Maleft.jsp" noresize scrolling="No" frameborder="0" name="maleft"/>
					<frame src="super!showUser.action" noresize frameborder="0" name="right"/>
				</frameset>
		</frameset>	
	</c:if>
</html>
