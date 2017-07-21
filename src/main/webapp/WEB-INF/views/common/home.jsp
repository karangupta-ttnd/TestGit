<%@ page import="antlr.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/assets/css/style.css" rel="stylesheet"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <header>
        <div class="row header">
            <div class="col-md-6">
                <h3><a class="link" href="#"><u> Link Sharing</u></a></h3>
            </div>
            <div class="col-md-6">
                        <span class="search-bar pull-right">
                            <span id="search-logo"><i class="glyphicon glyphicon-search"></i></span>
                            <input type="text" class="search-bar" placeholder="Search"/>
                            <span id="remove-sign"><i class="glyphicon glyphicon-remove-sign"></i></span>
                        </span>
            </div>
        </div>
    </header>

    <div class="row">
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-12">
                    <div id="recent_shares" class="panel panel-default">
                        <div class="panel-heading"><span>Recent Shares</span></div>
                        <div class="panel-body">
                            <%@ include file="../pageComponent/share.jsp" %>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div id="top_posts" class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-md-10">
                                    <span>Top Posts</span>
                                </div>
                                <div class="col-md-2 pull-right">
                                    <select class="select-border">
                                        <option>Today</option>
                                        <option>1 Week</option>
                                        <option>1 Month</option>
                                        <option>1 Year</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="row row-buffer">
                                <div class="col-md-2">
                                    <span class="glyphicon glyphicon-user"></span>
                                </div>
                                <div class="col-md-10">
                                    <div class="row">
                                        <div class="col-md-10">
                                            <strong> <span class="username">Uday Pratap Singh</span></strong>
                                            <span class="twitter-handler">@uday 21july2014</span>
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
                                        <div class="col-md-10">
                                            <i class="fa fa-facebook-official fa-2x" aria-hidden="true"></i>
                                            <i class="fa fa-twitter  fa-2x" aria-hidden="true"></i>
                                            <i class="fa fa-google-plus  fa-2x" aria-hidden="true"></i>
                                        </div>
                                        <div class="col-md-2 pull-right">
                                            <span><u><a href="#" class="link"> View Posts</a></u></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <% if (!(org.springframework.util.StringUtils.isEmpty(request.getParameter("message")))) {
                out.print("<div class=\"row\" >" +
                        "<div class=\"col-md-12 messageBox\" >" +
                        "<div class=\"error_msg\" ><span > Attention: "+ request.getParameter("message") +"</span ></div >" +
                        "</div ></div >");
            }%>
            <div class="row">
                <div id="login" class="panel panel-default">
                    <div class="panel-heading">Login</div>
                    <div class="panel-body">
                        <form:form class="form-horizontal" modelAttribute="userLogin" action="/login" name="login_form"  method="post">
                            <div class="form-group">
                                <label class="control-label col-md-5" for="user_email">
                                    <span class="pull-left">Email/Username *</span>
                                </label>
                                <div class="col-md-7">
                                    <form:input type="email" class="form-control" id="user_email" path="loginId"/><br>
                                    <span class="error_msg"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="user_pwd">
                                    <span class="pull-left"> Password * </span>
                                </label>
                                <div class="col-md-7 ">
                                    <form:input type="password" class="form-control" id="user_pwd"
                                                path="loginPass"/><br>
                                    <span class="error_msg"></span>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-md-6">
                                    <span class="pull-right" id="forgot_pwd"><a href="#"
                                                                                class="link"><u>Forgot Password</u></a></span>
                                </div>
                                <div class="col-md-6">
                                    <span class="pull-right"><button type="submit" class="btn btn-submit">Login</button></span>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div id="register" class="panel panel-default">
                    <div class="panel-heading">Register</div>
                    <div class="panel-body">
                       <form:form class="form-horizontal" action="/register" method="POST" name="register_form" modelAttribute="userRegister" enctype="multipart/form-data">

                            <div class="form-group">
                                <label class="control-label col-md-5" for="first_name">
                                    <span class="pull-left"> First Name *  </span>
                                </label>
                                <div class="col-md-7">
                                    <form:input type="text" class="form-control" id="first_name" path="firstName"
                                                required="required"/><br>
                                    <span class="error_msg"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="last_name">
                                    <span class="pull-left"> Last Name *  </span>
                                </label>
                                <div class="col-md-7">
                                    <form:input type="text" class="form-control" id="last_name" path="lastName"
                                                required="required"/><br>
                                    <span class="error_msg"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="email">
                                    <span class="pull-left">   Email *  </span>
                                </label>
                                <div class="col-md-7">
                                    <form:input type="email" class="form-control" id="email" path="email"
                                                required="required"/><br>
                                    <span class="error_msg"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="user_name">
                                    <span class="pull-left">  Username *  </span>
                                </label>
                                <div class="col-md-7">
                                    <form:input type="text" class="form-control" id="user_name" path="username"
                                                required="required"/><br>
                                    <span class="error_msg"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="pwd">
                                    <span class="pull-left">  Password *  </span>
                                </label>
                                <div class="col-md-7 ">
                                    <form:input type="password" class="form-control" id="pwd" path="password"
                                                required="required"/><br>
                                    <span class="error_msg"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="confirm_pwd">
                                    <span class="pull-left"> Confirm Password*  </span>
                                </label>
                                <div class="col-md-7 ">
                                    <input type="password" class="form-control" id="confirm_pwd" name="confirm_pwd" required><br>
                                    <span class="error_msg"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="user_photo">
                                    <span class="pull-left"> Photo </span>
                                </label>
                                <div class="col-md-7 ">
                                    <form:input type="file" class="form-control" id="user_photo" path="multipartFile"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="pull-right">
                                        <form:button type="submit" class="btn btn-submit">Register</form:button>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--Sign on modal--%>
<div class="modal fade" id="signOn" role="dialog">
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

<script type="text/javascript" src="/assets/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/assets/js/jquery.validate.js"></script>
<script type="text/javascript" src="/assets/js/script.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>