<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css" />
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="container">
<#include "*/headerAdmin.ftl">
<#include "*/header.ftl">

<h1>Users list</h1>
<table class="table table-striped">
    <tr id="nameOfColumns">
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Date of Birth</th>
        <th>Phone Number</th>
        <th>password</th>
        <th>Buttons</th>
    </tr>
<#list users as user>
    <tr>
        <td><a href="/user/${user.id}">${user.id}</a></td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td><#if user.dateOfBirth??>${user.dateOfBirth}<#else> </#if></td>
        <td>${user.phoneNumber}</td>
        <td>${user.password}</td>
        <td><a href="/delete/${user.id}">Delete</a>
            <a href="/edit/${user.id}">Edit</a>
        </td>
    </tr>
</#list>
</table>

<br>
<a href="create">Create new</a>
<br>
</body>
</html>