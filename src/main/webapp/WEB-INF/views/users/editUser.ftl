<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "*/header.ftl">

<form action="update" method="post" name="user" class="form-group">
    <input title="Id" type="number" name="id" value="${user.id}" hidden/>
    Name
    <input title="Name" type="text" name="name" value="${user.name}"/>
    Email
    <input title="Email" type="email" name="email" value="${user.email}"/>
    Date of Birth
    <input title="Date of Birth" type="date" name="dateOfBirth" value="${user.dateOfBirth?iso_local}"/>
    PhoneNumber
    <input title="Phone Number" type="text" name="phoneNumber" value="${user.phoneNumber}"/>
    Password
    <input title="Password" type="text" name="password" value="${user.password}"/>
    <input type="submit" value="Edit!"/>
</form>
<a type="button" href="/user/all?page=0&size=10" class="button">Back</a>
</body>
</html>