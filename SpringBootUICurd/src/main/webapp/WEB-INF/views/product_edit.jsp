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
<h3>product Edit Page</h3>
<form action="update" method="post">
<pre>
Product Id     ::<input type="text" name="prodId" value="${ob.prodId}" readonly="readonly"/>
Product Name   ::<input type="text" name="prodName" value="${ob.prodName}"/>
Product Cost   ::<input type="text" name="prodCost" value="${ob.prodCost}"/>
<input type="submit" value="update">
</pre>
</form>
${message}
</body>
</html>