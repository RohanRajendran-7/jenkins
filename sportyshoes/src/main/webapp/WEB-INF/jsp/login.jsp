<html>

<head>
<title>First Web Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />
</head>

<body class="text-center">
	<font color="red">${errorMessage}</font>
<form name=frmLogin action="loginaction" method="post" class="form-signin">
	
 <table border=1 cellspacing=2 cellpadding=4 class="table table-striped table-hover">
 	<tr>
 		<td width=25%>Email id*</td>
 		<td><input name=email_id maxlength=50></td>
 	</tr>
 	<tr>
 		<td width=25%>Password*</td>
 		<td><input name=pwd maxlength=10 type="password"></td>
 	</tr>
 	<tr>
 		<td colspan=2>
 			<button>Login</button><br>
 			<a href="signup">Not a member? Signup</a>
 		</td>
 	</tr>
 </table>
</form>
</body>

</html>