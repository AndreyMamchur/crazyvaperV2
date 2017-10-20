<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
</head>
<body class="container">
<#include "*/headerAdmin.ftl">
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
    </table>
</div>

<a type="button" href="all" class="button">Back</a>
</body>
</html>