<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class List</title>
</head>
<body class="text-center">
	
	<%@include file="header.jsp" %>
	<hr/>
		<a href="classServlet?action=insertClass&c_id=<c:out value="${clist.classid}"/>&id=<c:out value="${clist.classid}"/>">
			<button class="btn btn-outline-success">Add Class</button> 
		</a>
		<table class="table table-striped table-hover">
	
		<thead>
			<tr>
				<th style='color:white'></th>
				<th></th>
				<th style='color:white'>Class Id</th>
				<th></th>
				<th style='color:white'>Class Name</th>
				<th style='color:white'>Actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="clist" items="${c_list}">

				<tr>
					<td></td>
					<td></td>
					<td style='color:white'><c:out value="${clist.classid}" /></td>
					<td></td>
					<td style='color:white'><c:out value="${clist.classname}" /></td>
					<td>
						<a href="classServlet?action=select&id=<c:out value="${clist.classname}" />">
							<button class="btn btn-outline-warning">Show Subjects</button>
						</a>
						<a href="classServlet?action=delete&id=<c:out value="${clist.classid}" />">
							<button class="btn btn-outline-danger">Delete</button>
						</a>
						<a href="classServlet?action=report&id=<c:out value="${clist.classid}" />">
							<button class="btn btn-outline-info">Generate Report</button>
						</a>
					</td>
				</tr>

			</c:forEach>

		</tbody>


	</table>
	
</body>
</html>