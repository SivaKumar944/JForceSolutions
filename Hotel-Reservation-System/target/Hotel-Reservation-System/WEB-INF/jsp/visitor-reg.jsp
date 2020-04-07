<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VisitorRegistration</title>
</head>
<body>
<pre>
<form:form modelAttribute="visitorBo">
<p><form:errors path="*"/></p>
<form:hidden  path="visitorId"/>
VisitorName :<form:input path="visitorName" readonly="true"/>
Password :<form:input path="password" readonly="true"/>
EmailAddress :<form:input  path="emailAddress" readonly="true"/>
MobileNumber :<form:input path="mobileNumber" readonly="true"/>
<input type="submit" value="Register">
</form:form>
</pre>
</body>
</html>