<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>
<style type="text/css">
			a {
				font-family: Consolas;
				font-size: 20px;
				text-decoration: none;	
				
				padding: 5px 10px;
			}
			a:hover {
				
				color: red;
			}
			a:visited {
				
				color: blue;
			}
		</style>
</head>
<body>
<h1 align="center">ADMIN MANAGEMENT</h1>
<br>
<br>
<br>
<a  href=${pageContext.request.contextPath}/managing-rooms.htm><h2 align="center">UPDATE ROOM CAPACITY</h2></a>
<a  href=${pageContext.request.contextPath}/booking-reports.htm><h2 align="center">VIEW BOOKING REPORTS</h2></a>

</body>
</html>