<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EROR PAGE</title>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "headerAdmin.ftl">
</@security.authorize>
<#include "header.ftl">

<h1>I'm errrrror page!</h1>

<div>
    <a href="/" class="button">Go Home</a>
</div>
</body>
</html>