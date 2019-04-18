<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Buy Product</title>
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
 
  
      <h3>Buy Product</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty product}">
         <form method="POST" action="${pageContext.request.contextPath}/buyProduct">
         
         
         
         	<input type="hidden" name="userName" value="${user.userName}" />            
            <input type="hidden" name="name" value="${product.name}" />
            <input type="hidden" name="name" value="${product.price}" />
            <input type="hidden" name="manufacturer" value="${product.manufacturer}" />
            <input type="hidden" name="category" value="${product.category}" />
            <input type="hidden" name="code" value="${product.code}" />
            
            <table>
            <tr>
                  <td>UserName</td>
                  <td style="color:blue;">${user.userName}</td>
               </tr>               
               <tr>
                  <td>Name</td>
                  <td style="color:black;">${product.name}</td>
               </tr>
               <tr>
                  <td>Price</td>
                  <td style="color:black;">${product.price}</td>
               </tr>
               <tr>
                  <td>Manufacturer</td>
                  <td style="color:black;">${product.manufacturer}</td>
               </tr>
               <tr>
                  <td>Category</td>
                   <td style="color:black;">${product.category}</td>
               </tr>
               <tr>
                  <td>Code</td>
                  <td style="color:red;">${product.code}</td>
               </tr>
                
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/userProductList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>