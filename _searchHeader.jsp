<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!-- <div style="background: #4286f4; height: 70px; padding: 5px; "> -->
  
     
     <form method="POST" action="${pageContext.request.contextPath}/searchProduct">
         <table >
            <tr>    
            <td><h1>Electronic Store</h1></td>          
               <td>Search <input type="text" name="search"  value= "${product.name}" /> </td>
               <td><input type="submit" value= "Submit" /> </td>      
               
            </tr>
            </table>
            </form>
<!--   
  
 
 
  <div style="float: center; padding: 10px; text-align: center;">
 
     User store in session with attribute: loginedUser 
     Hello <b>${loginedUser.userName}</b>
     
     
  <br>
     
 
  </div>
   -->
 