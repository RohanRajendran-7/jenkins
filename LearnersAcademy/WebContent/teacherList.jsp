<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="text-center">
<%@ include file="header.jsp"%>
	<br/>
	<a href="<%=request.getContextPath() %>/teacherServlet?action=insertTeacher">
		<button class="btn btn-outline-primary">Add New Teacher</button>
	</a>
	<br/><br/>

	<table class="table table-striped table-hover">

		<thead>
			<tr>
				<th style='color:white'>Teacher Id</th>
				<th style='color:white'>Teacher Name</th>
				<th style='color:white'>Teacher age</th>
				<th style='color:white'>Teacher Salary</th>
				<th style='color:white'>Teacher Experience</th>
				<th style='color:white'>subjectname</th>
				<th style='color:white'>classid</th>
				<th style='color:white'>Actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="tlist" items="${t_list}">

				<tr>
					<td style='color:white'><c:out value="${tlist.t_id}" /></td>
					<td style='color:white'><c:out value="${tlist.t_name}" /></td>
					<td style='color:white'><c:out value="${tlist.t_age}" /></td>
					<td style='color:white'><c:out value="${tlist.t_salary}" /></td>
					<td style='color:white'><c:out value="${tlist.t_experience}" /></td>
					<td style='color:white'><c:out value="${tlist.subjectname}" /></td>
					<td style='color:white'><c:out value="${tlist.classid}" /></td>
					<td>
					<a href="teacherServlet?action=updateTeacher&c_id=<c:out value="${tlist.classid}"/>&id=<c:out value="${tlist.t_id}"/>">
						<button class="btn btn-outline-warning">Update Class</button> 
					</a>
					<a href="teacherServlet?action=delete&id=<c:out value="${tlist.t_id}" />">
						<button class="btn btn-outline-danger">Delete</button>
					</a>
					</td>
				</tr>

			</c:forEach>

		</tbody>


	</table>

</body>
</html>