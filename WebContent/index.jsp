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
<div>

			<p align="center">
				<input id="submit" value="START" type="submit"class="btn btn-primary btn-lg button" form="start_app">
			</p>
			<form id="start_app" action="MainServlet" method="post">
				<input type="hidden" value="start_app" name="action" /> 
			</form>
</div>
<div class="row">
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
  <div class="col-md-1">.col-md-1</div>
</div>



</body>
</html>