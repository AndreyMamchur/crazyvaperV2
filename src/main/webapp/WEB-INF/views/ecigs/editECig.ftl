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

<form action="update" method="post" name="eCig" class="form-group">

    <input title="Id" type="number" name="id" value="${eCig.id}" hidden/>
    Name
    <input title="Name" type="text" name="name" value="${eCig.name}"/>
    Color
    <input title="Color" type="text" name="color" value="${eCig.color}"/>
    Brands
    <input title="Brand" type="text" name="brands" value="${eCig.brands}"/>
    Price
    <input title="Price" type="number" size=30 min="0" step=0.01 name="price" value="${eCig.price?c}"/>
    Product description
    <input title="Product description" type="text" name="productDescription" value="${eCig.productDescription}"/>
    Image
    <input title="Image" type="text" name="image" value="${eCig.image}"/>
    <input type="submit" value="Update"/>
</form>
<a type="button" href="${eCig.id}" class="button">Back</a>
</body>
</html>