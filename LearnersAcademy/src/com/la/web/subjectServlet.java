package com.la.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.classDAO;
import com.la.dao.subjectDAO;
import com.la.model.Classes;
import com.la.model.Subject;

public class subjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	subjectDAO subjectdao;
	classDAO classdao;
       
    public subjectServlet() {
        super();
        // TODO Auto-generated constructor stub
        subjectdao = new subjectDAO();
        classdao = new classDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		switch(action) {
		case "insert":
			insert(request,response);
			break;
		case "insertSubject":

			insertSubject(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		default:
			selectSubjects(request,response);
			break;
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		subjectdao.delete(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subjectServlet?action=selectSubjects");
		dispatcher.forward(request, response);
	}


	private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Classes> c_list = classdao.selectAllClass();
		request.setAttribute("c_list", c_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectForm.jsp");
		dispatcher.forward(request, response);
	}


	private void selectSubjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Subject> s_list= subjectdao.selectall();
		request.setAttribute("s_list", s_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectList.jsp");
		dispatcher.forward(request, response);
	}


	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Subject subject = new Subject();
		subject.setClassid(Integer.parseInt(request.getParameter("classid")));
		subject.setSubjectid(Integer.parseInt(request.getParameter("subjectid")));
		subject.setSubjectname(request.getParameter("subjectname"));
		subjectdao.insert(subject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subjectServlet?action=selectSubjects");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
