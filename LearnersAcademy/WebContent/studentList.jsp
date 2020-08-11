<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject List</title>
</head>
<body class="text-center">
	
	<%@ include file="header.jsp" %>	
	<hr/>
	<a href="<%=request.getContextPath() %>/studentServlet?action=insertStudent">
		<button class="btn btn-outline-primary">Add New Student</button>
	</a>
	<br/><br/>
<table class="table table-striped table-hover">

		<thead>
			<tr>

				<th></th>
				<th style='color:white'>Student Id</th>
				<th style='color:white'></th>
				<th style='color:white'>Student Name</th>
				<th style='color:white'>class id</th>
				<th style='color:white'>class Name</th>
				<th style='color:white'>Actions</th>
				<th></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="slist" items="${s_list}">

				<tr>
					<td></td>
					<td style='color:white'><c:out value="${slist.studentid}" /></td>
					<td></td>
					<td style='color:white'><c:out value="${slist.studentname}" /></td>
					<td style='color:white'><c:out value="${slist.classid}" /></td>
					<td style='color:white'><c:out value="${slist.classname}" /></td>
					<td>
						<a href="studentServlet?action=delete&id=<c:out value="${slist.studentid}" />">
							<button class="btn btn-outline-danger">Delete</button>
						</a>
						<a href="studentServlet?action=updateStudent&id=<c:out value="${slist.studentid}" />">
							<button class="btn btn-outline-warning">Update</button>
						</a>
					</td>
				</tr>

			</c:forEach>

		</tbody>


	</table>

</body>
</html>