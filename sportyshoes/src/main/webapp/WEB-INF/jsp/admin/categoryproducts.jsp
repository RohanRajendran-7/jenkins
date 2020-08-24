<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Purchases Report</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />
</head>
<body class="text-center">
<jsp:include page="/WEB-INF/jsp/components/admin-header.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/jsp/components/admin-topbar.jsp" ></jsp:include>


Total Orders: ${list.size()}  
<table border=1 cellspacing=2 cellpadding=4 /class="table table-striped table-hover">
 	<tr> 
 		<td><b>Id</b></td>
 		<td><b>Price</b></td>
 		<td><b>Product id</b></td>
 		<td><b>User id</b></td>
 		<td><b>Purchase id</b></td>
 	</tr>
 	<c:forEach items="${list}" var="item">
 	  	<tr>
	 		<td>${item.ID }</td>
 			<td>${item.price }</td>
 			<td>${item.productId}</td>
 			<td>${item.userId}</td>
 			<td>${item.purchaseId}</td>

 	  	</tr>
 	  </c:forEach>
</table> 	