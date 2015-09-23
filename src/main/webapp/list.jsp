<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Compass Product</title>
</head>
<body>
<hr>
<ul>
    <li>产品明细表</li>
</ul>
<table width="80%" border="1" bordercolor="#000000" style="border-collapse: collapse;" align="center">
    <tr align="center">
        <th>编号</th>
        <th>产品名称</th>
        <th>价格</th>
        <th>产品描述</th>
        <th>产品类别</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    <s:iterator value="#request.list" var="product">
        <tr align="center">
            <td><s:property escape="false" value="#product.id"/></td>
            <td><s:property escape="false" value="#product.name"/></td>
            <td><s:property escape="false" value="#product.price"/></td>
            <td><s:property escape="false" value="#product.descption"/></td>
            <td><s:property escape="false" value="#product.category.name"/></td>
            <td><a href="productAction!get.action?product.id=<s:property escape="false" value="#product.id"/>">修改</a>
            </td>
            <td><a href="productAction!delete.action?product.id=<s:property escape="false" value="#product.id"/>">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
<hr>
<ul>
    <li>compass查询</li>
</ul>
<table width="40%" border="1" bordercolor="#000000" style="border-collapse: collapse;" align="center">
    <s:form action="productAction!search.action" method="post" theme="simple">
        <tr align="center">
            <td>关键字:</td>
            <td align="left"><s:textfield name="queryString"></s:textfield></td>
            <td><s:submit value="查询"></s:submit></td>
            <td><a href="productAction!tosave.action">添加产品</a></td>
        </tr>
    </s:form>
</table>
</body>
</html>