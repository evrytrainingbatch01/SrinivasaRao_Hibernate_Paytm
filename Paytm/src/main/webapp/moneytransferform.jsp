<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Money Transfer Form</h1>
<form method="post">
Account No: <input type="text" name="accountno"><br>
Beneficiary Account No: <input type="text" name="beneficiaryaccountno"><br>
Amount : <input type="text" name="amount"><br>
<button type="submit" formaction="/Paytm/transfer">Transfer</button>
</form>
</body>
</html>