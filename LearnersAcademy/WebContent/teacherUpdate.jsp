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
<h1>Add New Teacher</h1>
	
	<form class="form-signin" action="<%=request.getContextPath() %>/teacherServlet">
		<input type="hidden" name="action" value="update">
		<input type ="text" class="form-control" name="t_id" value="${teacher.t_id}"/><br/>
		<input type ="text" class="form-control" name="t_name" value="${teacher.t_name}"/><br/>
		<input type ="text" class="form-control" name="t_age" value="${teacher.t_age}"/><br/>
		<input type ="text" class="form-control" name="t_experience" value="${teacher.t_experience}" hidden/><br/>
		<input type ="text" class="form-control" name="t_salary" value="${teacher.t_salary}"/><br/>
		<div class="theme-construction">
		<label for="state" accesskey="s"><h4>Select Class Id </h4></label>
		<select name="classid">
			<c:forEach var = "table" items="${c_list}">
				<option value="${table.classid}">         
                    ${table.classid}
                </option>
			</c:forEach>
		</select>
		</div>
		<br/><br/>
		<div class="theme-construction">
		<label for="state" accesskey="s"><h4>Select Sub Name </h4></label>
		<select name="subjectname">
			<c:forEach var = "table" items="${s_list}">
				<option value="${table.subjectname}">
                    ${table.subjectname}
                </option>
			</c:forEach>
		</select>
		</div>
		<br/>
		<input style="float:left" class="btn btn-outline-success" type ="submit" value="Add User"/>
	</form>

</body>
</html>