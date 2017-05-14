<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="login" action="MainServlet" method="post">
		<input type="hidden" value="create_order" name="action" /> 
		<input type="text" name="user_id"> 
		<input type="text" name="equip_id"> 
		<input type="text" name="date_start">
		<input type="text" name="date_end">
		<input id="submit" value="order" type="submit">
	</form>
	
</body>
</html>