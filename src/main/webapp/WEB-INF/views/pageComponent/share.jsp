<%--
  Created by IntelliJ IDEA.
  User: karan
  Date: 20/7/17
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="row row-buffer">
    <div class="col-md-2">
        <c:choose>
            <c:when test="${not empty data.photo}">
                <img class="profilePic" alt="Profile Pic"  src="data:image/jpeg;base64,<c:out value="${data.photo}"/>"/>
            </c:when>
            <c:otherwise>
                <span class="glyphicon glyphicon-userCO"></span>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="col-md-10">
        <div class="row">
            <div class="col-md-10">
                <strong> <span class="username"><c:out value="${data.firstName} ${data.lastName}"/></span></strong>
                <span class="twitter-handler"><c:out value="${data.username}"/></span>
            </div>
            <div class="col-md-2 pull-right">
                <span><a href="#" class="link"><c:out value="${data.topicName}"/></a></span>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">

            </div>
        </div>
        <div class="row links">
            <div class="col-md-10">
                <i class="fa fa-facebook-official fa-2x" aria-hidden="true"></i>
                <i class="fa fa-twitter  fa-2x" aria-hidden="true"></i>
                <i class="fa fa-google-plus  fa-2x" aria-hidden="true"></i>
            </div>
            <div class="col-md-2 pull-right">
                <span><u><a href="/showPost?id=<c:out value="${data.topicId}"/>" class="link"> View Posts</a></u></span>
            </div>
        </div>
    </div>
</div>
