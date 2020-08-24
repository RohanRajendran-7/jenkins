<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="signin.css" />
</head>
<body>
<jsp:include page="/WEB-INF/jsp/components/admin-header.jsp" ></jsp:include>

${error}<br>

<form name=frmLogin action="adminloginaction" method="post">
 <table border=1 cellspacing=2 cellpadding=4 class="table table-striped table-hover">
 	<tr>
 		<td width=25%>Admin id*</td>
 		<td><input name=admin_id maxlength=20></td>
 	</tr>
 	<tr>
 		<td width=25%>Admin Password*</td>
 		<td><input name=admin_pwd maxlength=10 type="password"></td>
 	</tr>
 	<tr>
 		<td colspan=2>
 			<button>Login</button>
 		</td>
 	</tr>
 </table>
</form>

<jsp:include page="/WEB-INF/jsp/components/admin-footer.jsp"></jsp:include>
</body>
</html>