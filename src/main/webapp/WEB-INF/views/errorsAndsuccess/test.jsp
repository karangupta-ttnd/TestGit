<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: karan
  Date: 21/7/17
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<c:forEach items="${topicList}" var="topic">--%>
    <%--<c:out value="${topic.lastUpdated},"/>--%>
    <%--<c:out value="${topic.name}"/>--%>
<%--</c:forEach>--%>
<%=request.getAttribute("id")+"attr"%>
<%=request.getParameter("id")+"para"%>
</body>
</html>
