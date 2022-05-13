<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leader Page</title>
</head>
<body>
<h2>Welcome BOSS</h2>
<hr>

<p>See you in brazil! [Carnavale :-)]</p>
<br>
<p>Role: <security:authentication property="principal.authorities" /></p>
<hr>
</body>
</html>
