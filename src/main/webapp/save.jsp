<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<s:form action="productAction!save.action" method="post">
    <s:textfield name="product.name" label="name"></s:textfield>
    <s:textfield name="product.price" label="price"></s:textfield>
    <s:textfield name="product.descption" label="descption"></s:textfield>
    <select name="product.category.id">
        <s:iterator value="#request.listCategory" var="category">
            <option value="<s:property value="#category.id"/>">
                <s:property value="#category.name"/>
            </option>
        </s:iterator>
    </select>
    <s:submit value="提交"></s:submit>
</s:form>
</body>
</html>