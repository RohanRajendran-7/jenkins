<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Classes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />
</head>
<body class="text-center">

<%@ include file="header.jsp"%>
<h1>Add New Student</h1>
	
	<form class="form-signin" action="<%=request.getContextPath() %>/studentServlet">
		<input type="hidden" name="action" value="update">
		<input type ="text" class="form-control" name="studentid" value="${student.studentid}"/><br/>
		<input type ="text" class="form-control" name="studentname" value="${student.studentname}"/><br/>
		<div class="theme-construction">
		<label for="classname" ><h4>Select Class Name </h4></label>
		<select name="classname">
			<c:forEach var = "table" items="${c_list}">
				<option value="${table.classname}">                   
                    ${table.classname}
                </option>
                <br/>
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
                <br/>
			</c:forEach>
		</select>
		</div>
		<br/><br/>
		<input class="btn btn-outline-success" type ="submit" value="Add User"/>
	</form>

</body>
</html>