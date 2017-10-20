<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ELiquidData</title>
</head>
<body class="container">
<#include "*/headerAdmin.ftl">
<#include "*/header.ftl">
<div class="table-responsive">
    <caption>ELIQUID INFO</caption><br>
    <img width="40%" height="40%" src="/resources/image/${eLiquid.image}">
    <table class="table table-striped">

        <tr>
            <td>Name</td>
            <td>${eLiquid.name}</td>
        </tr>
        <tr>
            <td>Nicotine Strength</td>
            <td>${eLiquid.nicotineStrength}</td>
        </tr>
        <tr>
            <td>Brands</td>
            <td>${eLiquid.brands}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${eLiquid.price}</td>
        </tr>
        <tr>
            <td>Product description</td>
            <td>${eLiquid.productDescription}</td>
        </tr>
        <tr>
            <td>Updated time</td>
            <td>${eLiquid.updatedTime}</td>
        </tr>
        <tr>
            <td><a href="delete/${eLiquid.id}">Delete</a></td>
            <td><a href="${eLiquid.id}?edit=true">Edit</a></td>
        </tr>
    </table>
</div>
<a type="button" href="all" class="button">Back</a>
</body>
</html>