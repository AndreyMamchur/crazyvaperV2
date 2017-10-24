<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MODSData</title>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "*/header.ftl">

<form action="update" method="post" name="mods" class="form-group">

    <input title="Id" type="number" name="id" value="${mod.id}" hidden/>
    Name
    <input title="Name" type="text" name="name" value="${mod.name}"/>
    Color
    <input title="Color" type="text" name="color" value="${mod.color}"/>
    Brands
    <input title="Brand" type="text" name="brands" value="${mod.brands}"/>
    Price
    <input title="Price" type="number" size=30 min="0" step=0.01 name="price" value="${mod.price?c}"/>
    Product description
    <input title="Product description" type="text" name="productDescription" value="${mod.productDescription}"/>
    Image
    <input title="Image" type="text" name="image" value="${mod.image}"/>
    <input type="submit" value="Update"/>
</form>
<a type="button" href="${mod.id}" class="button">Back</a>
</body>
</html>