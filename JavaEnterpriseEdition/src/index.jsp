<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
    Document   : testchoose
    Created on : 20/12/2018, 12:48:06 AM
    Author     : vito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Test Choose JSTL</h1>
<c:choose>
    <c:when test="${param.displayConditionalText == '1'}">
        <p>Este texto se muestra si el parametro es 1</p>
    </c:when>
    <c:when test="${param.displayConditionalText == 2}">
        <p>Este texto se muestra si el parametro es 2</p>
    </c:when>
    <c:when test="${param.displayConditionalText == 3}">
        <p>Este texto se muestra si el parametro es 3</p>
    </c:when>
    <c:when test="${param.displayConditionalText == 4}">
        <p>Este texto se muestra si el parametro es 4</p>
    </c:when>
    <c:otherwise>
        <p>Esto se muestra en caso de que no se cumpla ninguna condicion</p>
    </c:otherwise>
</c:choose>

</body>
</html>