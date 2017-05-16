<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<%@ include file="style/pages.css" %>

</style>
</head>
	<body  bgcolor=cccccc>
	<div class="brd txt1">
			<p class="txt1">RENT STATION</p>
		
	</div>
		<br>
		<form id="login" action="MainServlet" method="post" class="form brd">
		<p align="center">Return equipment</p>
				<input type="hidden" value="return_equip" name="action" /> 
				<div class="row clearfix ">		
				
				</div>
				<div class="row clearfix ">
				<select name="equip_id" class="w">
					<c:forEach items="${list_eq}" var="i">
					<option value="${i.getEuipId()}" ><c:out value="${i.getName()}" /></option>
					</c:forEach>
				</select>
				</div>		
				
				
				<p align="center">
				
				<input id="submit" value="return" type="submit" class="button20" form="login">
				
				</p>
				<br>
				</form>
				
	
				
				
	</body>
</html>