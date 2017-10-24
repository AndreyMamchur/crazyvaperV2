<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PaymentData</title>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "*/header.ftl">
<div class="table-responsive">
    <caption>Payment info</caption>
    <table class="table table-striped">
        <tr>
            <td>Id</td>
            <td>${payment.id}</a></td>
        </tr>
        <tr>
            <td>Cart ID</td>
            <td>${payment.cartId}</td>
        </tr>
        <tr>
            <td>User Name</td>
            <td>${payment.user.name}</td>
        </tr>
        <td>Status</td>
        <td>${payment.status}</td>
        </tr>
        <tr>
            <td>Total Price</td>
            <td>${payment.totalPrice}</td>
        </tr>
        <tr>
            <td><a href="delete/${payment.id}">Delete</a></td>
            <td><a href="${payment.id}?edit=true">Edit</a></td>
        </tr>
    </table>
</div>

<a type="button" href="/payment/all?page=0&size=10" class="button">Back</a>
</body>
</html>