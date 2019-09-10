<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Licenses</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
		<h1><c:out value="${user.first_name} ${user.last_name}"/></h1>
		<ul>
			<li>License Number: <c:out value="${user.license.number}"/></li>
			<li>State: <c:out value="${user.license.state}"/></li>
			<li>Expiration Date: <fmt:formatDate value="${user.license.expiration_date}" pattern="MM-dd-yyyy"/></li>
			<li><a href="/persons/${user.id}/delete">Delete</a></li>
		</ul>
	</div>
	</body>
</html>