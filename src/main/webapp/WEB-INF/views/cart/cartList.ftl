<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css" />
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
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "*/header.ftl">

<h1>Carts list</h1>
<table class="table">
    <tr id="nameOfColumns">
        <th width="20%">Id</th>
        <th width="80%">Goods</th>
    </tr>
<#list cartList as cart>
    <tr>
        <td width="20%"><a href="/cart/${cart.id}">${cart.id}</a>
        <td width="80%">
            <#list cart.productsList as goods>
                <table class="table", border="0">
                    <tr >
                        <td style="border-width: 0px;border:none none;" width="50%">${goods.name}</td>
                        <td style="border-width: 0px;border:none none;" width="50%">${goods.price}$</td>
                    </tr>
                </table>
            </#list>
        </td>
    </tr>
</#list>
</table>

<br>

<br>
</body>
</html>