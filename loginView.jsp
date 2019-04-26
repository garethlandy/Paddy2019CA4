<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
      <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/styles.css">
    <link rel="stylesheet" type="text/css" href="assets/css/demo.css">
   </head>
   <body>
      <jsp:include page="_header.jsp"></jsp:include>
   
      <form method="POST" action="${pageContext.request.contextPath}/login">
         <table border="0">
            <tr>
               <td><h3>User Name</h3></td>
               <td><input type="text" name="userName" value= "${user.userName}" /> </td>
            </tr>
            <tr>
                <td><h3>Password</h3></td>
               <td><input type="text" name="password" value= "${user.password}" /> </td>
            </tr>
            <tr>
                <td><h3>Remember Me</h3></td>
               <td><input type="checkbox" name="rememberMe" value= "Y" checked="checked" /> </td>
            </tr>
            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/register">Register</a>
               </td>
            </tr>
         </table>
      </form>
 
      <!-- <p style="color:blue;">User Name: tom, password: tom001 or jerry/jerry001</p> -->
 
      <jsp:include page="_footer.jsp"></jsp:include>
   </body>
</html>