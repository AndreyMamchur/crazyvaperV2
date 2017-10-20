<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css" />
</head>
<body class="container">
<#include "*/headerAdmin.ftl">
<#include "*/header.ftl">

<#if errors??>
EROOR:
    <#list errors as error>
    <h1>error</h1><br>
    </#list>
</#if>

<form action="create" method="post" name="user" class="form-group">
    <p>Name</p>
    <input title="Name" type="text" name="name" required/>
    <p>Email</p>
    <input title="Email" type="email" name="email" required/>
    <p>Password</p>
    <input title="Password" type="password" name="password" required/>
    <p>Phone Number</p>
    <input title="Phone Number" type="text" name="phoneNumber"/>
    <p>Date of Birth</p>
    <input title="Date of Birth" type="date" name="dateOfBirth"/>
    <input type="submit" title="OK" value="OK!"/>
</form>
<a type="button" href="/all" class="button">Back</a>
</body>
</html>