<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ page isELIgnored="false" %>
 <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />

<center>
<a href="home">Home</a> | 
<% if (session.getAttribute("user_id") == null ) { %>
	<a href="login">Login/Signup</a> | 
<% }  else { %>
	<a href="dashboard">Dashboard</a> | 
	<a href="cart">Cart</a> | 
	<a href="logout">Logout</a>
	<br>
	<a href="editprofile">Edit Profile</a> | 
	<a href="memberpurchases">Your Orders</a> 

<% }  %>
</center>

 
<br><br>