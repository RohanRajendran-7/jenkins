<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student form</title>
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
<br/>
	<h1>Add New Student</h1>
	
	<form class="form-signin" action="<%= request.getContextPath() %>/studentServlet">
		<input type="hidden" name="action" value="insert" /><br/>
		<input type ="text" class="form-control" name="studentid" placeholder="Enter the id"/><br/>
		<input type ="text" class="form-control" name="studentname" placeholder="Enter your Name"/><br/>
		<div class="theme-construction">
		<label for="classname" ><h4>Select Class Name </h4></label>
		<select name="classname">
			<c:forEach var = "table" items="${c_list}">
				<option value="${table.classname}">           
                    ${table.classname}
                </option>
			</c:forEach>
		</select>
		</div>
		<br/><br/>
		<div class="theme-construction">
		<label for="classname" ><h4>Select Class Id </h4></label>
		<select name="classid">
			<c:forEach var = "table" items="${c_list}">
				<option value="${table.classid}">           
                    ${table.classid}
                </option>
			</c:forEach>
		</select>
		</div>
		<br/><br/>
		<input type ="submit" style="float:left" class="btn btn-outline-success" value="Add Subject"/>
	</form>
</body>
</html>