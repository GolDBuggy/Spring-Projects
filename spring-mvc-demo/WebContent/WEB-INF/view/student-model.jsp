<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Bisiler Yazariz</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
	
	First name: <form:input path="firstName" />
	
	<br><br>
	
		
	Last name: <form:input path="lastName" />
	
	<br><br>
	
	<form:select path="country" >
	<form:options items="${student.countryOptions}" />
	
	</form:select>
	
	<br><br>

	Favorite Language:
	<br>
	
	Java <form:radiobutton path="favoriteLanguage" value="Java"/>
	C++ <form:radiobutton path="favoriteLanguage" value="C++"/>
	Python <form:radiobutton path="favoriteLanguage" value="Python"/>
	Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

	<br><br>
	
	Ubuntu <form:checkbox path="operatingSystems" value="Ubuntu"/> 
	Mac OS<form:checkbox path="operatingSystems" value="Mac"/>	
	MS Windows <form:checkbox path="operatingSystems" value="Windows"/>
	
	<br><br>
	
	<input type="submit" value="Submit" />
	
	
	
	
	
	</form:form>
	
	


</body>

</html>