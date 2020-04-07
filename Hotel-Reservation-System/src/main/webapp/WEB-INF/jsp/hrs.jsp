<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hrs</title>
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
<h1 align="center">HOTEL RESERVATION SYSTEM</h1>
<br>
<br>
<br>
<a  href=${pageContext.request.contextPath}/visitor-login.htm><h2 align="center">VISITOR</h2></a>
<a  href=${pageContext.request.contextPath}/admin-login-page.htm><h2 align="center">ADMIN</h2></a>

</body>
</html>