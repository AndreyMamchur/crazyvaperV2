<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PaymentsData</title>
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css" />
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "*/header.ftl">

<h1>Payments list</h1>
<table class="table table-striped">
    <tr id="nameOfColumns">
        <th>Id</th>
        <th>Cart ID</th>
        <th>User Name</th>
        <th>Status</th>
        <th>Total Price</th>
        <th>Buttons</th>
    </tr>
<#list payments as payment>
    <tr>
        <td><a href="/payment/${payment.id}">${payment.id}</a></td>
        <td>${payment.cartId}</td>
        <td>${payment.user.name}</td>
        <td>${payment.status}</td>
        <td>${payment.totalPrice}</td>
        <td><a href="delete/${payment.id}">Delete</a>
            <a href="${payment.id}?edit=true">Edit</a>
        </td>
    </tr>
</#list>
</table>

<br>

<br>
</body>
</html>