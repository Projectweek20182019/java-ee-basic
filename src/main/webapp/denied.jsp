<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="components/header.jspf"%>
<div class="container">
    <!-- Jumbotron -->
    <div class="jumbotron">
        <h1><i class="fa fa-frown-o red"></i> Access Denied</h1>
        <p class="lead">You need to be logged on to access that page!</p>
        <p><a href="/" class="btn btn-default btn-lg"><span class="green">Take Me To The Login</span></a></p>
    </div>
</div>
<div class="container">
    <div class="body-content">
        <div class="row">
            <div class="col-md-6">
                <h2>What happened?</h2>
                <p class="lead">Mysteriously, you made your way to a page you can only access once logged in.</p>
            </div>
            <div class="col-md-6">
                <h2>What can I do?</h2>
                <p class="lead">Don't Panic! Login, and then try again.</p>
            </div>
        </div>
    </div>
</div>
<%@ include file="components/footer.jspf"%>
