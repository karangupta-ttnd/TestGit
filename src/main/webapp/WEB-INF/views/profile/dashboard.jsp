<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="assets/css/style.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <header>
        <%@ include file="../header/header.jsp" %>
    </header>

    <div class="row">

        <div class="col-md-4">
            <div class="row">
                <div class="col-md-12">
                    <div id="subscribers-detail" class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-3">
                                    <%--<span class="glyphicon glyphicon-userCO"></span>--%>
                                    <img class="profilePic" alt="No Profile Pic" src="data:image/jpeg;base64,<%=session.getAttribute("userImage")%>"/>
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


<!-- shareLink Modal -->
<div class="modal fade" id="shareLink" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Link</h4>
            </div>
            <div class="modal-body ">
                <div class="row form-group">
                    <div class="col-md-4">
                        <span>Link*:</span>
                    </div>
                    <div class="col-md-8 form-group">
                        <input type="text" class="form-control select-border" id="" placeholder="Link"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 form-group">
                        <span>Description*:</span>
                    </div>
                    <div class="col-md-8 form-group">
                        <textarea class="form-control select-border" id="Description"
                                  placeholder="Description"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 form-group">
                        <span>Topic*:</span>
                    </div>
                    <div class="col-md-8 form-group">
                        <select class="form-control select-border">
                            <option>--Select--</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="pull-right">
                            <button type="button" class="btn btn-default">Share</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>-->
        </div>

    </div>
</div>

<!--shareDocument Modal -->
<div class="modal fade" id="shareDocument" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Document</h4>
            </div>
            <div class="modal-body ">
                <div class="row form-group">
                    <div class="col-md-4">
                        <span>Document*:</span>
                    </div>
                    <div class="col-md-8 form-group">
                        <input type="file" class="form-control select-border" id=""/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 form-group">
                        <span>Description*:</span>
                    </div>
                    <div class="col-md-8 form-group">
                        <textarea class="form-control select-border" id="Description"
                                  placeholder="Description"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 form-group">
                        <span>Topic*:</span>
                    </div>
                    <div class="col-md-8 form-group">
                        <select class="select-border form-control">
                            <option>--Select--</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="pull-right">
                            <button type="button" class="btn btn-default">Share</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<!--createTopic Modal -->
<div class="modal fade" id="createTopic" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Topic</h4>
            </div>
            <div class="modal-body ">
                <div class="row form-group">
                    <div class="col-md-4">
                        <span>Name*:</span>
                    </div>
                    <div class="col-md-8 form-group">
                        <input type="text" class="form-control select-border" id="" placeholder="Name"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 form-group">
                        <span>Visibility*:</span>
                    </div>
                    <div class="col-md-8 form-group">
                        <select class="select-border form-control">
                            <option>Public</option>
                            <option>Private</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="pull-right">
                            <button type="button" class="btn btn-default">Save</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--sendInvitation Modal -->
<div class="modal fade" id="sendInvitation" role="dialog">
    <div class="modal-dialog modal-sm">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>
            <div class="modal-body ">
                <div class="row form-group">
                    <div class="col-md-4">
                        <span>Name*:</span>
                    </div>
                    <div class="col-md-8 form-group">
                        <input type="text" class="form-control select-border" id="" placeholder="Email"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 form-group">
                        <span>Topic*:</span>
                    </div>
                    <div class="col-md-8 form-group">
                        <select class="select-border form-control">
                            <option>--Select--</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="pull-right">
                            <button type="button" class="btn btn-default">Invite</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<script type="text/javascript" src="assets/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="assets/js/script.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>