<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sporty Shoes - Make Payment</title>
</head>
<body class="text-center">
<jsp:include page="/WEB-INF/jsp/components/header.jsp" ></jsp:include>
<jsp:include page="/WEB-INF/jsp/components/topbar.jsp" ></jsp:include>



<br><br>
Your card will be charged an amount of ${cartValue}<br><br>

<a href="completepurchase">Click to complete checkout</a>

<jsp:include page="/WEB-INF/jsp/components/footer.jsp"></jsp:include>
</body>
</html>