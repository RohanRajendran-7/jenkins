 <%
 	String Username=null;
	if (session.getAttribute("user") == null)
		response.sendRedirect("Login.jsp");
	Username= (String)session.getAttribute("user");
%>
 
 
 <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="cover.css" />
  
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">Welcome <%= Username %></h3>
      <br/>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link" href="<%= request.getContextPath() %>/dashboard.jsp">Home</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/teacherServlet?action=selectEmployee">Teacher</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/classServlet?action=selectClass">Class</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/subjectServlet?action=selectSubjects">Subjects</a>
        <a class="nav-link" href="<%= request.getContextPath() %>/studentServlet?action=selectStudents">Students</a>
        <a href="<%= request.getContextPath() %>/teacherServlet?action=logout">
        	<button style='margin-left:10px' class="btn btn-outline-danger"> Logout </button>
        </a>
        
      </nav>
    </div>
  </header>
