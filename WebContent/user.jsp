<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
*, *:before, *:after {
	box-sizing: border-box;
}

body {
	background-color: cccccc;
	color: rgb(100, 100, 100);
	font-family: sans-serif;
	font-size: 16px;
	line-height: 1.3;
}

.txt1 {
	color: red;
	font-family: sans-serif;
	font-size: 50px;
}

.row {
	margin: 10px 10px;
	margin-bottom: 10px;
}

.row:last-child {
	margin-bottom: 10px;
}

[class*="col-"] {
	padding: 10px;
	background-color: white;
	margin-bottom: 10px;
	font-family: arial, verdana, sans-serif;
}

@media all and ( min-width: 400px ) {
	.col-2-3 {
		float: left;
		width: 66.66%;
	}
	.col-1-2 {
		float: left;
		width: 50%;
	}
	.brd {
		border: 2px solid blue;
		border-radius: 5px;
	}
	.col-1-3 {
		float: left;
		width: 33.33%;
	}
	.col-1-4 {
		float: left;
		width: 25%;
	}
	.col-1-8 {
		float: left;
		width: 12.5%;
	}
	.text {
		background-color: #6699ff;
		width: 70%;
		min-heigth: 60%;
		float: right;

		/* position: absolute; 
  top: 15px; 
  right: 15px;*/
	}
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
</head>
<body bgcolor=cccccc>

	<form id="login" action="MainServlet" method="post">
		<input type="hidden" value="make_order" name="action" /> 
		<input id="submit" value="make order" type="submit">
	</form>
	<form action="index.html">
			<input type="submit" value="back">
		</form>

	
	<div class="text">
		<div class="row clearfix ">

			<div class="col-1-3 brd">#</div>
			<div class="col-1-3 brd">Name</div>
			<div class="col-1-3 brd">Price</div>

		</div>
		<c:forEach items="${list_eq}" var="i">
			<div class="row clearfix ">
				<div class="col-1-3 brd">
					<c:out value="${list_eq.indexOf(i)}" />
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

<div class="row clearfix brd txt1">
		<p>RENT STATION</p>
		
	</div>

	<!--  	<br>
	<table border="1">
		
		<tr>
			<th>#</th>
			<th>Name</th>
			<th>Document</th>
		</tr>
		<c:forEach items="${list_eq}" var="i">
			<h3>
				<tr>
					<td><c:out value="${list_eq.indexOf(i)}" /></td>
					<td><c:out value="${i.getName()}" /></td>

					<td><c:out value="${i.getPrice()}" /></td>
				</tr>
			</h3>
		</c:forEach>


	</table>-->
</body>
</html>