<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>booking</title>
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
<body>
<h1 align="center">Enter Room Details</h1>
<form name="bookRoom" action="${pageContext.request.contextPath}/visitor-reg.htm/book-room.htm" method="post">
			<table align="center" border="2"  style="with: 50%">
				<tr>
					<td>Room Id</td>
					<td><input type="text" name="roomId" min="3" max="50" required/></td>
					<p id="roomId_error" class="hide"></p>
				</tr>
					<tr>
					<td>No Of Guest</td>
					<td><input type="text" name="noOfGuest" min="4" maxlength="8" /></td>
					<p id="noOfGuest_error" class="hide"></p>
				</tr>
				<tr>
					<td>Room Type</td>
					<td>
					<select name="roomType">
					<option value="standard">Standard</option>
					<option value="deluxe">Deluxe</option>
					<option value="luxury">Luxury</option>
					</select>
					<p id="roomType_error" class="hide"></p>
				</tr>
				<tr>
					<td>Check In Date</td>
					<td><input type="date"" name="checkInDate" min="10" maxlength="12"/></td>
					<p id="checkInDate_error" class="hide"></p>
				</tr>
				<tr>
					<td>Check Out Date</td>
					<td><input type="date"" name="checkOutDate" min="10" maxlength="12"/></td>
					<p id="checkOutDate_error" class="hide"></p>
				</tr>
				<tr>
				<td  align="center" bgcolor="red" colspan="1">
			<input type="submit" value="Register" onclick="go();"/>
			</tr>
			</td>
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
					document.forms['bookRoom'].submit();
				}
				
			}
			</script>

</body>
</html>