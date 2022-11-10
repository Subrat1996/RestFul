<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <h3>Product data</h3>
    <table border="1" bgcolor="yellow">
  <tr>
    <th>Product Id</th>
    <th>Product Name</th>
    <th>Product cost</th>
    <th>Product Discount</th>
    <th>Product Gst</th>
    <th colspan="2">Operations</th>
  </tr>
  <c:forEach items="${list}" var="ob">
  <tr>
    <td>${ob.prodId}</td>
    <td>${ob.prodName}</td>
    <td>${ob.prodCost}</td>
    <td>${ob.discount}</td>
    <td>${ob.gst}</td>
    <td><a href="delete?pid=${ob.prodId}">Delete</a></td>
    <td><a href="edit?pid=${ob.prodId}">Edit</a></td>
  </tr>
  </c:forEach>
</table>
${message}
<br><br>
<a href="register">Home</a>

