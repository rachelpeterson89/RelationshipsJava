<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Person</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<h2>Add A New Person:</h2>
	
	<form:form action="/person/create" method="post" modelAttribute="person">
		<input type="hidden" name="_method" value="post" />
		<div class="form-group">
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName" />
			<form:input path="firstName" type="text" name="firstName" class="form-control" />
		</div>
		
		<div class="form-group">
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName" />
			<form:input path="lastName" type="text" name="lastName" class="form-control" />
		</div>
		
		<button class="btn btn-outline-dark">Create</button>
	</form:form>
	
</body>
</html>