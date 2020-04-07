<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search rooms</title>
<style type="text/css">
			a:link{
				font-family: serif;
				font-size: 20px;
				text-decoration: none;
				color: blue;
				text-align: center;
			}
			a:hover{
			color: green;
			}
			</style>
</head>
<body>
<h1 align="center">Search Rooms</h1>
<form action="${pageContext.request.contextPath}/visitor-reg.htm/getroomdetails.htm">
<table align="center" border="2">
<tr>
<td>CHECK IN DATE </td>
 <td><input  type="date" name="checkInDate"></td>
 </tr>
 <tr>
 <td>CHECK OUT DATE</td>
 <td><input type="date" name="checkOutDate"></td>
 </tr>
 <tr>
 <td align="center" bgcolor="block" colspan="1">
<input type="submit" value="SEARCH">
</td>
</tr>
</table>
</form>
<br>
<br>
<c:if test="${listroomdetails ne null }">
<table align="center" border="5">
<tr>
<th>RoomId</th>
<th>RoomType</th>
<th>Capacity</th>
<th>Date</th>
</tr>
<c:forEach items="${listroomdetails}" var="room">
<tr>
<td>${room.roomId}</td>
<td>${room.roomType}</td>
<td>${room.capacity}</td>
<td>${room.date}</td>
</tr>
</c:forEach>
</table>
</c:if>
<br>
<br>
<a  href="${pageContext.request.contextPath}/booking-page.htm"><p align="center">BOOK ROOM</p></a>
</body>
</html>