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
	<h2>Add A License:</h2>
	
	<form:form action="/license/create" method="post" modelAttribute="license">
		<input type="hidden" name="_method" value="post" />
		
		<div class="form-group">
			<form:label path="person">Person:</form:label>
			<form:errors path="person" />
			<form:select path="person">
			<form:options items="${persons}" itemValue="id" itemLabel="firstName" />
			</form:select>
		</div>
		
		<div class="form-group">
			<form:label path="expirationDate">Expiration Date:</form:label>
			<form:errors path="expirationDate" />
			<form:input path="expirationDate" type="date" name="expirationDate" class="form-control" />
		</div>
		
		<div class="form-group">
			<form:label path="state">State:</form:label>
			<form:errors path="state" />
			<form:input path="state" type="text" name="state" class="form-control" />
		</div>
		
		<button class="btn btn-outline-dark">Create</button>
	</form:form>
	
</body>
</html>