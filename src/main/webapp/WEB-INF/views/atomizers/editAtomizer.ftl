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

<form action="update" method="post" name="atomizer" class="form-group">

    <input title="Id" type="number" name="id" value="${atomizer.id}" hidden/>
    Name
    <input title="Name" type="text" name="name" value="${atomizer.name}"/>
    Color
    <input title="Color" type="text" name="color" value="${atomizer.color}"/>
    Brands
    <input title="Brand" type="text" name="brands" value="${atomizer.brands}"/>
    Price
    <input title="Price" type="number" size=30 min="0" step=0.01 name="price" value="${atomizer.price?c}"/>
    Product description
    <input title="Product description" type="text" name="productDescription" value="${atomizer.productDescription}"/>
    Image
    <input title="Image" type="text" name="image" value="${atomizer.image}"/>
    <input type="submit" value="Update"/>
</form>
<a type="button" href="${atomizer.id}" class="button">Back</a>
</body>
</html>