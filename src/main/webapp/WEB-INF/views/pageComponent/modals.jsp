<%--
  Created by IntelliJ IDEA.
  User: karan
  Date: 21/7/17
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
                <form name="share_link_form">
                    <div class="row form-group">
                        <div class="col-md-4">
                            <span>Link*:</span>
                        </div>
                        <div class="col-md-8 form-group">
                            <input type="text" class="form-control select-border" id="url" name="url"
                                   placeholder="Link"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 form-group">
                            <span>Description*:</span>
                        </div>
                        <div class="col-md-8 form-group">
                        <textarea class="form-control select-border" id="link_Description" name="description"
                                  placeholder="Description"></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 form-group">
                            <span>Topic*:</span>
                        </div>
                        <div class="col-md-8 form-group">
                            <select class="form-control select-border" id="topicId" name="topicId">
                                <c:forEach items="${topicList}" var="topic">
                                    <option value="<c:out value="${topic.id}" />"><c:out value="${topic.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
                <div class="row">
                    <div class="col-md-12">
                        <div class="pull-right">
                            <button type="button" class="btn btn-default" id="saveLink">Share</button>
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
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Document</h4>
            </div>
            <form name="saveResourceDocument" id="saveResourceDocument" >
                <div class="modal-body ">
                    <div class="row form-group">
                        <div class="col-md-4">
                            <span>Document*:</span>
                        </div>
                        <div class="col-md-8 form-group">
                            <input type="file" class="form-control select-border" id="resourceFile" name="resourceFile"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 form-group">
                            <span>Description*:</span>
                        </div>
                        <div class="col-md-8 form-group">
                        <textarea class="form-control select-border" id="document_Description" name="document_Description"
                                  placeholder="Description"></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 form-group">
                            <span>Topic*:</span>
                        </div>
                        <div class="col-md-8 form-group">
                            <select class="select-border form-control" id="resourceTopic" name="resourceTopic">
                                <c:forEach items="${topicList}" var="topic">
                                    <option value="<c:out value="${topic.id}" />"><c:out
                                            value="${topic.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
            </form>
            <div class="row">
                <div class="col-md-12">
                    <div class="pull-right">
                        <button type="button" class="btn btn-default" id="saveDocument">Share</button>
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
                <form name="add_topic_form">
                    <div class="row form-group">
                        <div class="col-md-4">
                            <span>Name*:</span>
                        </div>
                        <div class="col-md-8 form-group">
                            <input type="text" class="form-control select-border" id="topicName" name="topicName"
                                   placeholder="Name"/>
                            <span class="error_msg"></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 form-group">
                            <span>Visibility*:</span>
                        </div>
                        <div class="col-md-8 form-group">
                            <select class="select-border form-control" id="visibility" name="visibility">
                                <option value="_PUBLIC" selected>Public</option>
                                <option value="_PRIVATE">Private</option>
                            </select>
                            <span class="error_msg"></span>
                        </div>
                    </div>
                </form>
                <div class="row">
                    <div class="col-md-12">
                        <div class="pull-right">
                            <button type="button" class="btn btn-default" id="saveTopic">Save</button>
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
                            <c:forEach items="${topicList}" var="topic">
                                <option value="<c:out value="${topic.id}" />"><c:out value="${topic.name}"/></option>
                            </c:forEach>
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