<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IT Page</title>
</head>
<body>

<h2>Hello IT Folks!</h2>
<hr>

<p>You are in IT Meeting Page!</p>
<br>
<p>Role: <security:authentication property="principal.authorities" /></p>
<hr>

</body>
</html>
