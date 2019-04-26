<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit User</title>
      <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/styles.css">
    <link rel="stylesheet" type="text/css" href="assets/css/demo.css">
    <style>
table {
  border-collapse: collapse;
  width: 100%;
}

th {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
  font-size:30px;
}
td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
  font-size:20px;
}

tr:hover {background-color:#f5f5f5;}
</style>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Edit User</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty user}">
         <form method="POST" action="${pageContext.request.contextPath}/editUser">
            <input type="hidden" name="firstname" value="${user.firstname}" />
            <input type="hidden" name="lastname" value="${user.lastname}" /> 
            <input type="hidden" name="lastname" value="${user.userName}" />            
            <table>
               <tr>
                  <td>First Name</td>
                  <td style="color:black;">${user.firstname}</td>
               </tr>
               <tr>
                  <td>Last Name</td>
                  <td style="color:black;">${user.lastname}</td>
               </tr>
               <tr>
                  <td>User Name</td>
                 <td style="color:black;">${user.userName}</td>
               </tr>
               <tr>
                  <td>Street Address 1</td>
                  <td><input type="text" name="street_address_1" value="${user.street_address_1}"/></td>
               </tr>
               <tr>
                  <td>Street Address 2</td>
                   <td><input type="text" name="street_address_2" value="${user.street_address_2}"/></td>
               </tr>
                 <tr>
                  <td>Town</td>
                   <td><input type="text" name="town" value="${user.town}"/></td>
               </tr>
                <tr>
                  <td>City</td>
                   <td><input type="text" name="city" value="${user.city}"/></td>
               </tr>
                <tr>
                  <td>Country</td>
                   <td><input type="text" name="country" value="${user.country}"/></td>
               </tr>
                <tr>
                  <td>Post Code</td>
                   <td><input type="text" name="postcode" value="${user.postcode}"/></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/editUser">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>