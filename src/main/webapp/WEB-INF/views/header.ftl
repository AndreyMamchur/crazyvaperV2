<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header">
            <a class="navbar-brand" href="/">HOME</a>
        </div>
        <ul class="nav navbar-nav navbar-left">
            <li class=""><a href="/ecig/all?page=0&size=10">E-CIGS</a></li>
            <li class=""><a href="/eliquid/all?page=0&size=10">E-LIQUID</a></li>
            <li class=""><a href="/mod/all?page=0&size=10">MODS</a></li>
            <li class=""><a href="/atomizer/all?page=0&size=10">ATOMIZERS</a></li>
            <li class=""><a href="/">BRANDS</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <@security.authorize access="isAnonymous()">
                <li class="active"><a href="/loginAndRegistration">Login please</a></li>
            </@security.authorize>
            <@security.authorize access="isAuthenticated()">
            <li class="active"><a>Hello, <@security.authentication property="principal.username"/></a></li>
                <li class="active"><a href="/logout">Logout</a></li>
            </@security.authorize>
        </ul>
    </div>

</nav>