<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<style type="text/css">
			* {
				font-family: Tahoma;
				font-size: 20px;
			}
			.hide {
				display: none;
			}
			.error {
				display: block;
				color: red;
				border: 1px solid black;
			}
			h3{color: red;}
			
		</style>

</head>
<body>
<h1 align="center">Visitor Login Page</h1>
<form name="visitorLogin" action="${pageContext.request.contextPath}/visitor-reg.htm" method="get">
<table align="center" border="2"  style="with: 50%">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="emailAddress"></td>
					<p id="emailAddress_error" class="hide"></p>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
					<p id="password_error" class="hide"></p>
				</tr>
		<tr>
		<td valign="1" align="center" bgcolor="block">		
 <input  type="submit" value="login" onclick="go();"/>
 </td>
 </tr>
 </table>
</form>
<script type="text/javascript">
			function go() {
				var inputTags = null;
				var errorTag = null;
				inputTags = document.getElementsByTagName("input");
				for(var i=0;i<inputTags.length;i++) {
					errorTag = document.getElementById(inputTags[i].name+"_error");	
					if(inputTags[i].checkValidity() == false) {
						
						errorTag.innerHTML=inputTags[i].validationMessage;
						errorTag.className="error";
					}else if(inputTags[i].validity.rangeOverflow==true || inputTags[i].validity.rangeUnderflow == true) {
						errorTag.innerHTML=inputTags[i].validationMessage;
						errorTag.className="error";
					}
				}
			}
			function hideErrors() {
				var errorTags = null;
				errorTags = document.getElementsByClassName("error");
				for(var i=0;i<errorTags.length;i++) {
					errorTags[i].className="hide";
				}
			}
			function go(event) {
				var flag = false;
				var inputTags = null;
				var errorTag = null;

				hideErrors();
				inputTags = document.getElementsByTagName("input");
				for(var i=0;i<inputTags.length;i++) {
					if(inputTags[i].value.trim().length==0) {
						errorTag = document.getElementById(inputTags[i].name+"_error");
						errorTag.innerHTML=inputTags[i].name + " is blank";
						errorTag.className="error";
						flag = true;
					}
				}	
			
				 if(flag == false) {
					document.forms['visitorLogin'].submit();
				} 
				
			}
			</script>
			 <c:if test="${val==1}">
<h3 align="center"> UserName And Password is Incorrect</h3>
</c:if>
<p align="center"> IF YOU NOT A USER REGISTER</p> <a href="${pageContext.request.contextPath}/visitor.htm"><p align="center">HERE</p></a>
</body>
</html>