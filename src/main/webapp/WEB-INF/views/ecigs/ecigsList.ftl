<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-CIGS</title>
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css" />
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body class="container">
<#include "*/headerAdmin.ftl">
<#include "*/header.ftl">

<h1>E-CIGS</h1>

<div class="btn-group">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Sort by <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a href="all?page=0&size=10&order=price&direction=low">Price, low to high</a></li>
        <li><a href="all?page=0&size=10&order=price&direction=high">Price, high to low</a></li>
        <li><a href="all?page=0&size=10&order=name&direction=low">Alphabet, A-Z</a></li>
        <li><a href="all?page=0&size=10&order=name&direction=high">Alphabet, Z-A</a></li>
    </ul>
</div>
<br>

<#list goodsList as goods>
<div id="goodsBlock">
    <p><a href="/ecig/${goods.id}"><img width="100%" height="100%" src="/resources/image/${goods.image}"></a></p>
    <p>${goods.name}</p>
    <div style="display: inline">${goods.price}$  <div class="btn-group" roleEnum="group" aria-label="...">
        <button type="button" class="btn btn-default">Buy</button></div></div>
</div>
</#list>
<br>

<#if pages??>
    <#list pages as page>
        <#if order??>
            <#if direction??>
                <span><a href="/ecig/all?page=${page}&order=${order}&direction=${direction}">${page} ;</a></span>
            </#if>
        </#if><#else><span><a href="/ecig/all?page=${page}">${page} ;</a></span>
    </#list>
</#if>
<br>
<a href="create">Create new</a>
<br>
</body>
</html>