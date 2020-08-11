package com.la.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.classDAO;
import com.la.dao.studentDAO;
import com.la.model.Classes;
import com.la.model.Student;
import com.la.model.Teacher;


public class studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	studentDAO studentdao;
	classDAO classdao;
    public studentServlet() {
        super();
        // TODO Auto-generated constructor stub
        studentdao = new studentDAO();
        classdao = new classDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
		
		case "insertStudent":
			insertStudent(request,response);
			break;
		case "updateStudent":
			updateStudent(request,response);
			break;
		case "insert":
			insert(request,response);
			break;
		case "select":
			select(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		case "update":
			update(request,response);
		default:
			selectStudent(request,response);
			break;


			}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			Student student = new Student();
			System.out.println("ji");
			student.setClassname(request.getParameter("classname"));
			student.setStudentname(request.getParameter("studentname"));
			student.setStudentid(Integer.parseInt(request.getParameter("studentid")));
			student.setClassid(Integer.parseInt(request.getParameter("classid")));
			System.out.println(student);
			request.setAttribute("student", student);
			studentdao.update(student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/studentServlet?action=selectStudent");
			dispatcher.forward(request, response);
		}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Classes> c_list = classdao.selectAllClass();
		request.setAttribute("c_list", c_list);
		Student student = new Student();
		int id = Integer.parseInt(request.getParameter("id"));
		student = studentdao.selectStudentId(id);
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentUpdate.jsp");
		dispatcher.forward(request, response);
	}

	private void selectStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> s_list = studentdao.selectall();
		request.setAttribute("s_list", s_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentList.jsp");
		dispatcher.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		studentdao.delete(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentServlet?action=selectStudent");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Student student = new Student();
		student.setClassname(request.getParameter("classname"));
		student.setStudentname(request.getParameter("studentname"));
		student.setStudentid(Integer.parseInt(request.getParameter("studentid")));
		studentdao.insert(student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentServlet?action=selectStudent");
		dispatcher.forward(request, response);
		
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Classes> c_list = classdao.selectAllClass();
		request.setAttribute("c_list", c_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student_insert.jsp");
		dispatcher.forward(request, response);
	}

	private void select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
