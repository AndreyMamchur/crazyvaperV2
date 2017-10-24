<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MODData</title>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "*/header.ftl">
<div class="table-responsive">
    <caption>MOD info</caption><br>
    <img width="40%" height="40%" src="/resources/image/${mod.image}">
    <table class="table table-striped">

        <tr>
            <td>Name</td>
            <td>${mod.name}</td>
        </tr>
        <tr>
            <td>Color</td>
            <td>${mod.color}</td>
        </tr>
        <tr>
            <td>Brands</td>
            <td>${mod.brands}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${mod.price}</td>
        </tr>
        <tr>
            <td>Product description</td>
            <td>${mod.productDescription}</td>
        </tr>
        <tr>
            <td>Updated time</td>
            <td>${mod.updatedTime}</td>
        </tr>
        <tr>
            <td><a href="delete/${mod.id}">Delete</a></td>
            <td><a href="${mod.id}?edit=true">Edit</a></td>
        </tr>
    </table>
</div>
<a type="button" href="all" class="button">Back</a>
</body>
</html>