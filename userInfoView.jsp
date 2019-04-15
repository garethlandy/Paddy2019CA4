<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
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


tr:nth-child(even) {background-color: #f2f2f2;}
</style>
 <table>
 <tr>
  		  <th>Name</th>
          <th>Gender</th>
          <th>Admin</th>
          <th >Street 1</th>
          <th >Street 2</th>
          <th>Town</th>
          <th>City</th>
          <th>Country</th>
          <th>PostCode</th>
</tr>
<tr>
    <td><b>${user.userName}</b></td></br>
   <td><b>${user.gender }</b></td>
    <td><b>${user.admin }</b></td>
    <td><b>${user.street_address_1 }</b></td>
	<td><b>${user.street_address_2 }</b></td>
    <td><b>${user.town } </b></td>
   <td><b> ${user.city }</b></td>
   <td><b> ${user.country }</b></td>
   <td><b> ${user.postcode }</b></td>
   </tr>
 </table>
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>