<%--
  Created by IntelliJ IDEA.
  User: karan
  Date: 15/7/17
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>LinkSharing</title>
</head>
<body>
Error:<c:out value="${message}"/>
<%
    response.setHeader("Refresh", "3000; URL=/home" );
%>
</body>
</html>
