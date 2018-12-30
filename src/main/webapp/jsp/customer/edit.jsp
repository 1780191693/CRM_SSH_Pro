<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
<s:form name="form1" id="form1" action="customer_update" namespace="/" method="POST" enctype="multipart/form-data" theme="simple">
		<s:hidden name="cust_id" value="%{model.cust_id}"/>
		<s:hidden name="cust_prove" value="%{model.cust_prove}"/>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
                        <s:actionerror/><s:fielderror/>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称 :</td>
								<td>
                                    <s:textfield cssClass="textbox" name="cust_name" cssStyle="width: 180px" value="%{model.cust_name}"/>
								</td>
								<td>客户级别 :</td>
								<td>
                                    <select id="cust_level" name="baseDictLevel.dict_id" style="width: 180px">
                                        <option value="">-请选择-</option>
                                    </select>
								</td>
							</TR>
							<TR>
								<td>信息来源 :</td>
								<td>
                                    <select id="cust_source" name="baseDictSource.dict_id" style="width: 180px">
                                        <option value="">-请选择-</option>
                                    </select>
								</td>
								<td>所属行业 :</td>
								<td>
                                    <select id="cust_industry" name="baseDictIndustry.dict_id" style="width: 180px">
                                        <option value="">-请选择-</option>
                                    </select>
								</td>
							</TR>
							<TR>
								<td>固定电话 :</td>
								<td>
                                    <s:textfield cssClass="textbox" name="cust_phone" cssStyle="width: 180px" value="%{model.cust_phone}"/>
								</td>
								<td>移动电话 :</td>
								<td>
                                    <s:textfield cssClass="textbox" name="cust_mobile" value="%{model.cust_mobile}" cssStyle="width: 180px"/>
								</td>
							</TR>
							
							<TR>
								<td>联系地址 :</td>
								<td>
                                    <s:textfield cssClass="textbox" name="cust_address" value="%{model.cust_address}" cssStyle="width: 180px"/>
								</td>
								<td>邮政编码 :</td>
								<td>
                                    <s:textfield cssClass="textbox" name="cust_zipcode" value="%{model.cust_zipcode}" cssStyle="width: 180px"/>
								</td>
							</TR>
							<TR>
								<td>客户传真 :</td>
								<td>
                                    <s:textfield cssClass="textbox" name="cust_fax" value="%{model.cust_fax}" cssStyle="width: 180px"/>
								</td>
								<td>客户邮箱 :</td>
								<td>
                                    <s:textfield cssClass="textbox" name="cust_email" value="%{model.cust_email}" cssStyle="width: 180px"/>
								</td>
							</TR>
							<tr>
								<td>资质证明 :</td>
								<td>
									<input type="file" name="upload"  placeholder="<s:property value="model.cust_prove"/>" style="width: 180px">
								</td>
							</tr>
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
    </s:form>
</BODY>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(function () {
        $.post("${pageContext.request.contextPath}/baseDict_findByTypeCode.action",{"dict_type_code":"002"},function (data) {
            $(data).each(function (i, n) {
                $("#cust_source").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
            });
            $("#cust_source option[value='${model.baseDictSource.dict_id}']").prop("selected",true);
        },"json");
        $.post("${pageContext.request.contextPath}/baseDict_findByTypeCode.action",{"dict_type_code":"001"},function (data) {
            $(data).each(function (i, n) {
                $("#cust_industry").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
            });
            $("#cust_industry option[value='${model.baseDictIndustry.dict_id}']").prop("selected",true);
        },"json");
        $.post("${pageContext.request.contextPath}/baseDict_findByTypeCode.action",{"dict_type_code":"006"},function (data) {
            $(data).each(function (i, n) {
                $("#cust_level").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
            });
            $("#cust_level option[value='${model.baseDictLevel.dict_id}']").prop("selected",true);
        },"json");
    });
</script>

</HTML>
