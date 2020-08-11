<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Class</title>
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
<br/>
	<h1>Add New Employee</h1>
	
	<form class="form-signin" action="<%= request.getContextPath() %>/classServlet">
		<input type="hidden" name="action" value="insert" /><br/>
		<input type ="text" class="form-control" name="classid" placeholder="Enter Class id"/><br/>
		<input type ="text" class="form-control" name="classname" placeholder="Enter Class name"/><br/>
		<input type ="submit" class="btn btn-outline-success" value="Add User"/>
	</form>
</body>
</html>