﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
<TITLE>添加客户</TITLE> 
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="<s:url action="user_regist"/>" method=post>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg>
						<IMG src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_name">
								</td>
								<td>客户级别 ：</td>
								<td>
								    <select id="cust_level" style="width: 180px">
										<option>-请选择-</option>
									</select>
								</td>
							</TR>
							<TR>
								<td>信息来源 ：</td>
								<td>
								    <select id="cust_source" style="width: 180px;">
										<option>-请选择-</option>
									</select>
								</td>
								<td>所属行业 ：</td>
								<td>
								    <select id="cust_industry" style="width: 180px">
										<option>-请选择-</option>
									</select>
								</td>
							</TR>
							<TR>
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel6
														style="WIDTH: 180px" maxLength=50 name="cust_phone">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel7
														style="WIDTH: 180px" maxLength=50 name="cust_mobile">
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<%--异步加载--%>
<script type="text/javascript">
    $(function () {
        //页面一加载就执行  异步查询字典的数据
        $.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",{"dict_type_code":"002"},function (data) {
            //遍历json
            $(data).each(function (i, n) {
                $("#cust_source").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
            })
        },"json");
        $.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",{"dict_type_code":"006"},function (data) {
            //遍历json
            $(data).each(function (i, n) {
                $("#cust_level").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
            })
        },"json");
        $.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",{"dict_type_code":"001"},function (data) {
            //遍历json
            $(data).each(function (i, n) {
                $("#cust_industry").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
            })
        },"json");
    })
</script>
</HTML>
