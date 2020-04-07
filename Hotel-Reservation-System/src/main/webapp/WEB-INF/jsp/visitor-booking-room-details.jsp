<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>reports</title>
<style type="text/css">
			a:link{
				font-family: serif;
				font-size: 30px;
				text-decoration: none;
				color: #FFD700;
				text-align: center;
			}
			a:hover{
			color: green;
			}
			</style>
</head>
<body>
<h1 align="center">View Booking Report</h1>
<form action="${pageContext.request.contextPath}/admin.htm/getbookingdetails.htm" method="get">
<table align="center" border="2">
<tr>
<td>FROM DATE</td>
<td><input type="date" name="fromDate"></td>
</tr>
<tr>
<td>TO DATE </td>
 <td><input type="date" name="toDate"></td>
 </tr>
 <tr>
 <td  align="center" bgcolor="yellow" colspan="1">
<input type="submit" value="FIND REPORTS">
</td>
</tr>
</table>
</form>
<br>
<br>
<c:if test="${listbookingroomdetails ne null}">
<table align="center" border="5">
<tr>
<th>RoomId</th>
<th>NoOfGuest</th>
<th>RoomType</th>
<th>CheckInDate</th>
<th>CheckOutDate</th>
</tr>
<c:forEach items="${listbookingroomdetails}" var="book">
<tr>
<td>${book.roomId}</td>
<td>${book.noOfGuest}</td>
<td>${book.roomType}</td>
<%-- <td><fmt:formatDate value="${book.checkInDate}" pattern="dd/mm/yyyy"/></td>
<td><fmt:formatDate value="${book.checkOutDate}" pattern="dd/mm/yyyy"/></td> --%>
<td>${book.checkInDate}</td>
<td>${book.checkOutDate}</td>
</tr>
</c:forEach>
</table>
</c:if>
<br>
<br>
<a href="${pageContext.request.contextPath}/hrs.htm"><p align="center">HOME</p></a>
</body>
</html>