<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Welcome Spring Security!</h1>
    <hr>

    <p>You are in home page now :)</p>
    <br>

    <hr>
    <p>
        User: <security:authentication property="principal.username" />
    </p>
    <br>
    <p>
        Roles: <security:authentication property="principal.authorities" />
    </p>
    <hr>
    <br>
    <security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leader Page</a>
        (Only Manager)
    </p>
    </security:authorize>
    <br>

    <security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT Meeting Page</a>
        (Only IT folks )
    </p>
    </security:authorize>
    <br>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />
    </form:form>
</body>
</html>
