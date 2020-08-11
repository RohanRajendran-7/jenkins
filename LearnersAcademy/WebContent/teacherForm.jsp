<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
<br/>
	<h1>Add New Teacher</h1>
	
	<form class="form-signin" action="<%= request.getContextPath() %>/teacherServlet">
		<input type="hidden" name="action" value="insert" /><br/>
		<input type ="text" class="form-control" name="t_id" placeholder="Enter the id"/><br/>
		<input type ="text" class="form-control" name="t_name" placeholder="Enter your name"/><br/>
		<input type ="text" class="form-control" name="t_age" placeholder="Enter your age"/><br/>
		<div class="theme-construction">
		<label for="subjectname" accesskey="s"><h4>Select Subject Name </h4></label>
		<select name="subjectname">
			<c:forEach var = "table" items="${s_list}">
				<option value="${table.subjectname}"> >
                    ${table.subjectname}
                </option>
			</c:forEach>
		</select>
		</div>
		<br/>
		<input type ="text" class="form-control" name="t_salary" placeholder="Enter your salary"/><br/>
		<input type ="text" class="form-control" name="t_experience" placeholder="Enter your experience"/><br/>
		<div class="theme-construction">
		<label for="subjectname" accesskey="s"><h4>Select Class Id </h4></label>
		<select name="classid">
			<c:forEach var = "table" items="${c_list}">
				<option value="${table.classid}">                   >
                    ${table.classid}
                </option>
			</c:forEach>
		</select>
		</div>
		<input style="align:left" type ="submit" class="btn btn-outline-success" value="Add User"/>
	</form>
</body>
</html>