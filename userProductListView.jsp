<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
    
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
  font-size:20px;
}
td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
  font-size:12px;
}

tr:hover {background-color:#f5f5f5;}
</style>
 </head>
 <body> 
 
    <jsp:include page="_searchHeader.jsp"></jsp:include>
    <jsp:include page="userMenu.jsp"></jsp:include>
    
 
    <p style="color: red;">${errorString}</p>
    <c:set var="total" value="${0}" />
		<c:set var="count" value="${0}" />
		<c:forEach items="${shoppingCart}" var="shoppingCart">
			<c:set var="total" value="${total + shoppingCart.price}" />
			<c:set var="count" value="${count + 1}" />
			</c:forEach>
 
    <%-- <table border="1" cellpadding="5" cellspacing="1" >--%>

    
    <table id = "myTable">
       <tr>
          <th>Code</th>
          <th onclick="sortTable(1)">Name</button></th>
          <th onclick="sortTable(2)">Price</th>
          <th onclick="sortTable(3)">Manufacturer</th>
          <th onclick="sortTable(4)">Category</th>
          <th>Image</th>
          <th>Stock</th>
          <th>Buy</th>
          
       </tr>
       <c:forEach items="${productList}" var="product" >
          <tr>
             <td>${product.code}</td>
             <td>${product.name}</td>
             <td>€${product.price}</td>
             <td>${product.manufacturer}</td>
             <td>${product.category}</td>
             <%-- <td>${product.category}</td>--%>
             <%-- <td>${product.imageFile}</td> --%>
             <td><a href = "${product.imageFile}">
             <img src="${product.imageFile}" id="visa" style="float: left; width: 100px; height: 75px;"></a></td>
             <td>${product.stock}</td>
             <td>
                <a href="buyProduct?code=${product.code}">Add To Basket</a>                
             </td>
             <%-- <td>
                <a href="deleteProduct?code=${product.code}">Delete</a>
             </td> --%>
          </tr>
       </c:forEach>
    </table>
 
   
 <script>
function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("myTable");
  switching = true;
  //Set the sorting direction to ascending:
  dir = "asc"; 
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      /*check if the two rows should switch place,
      based on the direction, asc or desc:*/
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          //if so, mark as a switch and break the loop:
          shouldSwitch= true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          //if so, mark as a switch and break the loop:
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      //Each time a switch is done, increase this count by 1:
      switchcount ++;      
    } else {
      /*If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again.*/
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
</script>

 <!-- <a href="createProduct" >Create Product</a> -->
 
    <jsp:include page="_footer.jsp"></jsp:include>
 </body>
</html>