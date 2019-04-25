 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visa</title>

    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/styles.css">
    <link rel="stylesheet" type="text/css" href="assets/css/demo.css">
</head>

<body>
		<jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
     <c:set var="total" value="${0}" />
		<c:set var="count" value="${0}" />
		<c:forEach items="${shoppingCart}" var="shoppingCart">
			<c:set var="total" value="${total + shoppingCart.price}" />
			<c:set var="count" value="${count + 1}" />
			</c:forEach>
      
    
   <div class="creditCardForm">
    <div class="heading">
        <img src="images/visa.png" id="visa" style="float: center; width: 200px; height: 150px;">
    </div>
    <div class="payment">
        <form method="POST" action="${pageContext.request.contextPath}/visa">
            <div class="form-group owner">
                <label for="owner">Total Amount</label>
                <input type="text" class="form-control" id="owner" name = "total" value="${total}">
            </div>
            <div class="form-group CVV">
                <label for="cvv">Number Of Items</label>
                <input type="text" class="form-control" id="cvv" name = "count" value="${count}">
            </div>
            <div class="form-group owner">					
            <label for="owner">Name On Card</label> <input type="text"						
            class="form-control" id="owner" value="${user.firstname} ${user.lastname}">
			</div>
            <div class="form-group CVV">
                <label for="cvv">CVV</label>
                <input type="text" class="form-control" id="cvv">
            </div>
            <div class="form-group" id="card-number-field">
                <label for="cardNumber">Card Number</label>
                <input type="text" class="form-control" id="cardNumber">
            </div>
            <div class="form-group" id="expiration-date">
                <label>Expiration Date</label>
                <select>
                    <option value="01">January</option>
                    <option value="02">February </option>
                    <option value="03">March</option>
                    <option value="04">April</option>
                    <option value="05">May</option>
                    <option value="06">June</option>
                    <option value="07">July</option>
                    <option value="08">August</option>
                    <option value="09">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select>
                <select>
                    <option value="16"> 2019</option>
                    <option value="17"> 2020</option>
                    <option value="18"> 2021</option>
                    <option value="19"> 2022</option>
                    <option value="20"> 2023</option>
                    <option value="21"> 2024</option>
                </select>
                
            </div>
          
            <div class="form-group" id="pay-now">
                <button type="submit" class="btn btn-default" id="confirm-purchase">Confirm</button>
               
            </div>
        </form>
    </div>
</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="assets/js/jquery.payform.min.js" charset="utf-8"></script>
    <script src="assets/js/script.js"></script>
</body>
</html>