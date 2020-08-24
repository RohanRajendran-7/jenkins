<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Browse Members</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />
<body class="text-center">
<jsp:include page="/WEB-INF/jsp/components/admin-header.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/jsp/components/admin-topbar.jsp" ></jsp:include>

Total Members: ${list.size() } &nbsp;&nbsp; <a href="adminsearchusers?id=0">Search Users</a> 

<table border=1 cellspacing=2 cellpadding=4 class="table table-striped table-hover">
 	<tr>
 		<td><b>Name</b></td>
 		<td><b>Email</b></td>
 		<td><b>Signup Date</b></td>
 		<td><b>Age</b></td>
 		<td><b>Address</b></td>
 	</tr>
 	<c:forEach items="${list}" var="item">
 	  	<tr>
	 		<td>${item.fname}&nbsp;${item.lname }</td>
 			<td>${item.email}</td>
 			<td>${item.dateAdded}</td>
 			<td>${item.age}</td>
 			<td>${item.address}</td>
 			
 	  	</tr>
 	  </c:forEach>
</table> 		
	


<jsp:include page="/WEB-INF/jsp/components/admin-footer.jsp"></jsp:include>
</body>
</html>