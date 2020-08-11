<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />
</head>
<body class="text-center">
	<div class="bg">
	<%@ include file="header.jsp"%>
	<div style="margin-top:30px">
  <main role="main" class="inner cover">
		<h1 class="cover-heading">Welcome To Learner's Academy</h1>
		<p class="lead">Please follow the guide below for better results</p>

		<div class="container">
		  <div class="row">
		    <div class="col-sm">
		      <div class="container p-3 my-3 bg-dark text-white">
				
				<p class="lead">Home -> Return to dashboard</p>
				<p class="lead">Teacher -> To view the Teacher List and it's operations </p>
				<p class="lead">Teacher->Update Class -> To Update the Teacher details and to assign classes, subjects to teacher individually </p>
				<p class="lead">Teacher -> delete-> To Delete records </p>
			</div>
		    </div>
		    <div class="col-sm">
	      		<div class="container p-3 my-3 bg-dark text-white">
					<p class="lead">Home -> Return to dashboard</p>
					<p class="lead">Class -> To view the Class List and it's operations </p>
					<p class="lead">Class->Show Subjects -> To View the Subjects for the corresponding class </p>
					<p class="lead">Class -> delete-> To Delete records </p>
					<p class="lead">Class -> add-> To Add records </p>
					<p class="lead" style="color:red">Class->Generate Reports-> Kindly Verify that there are three records of subjects and teachers before generating the report</p>
				</div>
		    </div>
		    <div class="col-sm">
		      <div class="container p-3 my-3 bg-dark text-white">
					<p class="lead">Home -> Return to dashboard</p>
					<p class="lead">Subjects -> To view the Subjects List and add Subject </p>
					<p class="lead">Students-> Update  -> To Update the Student details and to assign classes to student individually </p>
					<p class="lead">Students -> delete-> To Delete records </p>
				</div>
		    </div>
		  </div>
		</div>

  </main>
  </div>
  </div>
</body>
</html>