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

	<table class="table table-striped table-hover">

		<thead>
			<tr>
				<th style='color:white'>Student Name</th>
				<th style='color:white'>Teacher name</th>
				<th style='color:white'>Subject Name</th>
				<th style='color:white'>Teacher name</th>
				<th style='color:white'>subjectname</th>
				<th style='color:white'>Teacher name</th>
				<th style='color:white'>subjectname</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach var="stu" items="${stu}">

				<tr>
					<td style='color:white'><c:out value="${stu.studentname}" /></td>
					<td style='color:white'><c:out value="${subclass.tut_name1}" /></td>
					<td style='color:white'><c:out value="${subclass.sub_name1}" /></td>
					<td style='color:white'><c:out value="${subclass.tut_name2}" /></td>
					<td style='color:white'><c:out value="${subclass.sub_name2}" /></td>
					<td style='color:white'><c:out value="${subclass.tut_name3}" /></td>
					<td style='color:white'><c:out value="${subclass.sub_name3}" /></td>
					<td>
					</td>
				</tr>

			</c:forEach>

		</tbody>


	</table>

</body>
</html>