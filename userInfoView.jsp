<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/styles.css">
<link rel="stylesheet" type="text/css" href="assets/css/demo.css">
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>

	<c:choose>
		<c:when test="${user.admin.equalsIgnoreCase('n')}">
			<jsp:include page="userMenu.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="_menu.jsp"></jsp:include>
		</c:otherwise>

	</c:choose>



	<h1>Hello: ${user.userName}</h1>

	<%-- <table border="10" cellpadding="10" cellspacing="30" style =width:100% background = "#000">--%>
	<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Name</th>
			<th>Gender</th>			
			<th>Street 1</th>
			<th>Street 2</th>
			<th>Town</th>
			<th>City</th>
			<th>Country</th>
			<th>PostCode</th>
		</tr>
		<tr>
			<td><b>${user.firstname}</b></td>
			<td><b>${user.lastname}</b></td>
			<td><b>${user.userName}</b></td>
			<td><b>${user.gender }</b></td>			
			<td><b>${user.street_address_1 }</b></td>
			<td><b>${user.street_address_2 }</b></td>
			<td><b>${user.town } </b></td>
			<td><b> ${user.city }</b></td>
			<td><b> ${user.country }</b></td>
			<td><b> ${user.postcode }</b></td>
			<td><a href="editUser?user=${user.userName}">Edit</a></td>
		</tr>

	</table>
	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>