<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
</head>
<body class="container">
<@security.authorize access="hasAnyRole('ADMIN', 'SALESMANAGER')">
    <#include "*/headerAdmin.ftl">
</@security.authorize>
<#include "header.ftl">
<table class="table" id="loginAndRegistration">
    <tr>
        <th>
            <legend>Log in</legend>
            <form action="/loginAndRegistration" method="post" name="user" class="form-group">
                <p>Email</p>
                <input title="Email" type="email" name="email"/>
                <p>Password</p>
                <input title="Password" type="password" name="password"/>
                <input type="submit" value="Login"/>
            </form>
        </th>
        <th>
            <legend>Registration</legend>
            <form action="/registrationUser" method="post" name="user" class="form-group">
                <p>Name</p>
                <input title="Name" type="text" name="name"/>
                <p>Email</p>
                <input title="Email" type="email" name="email"/>
                <p>Password</p>
                <input title="Password" type="password" name="password"/>
                <input type="submit" title="OK" value="OK!"/>
            </form>
        </th>
    </tr>
</table>
</body>
</html>