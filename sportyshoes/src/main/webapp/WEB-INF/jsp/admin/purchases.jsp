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


<br><br>Total ${list.size()} Orders: ${totalAmount }  

<br>

<table border=1 cellspacing=2 cellpadding=4 class="table table-striped table-hover">
 	<tr>
 		<td><b>Order ID</b></td>
 		<td><b>User</b>
 		<td><b>Date</b></td>
 		<td><b>Total</b></td>
 		<td><b>Items</b></td>
 	</tr>
 	<c:forEach items="${list}" var="item">
 	  	<tr>
	 		<td>${item.ID }</td>
 			<td>
 				${mapUsers.get(item.ID)}
 			</td>
 			<td>${item.date }</td>
 			<td>${item.total}</td>
 			<td>
 				${mapItems.get(item.ID)}
 			</td>
 	  	</tr>
 	  </c:forEach>
</table> 		

<h1>Filter by</h1>
<table>
<tr>
<td>
<form action="adminsearch" method="get">
	<input type=hidden name=id value="0">
	<button>Date</button>
</form>
</td>
<td>
<form action="admincategory" method="get">
	<input type=hidden name=id value="0">
	<button>Category</button>
</form>
</td>
</tr>
</table>

<jsp:include page="/WEB-INF/jsp/components/admin-footer.jsp"></jsp:include>
</body>
</html>