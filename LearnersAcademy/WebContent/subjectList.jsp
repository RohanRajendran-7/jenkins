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
	<a href="<%=request.getContextPath() %>/subjectServlet?action=insertSubject">
		<button class="btn btn-outline-primary">Add New Subject</button>
	</a>
	<br/><br/>
<table class="table table-striped table-hover">

		<thead>
			<tr>

				<th></th>
				<th style='color:white'>Subject Id</th>
				<th style='color:white'></th>
				<th style='color:white'>Subject Name</th>
				<th style='color:white'>class id</th>
				<th style='color:white'>Actions</th>
				<th></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="slist" items="${s_list}">

				<tr>
					<td></td>
					<td style='color:white'><c:out value="${slist.subjectid}" /></td>
					<td></td>
					<td style='color:white'><c:out value="${slist.subjectname}" /></td>
					<td style='color:white'><c:out value="${slist.classid}" /></td>
					<td>
						<a href="subjectServlet?action=delete&id=<c:out value="${slist.subjectid}" />">
							<button class="btn btn-outline-danger">Delete</button>
						</a>
					</td>
				</tr>

			</c:forEach>

		</tbody>


	</table>

</body>
</html>