<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Setup Product Categories</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />
</head>
<body class="text-center">
<jsp:include page="/WEB-INF/jsp/components/admin-header.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/jsp/components/admin-topbar.jsp" ></jsp:include>

Total Categories: ${list.size()} &nbsp;&nbsp; <a href="admineditcat?id=0">Add Category</a><br>
<table border=1 cellspacing=2 cellpadding=4 class="table table-striped table-hover">
 	<tr>
 		<td><b>Category</b></td>
 		<td></td>
 	</tr>
 	  <c:forEach items="${list}" var="item">
 	  	<tr>
 	  		<td>${item.name }</td>
 	  		<td>
 	  			<a href="admineditcat?id=${item.ID}">Edit</a> | <a href="admindeletecat?id=${item.ID}">Delete</a>
 	  		</td>
 	  	</tr>
 	  </c:forEach>
</table> 	

<jsp:include page="/WEB-INF/jsp/components/admin-footer.jsp"></jsp:include>
</body>
</html>