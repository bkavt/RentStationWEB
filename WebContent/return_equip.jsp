<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="my_style.jsp" %>
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
				
				<select name="equip_id"  class="form-control">
					<c:forEach items="${list_eq}" var="i">
					<option value="${i.getEuipId()}" ><c:out value="${i.getName()}" /></option>
					</c:forEach>
				</select>
				
				
				<br>
				<p align="center">
				
				<input id="submit" value="return" type="submit" class="btn btn-primary btn-lg button" form="login">
				
				</p>
				
				<p align="center">
				
				<input id="submit" value="back_menu" type="submit" class="btn btn-primary btn-lg button" form="back">
				
				</p>
				</form>
				
	
			
		</form>
		<form id="back" action="MainServlet" method="post">
			<input type="hidden" value="back_menu" name="action" /> </form>	
	<div>
	<div class="col-1-8"></div>
	<div class="col-1-2">
		<div class="row clearfix">
			<div class="col-1-3 brd">#</div>
			<div class="col-1-3 brd">Name</div>
			<div class="col-1-3 brd">Price</div>
		</div>
		<c:forEach items="${list_eq}" var="i">
			<div class="row clearfix ">
				<div class="col-1-3 brd">
					<c:out value="${i.getEuipId()}" />
				</div>
				<div class="col-1-3 brd">
					<c:out value="${i.getName()}" />
				</div>
				<div class="col-1-3 brd">
					<c:out value="${i.getPrice()}" />
				</div>
			</div>
		</c:forEach>
	</div>
	
</div>					
				
	</body>
</html>