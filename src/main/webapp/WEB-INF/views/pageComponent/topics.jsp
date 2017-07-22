<%--
  Created by IntelliJ IDEA.
  User: karan
  Date: 22/7/17
  Time: 2:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-default">
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-3">
                <span>Topics</span>
            </div>
            <div class="col-md-9 ">
                <span class="search-bar decrease-margin pull-right">
														<span id="search-logo"><i
                                                                class="glyphicon glyphicon-search"></i></span>
														<input type="text" id="search-input" class="search-bar"
                                                               placeholder="Search"/>
														<span id="remove-sign"><i
                                                                class="glyphicon glyphicon-remove-sign "></i></span>
													</span>
            </div>
        </div>
    </div>
    <div class="panel-body" id="topics">
        <div class="row">
            <div class="col-md-2">
                <c:choose>
                    <c:when test="${not empty data.photo}">
                        <img class="profilePic" alt="Profile Pic"
                             src="data:image/jpeg;base64,<c:out value="${data.photo}"/>"/>
                    </c:when>
                    <c:otherwise>
                        <span class="glyphicon glyphicon-userCO"></span>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="col-md-10">
                <div class="row">
                    <div class="col-md-8">
                        <input type="text" placeholder=""/>
                    </div>
                    <div class="col-md-4">
                        <input type="button"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <span class="twitter-handler"><c:out value="${data.username}"/></span>
                    </div>
                    <div class="col-md-4">
                        <div class="row">
                            Subscriptions
                        </div>
                        <div class="row">
                            50
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="row">
                            Post
                        </div>
                        <div class="row">
                            50
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <select class="select-border form-control" id="seriousness" name="seriousness">
                    <option value="_SERIOUS" selected>Serious</option>
                    <option value="_VERY_SERIOUS">Very Serious</option>
                    <option value="_CASUAL">Casual</option>
                </select>
            </div>
            <div class="col-md-4">
                <select class="select-border form-control" id="visibility" name="visibility">
                    <option value="_PUBLIC" selected>Public</option>
                    <option value="_PRIVATE">Private</option>
                </select>
            </div>
            <div class="col-md-4">
                <span data-toggle="modal" data-target="#sendInvitation"><i
                        class="glyphicon glyphicon-envelope"></i></span>

                <span data-toggle="modal" data-target="#shareDocument"><img src="/assets/icons/new-file.png"
                                                                            alt="new file"
                                                                            class="new-file"/></span>
                <span><i class="fa fa-trash" aria-hidden="true"></i>
</span>
            </div>
        </div>
    </div>
</div>
