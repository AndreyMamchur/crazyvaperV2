<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="resources/css/style.css" type="text/css" />
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "WEB-INF/views/headerAdmin.ftl">
</@security.authorize>
<#include "WEB-INF/views/header.ftl">

<h1>FEATURED PRODUCTS</h1>

<#list goodsList as goods>
<div id="goodsBlock">
    <p><a href="/goods/${goods.id}"><img width="100%" height="100%" src="/resources/image/${goods.image}"></a></p>
    <p>${goods.name}</p>
    <div style="display: inline">${goods.price}$  <div class="btn-group" roleEnum="group" aria-label="...">
        <button type="button" class="btn btn-default" formaction="">Buy</button></div></div>
</div>
</#list>

<#--<#if pages??>-->
    <#--<#list pages as page>-->
        <#--<span><a href="/?page=${page}">${page} ;</a></span>-->
    <#--</#list>-->
<#--</#if>-->

</body>
</html>