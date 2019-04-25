
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Credit Card Validation Demo</title>

<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/styles.css">
<link rel="stylesheet" type="text/css" href="assets/css/demo.css">
</head>

<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>



	<div class="creditCardForm">
		<div class="heading">
			<form method="POST" action="${pageContext.request.contextPath}/payment">
				<select name="item">
					<option value="1">MasterCard</option>
					<option value="2">Visa</option>
					<option value="3">American Express</option>
				</select> <input type="submit" value="Submit">
			</form>
			<h1>Confirm Purchase</h1>
		</div>
		<div class="form-group" id="credit_cards">
			<img src="images/visa.png" id="visa"
				style="float: left; width: 100px; height: 75px;"> <img
				src="images/mastercard.png" id="mastercard"
				style="float: center; width: 100px; height: 75px;"> <img
				src="images/amex.png" id="amex"
				style="float: right; width: 100px; height: 75px;">
		</div>
		<div class="payment">
			<form>
				<div class="form-group owner">
					<label for="owner">Owner</label> <input type="text"
						class="form-control" id="owner" value="${user.userName}">
				</div>
				<div class="form-group CVV">
					<label for="cvv">CVV</label> <input type="text"
						class="form-control" id="cvv">
				</div>
				<div class="form-group" id="card-number-field">
					<label for="cardNumber">Card Number</label> <input type="text"
						class="form-control" id="cardNumber">
				</div>
				<div class="form-group" id="expiration-date">
					<label>Expiration Date</label> <select>
						<option value="01">January</option>
						<option value="02">February</option>
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
					</select> <select>
						<option value="16">2019</option>
						<option value="17">2020</option>
						<option value="18">2021</option>
						<option value="19">2022</option>
						<option value="20">2023</option>
						<option value="21">2024</option>
					</select>
				</div>

				<div class="form-group" id="pay-now">
					<button type="submit" class="btn btn-default" id="confirm-purchase">Confirm</button>
				</div>
			</form>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="assets/js/jquery.payform.min.js" charset="utf-8"></script>
	<script src="assets/js/script.js"></script>
</body>
</html>