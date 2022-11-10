<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
<table>
<tr>
<td><a href="register">Register</a></td>
<td><a href="all">View All</a></td>
</tr>
</table>
<h3>product Registration Page</h3>
<form action="save" method="post">
<pre>
Product Id     ::<input type="text" name="prodId">
Product Name   ::<input type="text" name="prodName">
Product Cost   ::<input type="text" name="prodCost">
<input type="submit" value="register">
</pre>
</form>
${message}
</body>
</html>