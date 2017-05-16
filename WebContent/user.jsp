<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
<%@ include file="style/pages.css" %>

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
</head>
<body bgcolor=cccccc>

	
<div class="brd txt1">
		<p class="txt1">RENT STATION</p>
</div>
<br>
<div class="row clearfix ">
	<div class="col-1-8">
		<div class="row clearfix ">
			<form id="login" action="MainServlet" method="post">
				<input type="hidden" value="make_order" name="action" /> 
				<input id="submit" value="make order" type="submit"class="button20">
			</form>
			<br>
			<form id="login" action="MainServlet" method="post">
				<input type="hidden" value="prepare_return_equip" name="action" /> 
				<input id="submit" value="return" type="submit"class="button20">
			</form>
			<br>
			<form action="index.html" >
					<input type="submit" value="LOG OUT" class="button20">
			</form>
		</div>
	
	</div>
	<div class="col-7-8">
		<div class="col-1-4">
		</div>
		<div class="col-1-2">
	
			<div class="row clearfix ">
	
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
		<div class="col-1-4">
		</div>	
		
	</div>
</div>



</body>
</html>