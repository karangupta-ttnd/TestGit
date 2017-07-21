<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <header>
        <%@ include file="../headerAndfooter/header.jsp" %>
    </header>
</head>
<body>
<div class="container-fluid">
    <div class="row">

        <div class="col-md-4">
            <div class="row">
                <div class="col-md-12">
                    <div id="subscribers-detail" class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-3">
                                    <% if(session.getAttribute("userImage")!=null && !session.getAttribute("userImage").equals(""))
                                        {out.print("<img class=\"profilePic\" alt=\"Profile Pic\"  src=\"data:image/jpeg;base64,"+session.getAttribute("userImage")+"\"/>");}
                                    else
                                        {out.print("<span class=\"glyphicon glyphicon-userCO\"></span>");}
                                    %>
                                </div>
                                <div class="col-md-9">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <span><h4><%=session.getAttribute("firstName") + " " + session.getAttribute("lastName")%></h4></span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <span>@<%=session.getAttribute("userName")%></span>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <span>Subscription</span>
                                                </div>
                                                <div class="col-md-12">
                                                    <span><a href="#">50</a></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <span>Topics</span>
                                                </div>
                                                <div class="col-md-12">
                                                    <span><a href="#">30</a></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-md-3">
                                    <span>Subscriptions</span>
                                </div>
                                <div class="col-md-9 ">
                                    <span class="pull-right"><a href="#"><u>View All</u></a></span>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">

                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="col-md-8">
            <div class="row">
                <div class="col-md-12">
                    <div id="recent_shares" class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-md-3">
                                    <span>Inbox</span>
                                </div>
                                <div class="col-md-9">
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
                        <div class="panel-body">
                            <div class="row row-buffer">
                                <div class="col-md-2">
                                    <span class="glyphicon glyphicon-userCO"></span>
                                </div>
                                <div class="col-md-10">
                                    <div class="row">
                                        <div class="col-md-10">
                                            <strong> <span class="username">Uday Pratap Singh</span></strong>
                                            <span class="twitter-handler">@uday 5min</span>
                                        </div>
                                        <div class="col-md-2 pull-right">
                                            <span><a href="#" class="link"> Grails</a></span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                                            Lorem Ipsum has been the industry's standard dummy text ever since the
                                            1500s, when an unknown printer took a galley of type and scrambled it to
                                            make a type specimen book.
                                        </div>
                                    </div>
                                    <div class="row links">
                                        <div class="col-md-6">
                                            <i class="fa fa-facebook-official fa-2x" aria-hidden="true"></i>
                                            <i class="fa fa-twitter  fa-2x" aria-hidden="true"></i>
                                            <i class="fa fa-google-plus  fa-2x" aria-hidden="true"></i>
                                        </div>
                                        <div class="col-md-6 pull-right">
                                            <span><u><a href="#" class="link"> Download</a></u></span>
                                            <span><u><a href="#" class="link"> View Full Site</a></u></span>
                                            <span><u><a href="#" class="link"> Mark as Read</a></u></span>
                                            <span><u><a href="#" class="link"> View Post</a></u></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr/>
                            <div class="row row-buffer">
                                <div class="col-md-2">
                                    <span class="glyphicon glyphicon-userCO"></span>
                                </div>
                                <div class="col-md-10">
                                    <div class="row">
                                        <div class="col-md-10">
                                            <strong> <span class="username">Uday Pratap Singh</span></strong>
                                            <span class="twitter-handler">@uday 10 min</span>
                                        </div>
                                        <div class="col-md-2 pull-right">
                                            <span><a href="#" class="link"> Grails</a></span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                                            Lorem Ipsum has been the industry's standard dummy text ever since the
                                            1500s, when an unknown printer took a galley of type and scrambled it to
                                            make a type specimen book.
                                        </div>
                                    </div>
                                    <div class="row links">
                                        <div class="col-md-6">
                                            <i class="fa fa-facebook-official fa-2x" aria-hidden="true"></i>
                                            <i class="fa fa-twitter fa-2x" aria-hidden="true"></i>
                                            <i class="fa fa-google-plus  fa-2x" aria-hidden="true"></i>
                                        </div>
                                        <div class="col-md-6 pull-right">
                                            <div class="row">
                                                <span><u><a href="#" class="link"> Download</a></u></span>
                                                <span><u><a href="#" class="link"> View Full Site</a></u></span>
                                                <span><u><a href="#" class="link"> Mark as Read</a></u></span>
                                                <span><u><a href="#" class="link"> View Post</a></u></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%--<!-- Trigger the modal with a button -->--%>
    <%--<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#sendInvitation">Open Modal--%>
    <%--</button>--%>

</div>

<%@ include file="../pageComponent/modals.jsp" %>

<%@ include file="../headerAndfooter/footer.jsp" %>
</body>
</html>