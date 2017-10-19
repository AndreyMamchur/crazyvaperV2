<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ECIGData</title>
</head>
<body class="container">
<#include "*/headerAdmin.ftl">
<#include "*/header.ftl">
<div class="table-responsive">
    <caption>ECIG info</caption><br>
    <a href="/ecig/${eCig.id}"><img width="40%" height="40%" src="/resources/image/${eCig.image}"></a>
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
        <tr>
            <td>Updated time</td>
            <td>${eCig.updatedTime}</td>
        </tr>
        <tr>
            <td><a href="delete/${eCig.id}">Delete</a></td>
            <td><a href="${eCig.id}?edit=true">Edit</a></td>
        </tr>
    </table>
</div>
<a type="button" href="all" class="button">Back</a>
</body>
</html>