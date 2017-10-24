<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ECIGData</title>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "*/header.ftl">
<div class="table-responsive">
    <caption>ECIG info</caption><br>
    <img width="40%" height="40%" src="/resources/image/${eCig.image}">
    <table class="table table-striped">

        <tr>
            <td>Name</td>
            <td>${eCig.name}</td>
        </tr>
        <tr>
            <td>Color</td>
            <td>${eCig.color}</td>
        </tr>
        <tr>
            <td>Brands</td>
            <td>${eCig.brands}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${eCig.price}</td>
        </tr>
        <tr>
            <td>Product description</td>
            <td>${eCig.productDescription}</td>
        </tr>
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
        <tr>
            <td>Updated time</td>
            <td>${eCig.updatedTime}</td>
        </tr>
        <tr>
            <td><a href="delete/${eCig.id}">Delete</a></td>
            <td><a href="${eCig.id}?edit=true">Edit</a></td>
        </tr>
</@security.authorize>
    </table>
</div>
<a type="button" href="all" class="button">Back</a>
</body>
</html>