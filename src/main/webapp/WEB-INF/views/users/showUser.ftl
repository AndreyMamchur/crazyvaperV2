<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "*/header.ftl">
<div class="table-responsive">
    <caption>User info</caption>
    <table class="table table-striped">
        <tr>
            <td>Id</td>
            <td>${user.id}</a></td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${user.email}</td>
        </tr>
        <td>Date Of Birth</td>
        <td><#if user.dateOfBirth??>${user.dateOfBirth}<#else> </#if></td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td>${user.phoneNumber}</td>
        </tr>
        <tr>
            <td>Password</td>
            <td>${user.password}</td>
        </tr>
        <tr>
            <td><a href="delete/${user.id}">Delete</a></td>
            <td><a href="${user.id}?edit=true">Edit</a></td>
        </tr>
    </table>
</div>

<a type="button" href="/user/all?page=0&size=10" class="button">Back</a>
</body>
</html>