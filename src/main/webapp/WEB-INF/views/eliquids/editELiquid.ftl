<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ECIGData</title>
</head>
<body class="container">
<#include "*/headerAdmin.ftl">
<#include "*/header.ftl">

<form action="update" method="post" name="eLiquid" class="form-group">

    <input title="Id" type="number" name="id" value="${eLiquid.id}" hidden/>
    Name
    <input title="Name" type="text" name="name" value="${eLiquid.name}"/>
    Nicotine Strength
    <input title="Nicotine Strength" type="text" name="nicotineStrength" value="${eLiquid.nicotineStrength}"/>
    Brands
    <input title="Brand" type="text" name="brands" value="${eLiquid.brands}"/>
    Price
    <input title="Price" type="number" size=30 min="0" step=0.01 name="price" value="${eLiquid.price?c}"/>
    Product description
    <input title="Product description" type="text" name="productDescription" value="${eLiquid.productDescription}"/>
    Image
    <input title="Image" type="text" name="image" value="${eLiquid.image}"/>
    <input type="submit" value="Update"/>
</form>
<a type="button" href="${eLiquid.id}" class="button">Back</a>
</body>
</html>