<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home Page</title>
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/styles.css">
<link rel="stylesheet" type="text/css" href="assets/css/homestyle.css">
<link rel="stylesheet" type="text/css" href="assets/css/demo.css">

</head>

<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<%-- <jsp:include page="_menu.jsp"></jsp:include> --%>


	<c:choose>
		<c:when test="${user.admin.equalsIgnoreCase('n')}">
			<jsp:include page="userMenu.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="_menu.jsp"></jsp:include>
		</c:otherwise>

	</c:choose>

<img src="images/beats.png" width="250" height="250" onclick> 
<img src="images/iphonex.png" width="250" height="250"> 
<img src="images/soundbar.png" width="250" height="250"> 
<img src="images/aspire.png" width="250" height="250"> 
<img src="images/chromebook.png" width="250" height="250"> 
<img src="images/lenovo.png" width="250" height="250"> 
<img src="images/bluediamond.png" width="250" height="250"> 
<img src="images/s9.png" width="250" height="250"> 
<img src="images/galaxys10.png" width="250" height="250"> 
<img src="images/psmart.png" width="250" height="250"> 
<img src="images/imac.png" width="250" height="250"> 
<img src="images/panasonicdvd.png" width="250" height="250">

	<jsp:include page="_footer.jsp"></jsp:include>

</body>

</html>