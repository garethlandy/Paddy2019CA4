<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<form method="POST"	action="${pageContext.request.contextPath}/register">
		<table border="0">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstname"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastname" />
				</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" />
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
				<select name="item">
					<option value="M">Male</option>
					<option value="F">Female</option>					
				</select>				
				</td>
			</tr>
			<tr>
				<td>Admin</td>
				<td>
				<select name="admin">
					<option value="y">Yes</option>
					<option value="n">No</option>					
				</select>				
				</td>
			</tr>
			<tr>
				<td>Street Address 1</td>
				<td><input type="text" name="street1" />
				</td>
			</tr>
			<tr>
				<td>Street Address 2</td>
				<td><input type="text" name="street2" />
				</td>
			</tr>
			<tr>
				<td>Town</td>
				<td><input type="text" name="town" />
				</td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city" />
				</td>
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" name="country" />
				</td>
			</tr>
			<tr>
				<td>Post Code</td>
				<td><input type="text" name="postcode" />
				</td>
			</tr>
			<tr>
				<td>Remember me</td>
				<td><input type="checkbox" name="rememberMe" value="Y"
					checked="checked" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <a
					href="${pageContext.request.contextPath}/">Cancel</a></td>
			</tr>
		</table>



	</form>


	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>