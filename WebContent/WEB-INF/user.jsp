<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ include file="my_style.jsp" %>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
</head>
<body bgcolor=#90CAF9>

	
<div class="row brd">>
		<p class="txt1">RENT STATION</p>
</div>
<br>
<div class="row">
	<div class="col-1-8">

		
		<div class="form brd">
		<br>
			<p align="center">
				<input id="submit" value="make order" type="submit"class="btn btn-primary btn-lg button" form="make_order">
			</p>
			<form id="make_order" action="MainServlet" method="post">
				<input type="hidden" value="make_order" name="action" /> 
			</form>
			
			<p align="center">
				<input id="submit" value="return" type="submit"class="btn btn-primary btn-lg button" form="return">
			</p>
				<form id="return" action="MainServlet" method="post">
				<input type="hidden" value="prepare_return_equip" name="action" /> 
			</form>
			
			<p align="center">
				<input type="submit" value="LOGIN" class="btn btn-primary btn-lg button" form="out">
			</p>
			<form action="MainServlet" method="get" id="out" >
			<input type="hidden" value="log_out" name="action" /> 
			</form>
			<br>
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