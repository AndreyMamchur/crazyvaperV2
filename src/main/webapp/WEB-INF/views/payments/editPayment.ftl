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

<form action="update" method="post" name="payment" class="form-group">
    <input title="Id" type="number" name="id" value="${payment.id}" hidden/>
    Cart ID
    <input title="Cart ID" type="number" name="cartId" value="${payment.cartId}"/>
    User ID
    <input title="User ID" type="number" name="userId" value="${payment.userId}"/>
    Status
    <input title="Status" type="text" name="status" value="${payment.status}"/>
    Total Price
    <input title="Total Price" type="number" size=30 min="0" step=0.01 name="totalPrice" value="${payment.totalPrice?c}"/>
    Password
    <input type="submit" value="Edit!"/>
</form>
<a type="button" href="/payment/all?page=0&size=10" class="button">Back</a>
</body>
</html>