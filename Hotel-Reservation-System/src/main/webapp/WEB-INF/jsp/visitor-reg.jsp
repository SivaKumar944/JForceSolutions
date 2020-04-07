<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visitor Reg</title>   
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
			
		</style>
</head>
<h1 align="center">Visitor Registration Form</h1>
<form name="visitorReg" action="${pageContext.request.contextPath}/visitor-reg.htm" method="post">
			<table align="center" border="2"  style="with: 50%">
				<tr>
					<td>Visitor Name</td>
					<td><input type="text" name="visitorName" min="3" max="50" required/></td>
					<p id="visitorName_error" class="hide"></p>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" min="4" maxlength="8" /></td>
					<p id="password_error" class="hide"></p>
				</tr>
				<tr>
					<td>Email Address</td>
					<td><input type="email" name="emailAddress" /></td>
					<p id="emailAddress_error" class="hide"></p>
				</tr>
				<tr>
					<td>Mobile No</td>
					<td><input type="text"" name="mobileNumber" min="10" maxlength="12"/></td>
					<p id="mobileNumber_error" class="hide"></p>
				</tr>
				<tr>
		      <td valign="1" align="center" bgcolor="block" colspan="1">	
			<input type="submit" value="Register" onclick="go();"/>
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
					document.forms['visitorReg'].submit();
				}
				
			}
			</script>
</body>
<%-- <body>
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
</body> --%>
</html>