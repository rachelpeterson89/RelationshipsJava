<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person Table</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<table class="table table">
		<thead>
			<tr class="">
	            <th scope="col">Last Name</th>
	            <th scope="col">First Name</th>
	            <th scope="col">License Number</th>
	            <th scope="col">Expiration Date</th>
	            <th scope="col">State</th>
	            <th scope="col">Actions</th>
        	</tr>
		</thead>
		<tbody>
        <c:forEach items="${persons}" var="person">
        <tr class="text-dark">
            <td><a id="a" href="/person/${person.id}"><c:out value="${person.lastName}"/></a></td>
            <td><c:out value="${person.firstName}"/></td>
            <td><c:out value="${person.license.number}"/></td>
            <td><c:out value="${person.license.expirationDate}"/></td>
            <td><c:out value="${person.license.state}"/></td>
            <td class="d-flex">
            	<a href="/license" class="btn btn-outline-dark">Add License</a>
            	<a href="" class="btn btn-outline-dark">Edit</a>
            	<form action="/person/${person.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input class="btn btn-outline-dark" type="submit" value="Delete">
				</form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
	</table>
</body>
</html>