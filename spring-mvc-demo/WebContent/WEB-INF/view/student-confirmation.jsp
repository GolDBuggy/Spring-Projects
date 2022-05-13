<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Umarim Yazicaz</title>
</head>

<body>

Student Confirmed: ${student.firstName} ${student.lastName} 

<br>
 Country: ${student.country}
<br>
Favorite Language: ${student.favoriteLanguage }
<br>
Operating Systems: 

<ul>
   <c:forEach var="temp" items="${student.operatingSystems}" >
   <li>${temp}</li>
   </c:forEach>
</ul>

${student.operatingSystems }
</body>

</html>