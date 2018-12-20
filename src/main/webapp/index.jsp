<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<HTML>
<HEAD>
<TITLE>客户关系管理系统</TITLE> 
</HEAD>

<FRAMESET frameSpacing=0 rows=80,* frameBorder=0>
	<FRAME name=top src="${ pageContext.request.contextPath }/top.jsp" frameBorder=0 noResize scrolling=no>
	<FRAMESET frameSpacing=0 frameBorder=0 cols=220,*>
		<FRAME name=menu src="${ pageContext.request.contextPath }/menu.jsp" frameBorder=0 noResize>
		<FRAME name=main src="${ pageContext.request.contextPath }/welcome.jsp" frameBorder=0>
	</FRAMESET>
	<NOFRAMES>
		<p>This page requires frames, but your browser does not support
			them.</p>
	</NOFRAMES>
</FRAMESET>
</HTML>
