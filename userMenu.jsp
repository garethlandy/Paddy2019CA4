<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<table border="20" cellpadding="10" cellspacing="20" style="width: 100%">
<c:set var="total" value="${0}" />
		<c:set var="count" value="${0}" />
		<c:forEach items="${shoppingCart}" var="shoppingCart">
			<c:set var="total" value="${total + shoppingCart.price}" />
			<c:set var="count" value="${count + 1}" />
			</c:forEach>
	<tr>
		
		<th><a href="${pageContext.request.contextPath}/">Home</a></th>
		<th><a href="${pageContext.request.contextPath}/userProductList">Product
				List</a></th>
		<th><a href="${pageContext.request.contextPath}/userInfo">My
				Account Info</a></th>
		<th><a href="${pageContext.request.contextPath}/userPaymentHistory">Purchase
				History</a></th>
				<th><a href="${pageContext.request.contextPath}/userReview">Product Reviews
				</a></th>
		<th><a href="${pageContext.request.contextPath}/login">Logout</a></th>
		<th>${count}<a href="${pageContext.request.contextPath}/shoppingCart">
				<img src="images/cart.png" alt="Cart"
				style="float: right; width: 38px; height: 38px;"> </a>
	</tr>

</table>
