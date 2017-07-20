<%--
  Created by IntelliJ IDEA.
  User: karan
  Date: 18/7/17
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/css/style.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<div class="row header">
    <div class="col-md-6">
        <h3><a class="link" href="#"><u> Link Sharing</u></a></h3>
    </div>
    <div class="col-md-6">
        <div class="row">
            <div class="col-md-5">
										<span class="search-bar pull-right">
												<span id="search-logo"><i class="glyphicon glyphicon-search"></i></span>
												<input type="text" id="search-input" class="search-bar"
                                                       placeholder="Search"/>
												<span id="remove-sign"><i class="glyphicon glyphicon-remove-sign "></i></span>
										</span>
            </div>
            <div class="col-md-3">
										<span class="top-right-links pull-right">
												<span data-toggle="modal" data-target="#createTopic"><i class="fa fa-comment"></i></span>
												<span data-toggle="modal" data-target="#sendInvitation"><i class="glyphicon glyphicon-envelope"></i></span>
												<span data-toggle="modal" data-target="#shareLink"><i class="glyphicon glyphicon-link"></i></span>
												<span data-toggle="modal" data-target="#shareDocument"><img src="assets/icons/new-file.png" alt="new file"
                                                           class="new-file"/></span>
										</span>
            </div>
            <div class="col-md-4">
                <div class="top-right-links pull-right">
                    <div class="row">
                        <div class="col-md-2">
                            <span class="glyphicon glyphicon-userCO smallIcon"></span>
                        </div>
                        <div class="col-md-10">
                            <span id="profile-menu" data-toggle="dropdown">
							<span class="userCO-name"><p> <%=session.getAttribute("firstName") + " " + session.getAttribute("lastName")%>
                                    <span class="caret"></span></p></span>
                            </span>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="profile-menu">
                                <li role="presentation"><a role="menuitem" href="#">Profile</a></li>
                                <li role="presentation"><a role="menuitem" href="#">Users</a></li>
                                <li role="presentation"><a role="menuitem" href="#">Topics</a></li>
                                <li role="presentation"><a role="menuitem" href="/logout">Logout</a></li>
                                <!--<li role="presentation" class="divider"></li>    -->
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>