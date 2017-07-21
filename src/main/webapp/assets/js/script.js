//for page onload actions
$(function () {
    //form valdation at home page
    $("form[name='register_form']").validate({
        // Specify validation rules
        rules: {
            firstName: "required",
            lastName: "required",
            email: {
                required: true,
                email: true
            },
            username: "required",
            password: {
                required: true,
                minlength: 5
            },
            confirm_pwd: {
                required: true,
                minlength: 5,
                equalTo: "#pwd"
            },
            user_photo:{
                accept: "image/*"
            }
        },
        // Specify validation error messages
        messages: {
            firstname: "Please enter your firstname",
            lastname: "Please enter your lastname",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            email: "Please enter a valid email address",
            confirm_pwd: "Password should match",
            user_photo:"Accepts only image file"
        },
        submitHandler: function (form) {
            form.submit();
        }
    });

    $("form[name='login_form']").validate({
        // Specify validation rules
        rules: {
            loginId: "required",
            loginPass: {
                required: true,
                minlength: 5
            }
        },
        // Specify validation error messages
        messages: {
            loginId: "Please enter your EmailID or Username",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
//    form validation at home page end


//field validation when adding topic
    $("add_topic_form").validate({
        rules: {
            topicName: {
                required: true,
                minlength: 3
                // remote: {
                //     url: '/validate_topic_name',
                //     type: "POST",
                //     data: {
                //             topic_name: function()
                //             {
                //                 return $('#topicName').val();
                //             }
                //         }
                // }
            }
        },
        // Specify validation error messages
        messages: {
            topicName: {
                required:"Enter valid topic name",
                minlength: "Your topic name must be at least 3 characters long"
            }
        }
    });


    //field validation when sharing topic link
    $("share_link_form").validate({
        rules: {
            topic_url: {
                required: true,
                minlength: 10
            },
            link_Description:{
                required: true,
                minlength: 10
            },
            link_topic:{
                required: true,
            }
        },
        // Specify validation error messages
        messages: {
            topic_url: {
                required:"Enter valid topic related url",
                minlength: "Your topic url must be at least 10 characters long"
            },
            link_Description:{
                required:"Enter description",
                minlength: "Your topic name must be at least 10 characters long"
            },
            link_topic:{
                required:"Enter valid topic name",
            }
        }
    });

//  form file upload
    var file = $('[name="resourceFile"]');
//    form file upload


});//end of document ready


$('#remove-sign').click(function () {
    $("#search-input").val('');
});


function some() {
    alert("s");
}

//to save topic
$("#saveTopic").click(function () {

    // if ($("add_topic_form").valid()) {
        var Topic = {
            name : $("#topicName").val(),
            visibility : $("#visibility").val()
        };


        $.ajax({
            url: "/add_new_topic",
            type: 'POST',
            data: JSON.stringify(Topic),
            contentType: "application/json",
            success: function (result) {
                alert(JSON.stringify(result));
            },
            error: function (e) {
                alert("Error check console");
                console.log(">>>>Error here:" + JSON.stringify(e));
            }

        });
    // }

});


//to save link
$("#saveLink").click(function () {

    // if ($("share_link_form").valid()) {
    var Link = {
        url : $("#url").val(),
        description : $("#link_Description").val(),
        topicId : $("#topicId").val()
    };


    $.ajax({
        url: "/add_resource_link",
        type: 'POST',
        data: JSON.stringify(Link),
        contentType: "application/json",
        success: function (result) {
            alert(JSON.stringify(result));
        },
        error: function (e) {
            alert("Error check console");
            console.log(">>>>Error here:" + JSON.stringify(e));
        }

    });
    // }

});


//to save resource document
$("#saveDocument").click(function () {

    // if ($("saveResourceDocument").valid()) {

    $.ajax({
        url: '/save_resource_document',
        type: "POST",
        data: new FormData(document.getElementById("saveResourceDocument")),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        success: function (result) {
            alert(JSON.stringify(result));
        },
        error: function (e) {
            alert("Error check console");
            console.log(">>>>Error here:" + JSON.stringify(e));
        }

    });

});