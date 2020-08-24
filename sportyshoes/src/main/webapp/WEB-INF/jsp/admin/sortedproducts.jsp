<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Setup Products</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />
</head>
<body class="text-center"> 
<jsp:include page="/WEB-INF/jsp/components/admin-header.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/jsp/components/admin-topbar.jsp" ></jsp:include>

Total Products: ${list.size()}  &nbsp;&nbsp; <a href="admineditproduct?id=0">Add Product</a><br>
<table border=1 cellspacing=2 cellpadding=4 class="table table-striped table-hover">
 	<tr>
 		<td><b>Product</b></td>
 		<td><b>Price</b></td>
 		<td><b>Added On</b></td>
 		<td><b>Category</b></td>
 		<td></td>
 	</tr>
 	<c:forEach items="${list}" var="item">
 	  	<tr>
	 		<td>${item.name }</td>
 			<td>${item.price }</td>
 			<td>${item.dateAdded}</td>
 			<td>${mapCats.get(item.ID)}</td>
 	  		<td>
 	  			<a href="admineditproduct?id=${item.ID}">Edit</a> | <a href="admindeleteproduct?id=${item.ID}">Delete</a>
 	  		</td>
 	  	</tr>
 	  </c:forEach>
</table> 	
<jsp:include page="/WEB-INF/jsp/components/admin-footer.jsp"></jsp:include>
</body>
</html>