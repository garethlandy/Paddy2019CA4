<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Product</title>
      
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
 
      <h3>Edit Product</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty product}">
         <form method="POST" action="${pageContext.request.contextPath}/editProduct">
            <input type="hidden" name="code" value="${product.code}" />
            <table>
               <tr>
                  <td>Code</td>
                  <td style="color:red;">${product.code}</td>
               </tr>
               <tr>
                  <td>Name</td>
                  <td><input type="text" name="name" value="${product.name}" /></td>
               </tr>
               <tr>
                  <td>Price</td>
                  <td><input type="text" name="price" value="${product.price}" /></td>
               </tr>
               <tr>
                  <td>Manufacturer</td>
                  <td><input type="text" name="manufacturer" value="${product.manufacturer}" /></td>
               </tr>
               <tr>
                  <td>Category</td>
                  <td><input type="text" name="category" value="${product.category}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>