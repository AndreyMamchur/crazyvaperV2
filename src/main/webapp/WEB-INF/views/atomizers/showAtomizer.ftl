<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ATOMIZERData</title>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "*/header.ftl">
<div class="table-responsive">
    <caption>ATOMIZER INFO</caption><br>
    <img width="40%" height="40%" src="/resources/image/${atomizer.image}">
    <table class="table table-striped">

        <tr>
            <td>Name</td>
            <td>${atomizer.name}</td>
        </tr>
        <tr>
            <td>Color</td>
            <td>${atomizer.color}</td>
        </tr>
        <tr>
            <td>Brands</td>
            <td>${atomizer.brands}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${atomizer.price}</td>
        </tr>
        <tr>
            <td>Product description</td>
            <td>${atomizer.productDescription}</td>
        </tr>
        <tr>
            <td>Updated time</td>
            <td>${atomizer.updatedTime}</td>
        </tr>
        <tr>
            <td><a href="delete/${atomizer.id}">Delete</a></td>
            <td><a href="${atomizer.id}?edit=true">Edit</a></td>
        </tr>
    </table>
</div>
<a type="button" href="all" class="button">Back</a>
</body>
</html>