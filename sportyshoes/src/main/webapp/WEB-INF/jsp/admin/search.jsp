<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Add/Edit Product Category</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />
</head>
<body class="text-center">
<jsp:include page="/WEB-INF/jsp/components/admin-header.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/jsp/components/admin-topbar.jsp" ></jsp:include>

<%
if (request.getParameter("error") != null)
	out.print(request.getParameter("error"));
%>
<form name=frmProduct method=get action="adminresults">
	<input type=hidden name=id value="${product.ID }">
<table border=1 cellspacing=2 cellpadding=4 class="table table-striped table-hover">
	<tr>
 		<td width=25%>Name*</td>
 		<td>
			<input type ="text" name="fname" placeholder="Enter first name to search"/>
			<input type ="text" name="lname" placeholder="Enter last name to search"/>
 		</td>
 	</tr>
 	
 	<tr>
 		<td colspan=2>
 			<button>Search</button>
 		</td>
 	</tr>
 </table>
</form>

<jsp:include page="/WEB-INF/jsp/components/admin-footer.jsp"></jsp:include>
</body>
</html>