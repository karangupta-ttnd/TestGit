<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>LinkSharing</title>
</head>
<body>
<%--Success:<c:out value="${message}" />--%>
<br>${message}
<%--<c:if test="${not empty message}">--%>
    <%--Hello ${model.message}--%>
<%--</c:if>--%>
<%
    response.setHeader("Refresh", "3000; URL=/home" );
%>
</body>
</html>
