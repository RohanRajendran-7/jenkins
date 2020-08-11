package com.la.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Username = request.getParameter("email");
		String Password = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		if(Username.equals("admin@la.com") && (Password.equals("password"))) {
			System.out.println("pop");
			HttpSession session = request.getSession();
			
			session.setAttribute("user", Username);
			session.setMaxInactiveInterval(6000);
			response.sendRedirect("dashboard.jsp");
		}
		else {
			writer.println("<center><h3 style='color:red' class='form-signin'>Invalid Credentials.. Try Again..</h3></center>");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
		}
		

	}
}
