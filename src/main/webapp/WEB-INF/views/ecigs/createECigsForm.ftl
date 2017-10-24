<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ECIGSData</title>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "*/header.ftl">

<#if errors??>
EROOR:
    <#list errors as error>
    <h1>error</h1><br>
    </#list>
</#if>


<form action="create" method="post" name="eCig" class="form-group">
    Name
    <input title="Name" type="text" name="name" required/>
    Color
    <input title="Color" type="text" name="color" required/>
    Brands
    <input title="Brand" type="text" name="brands" required/>
    Price
    <input title="Price" type="number" size=30 min="0" step=0.01 name="price" required/>
    Product description
    <input title="Product description" type="text" name="productDescription" required/>
    Image
    <input title="Image" type="text" name="image" required/>
    <input type="submit" value="Create"/>
</form>
<a type="button" href="/ecig/all" class="button">Back</a>
</body>
</html>