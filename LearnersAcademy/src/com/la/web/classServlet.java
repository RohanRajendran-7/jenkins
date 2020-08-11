package com.la.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.classDAO;
import com.la.dao.studentDAO;
import com.la.dao.subjectDAO;
import com.la.dao.teacherDAO;
import com.la.model.Classes;
import com.la.model.Student;
import com.la.model.Subject;
import com.la.model.SubjectClass;


public class classServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	classDAO classdao;
	subjectDAO subjectdao;
	teacherDAO teacherdao;
	studentDAO studentdao;
    public classServlet() {
        super();
        // TODO Auto-generated constructor stub
        classdao = new classDAO();
        subjectdao = new subjectDAO();
        teacherdao = new teacherDAO();
        studentdao = new studentDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
		
		case "insertClass":
			insertClass(request,response);
			break;
		case "insert":
			try {
				insert(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "select":
			select(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		case "report":
			report(request,response);
			break;
		default:
			selectClass(request,response);
			break;
		}
	}

	private void report(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		List<Student> stu = new ArrayList<Student>();
		int id = Integer.parseInt(request.getParameter("id"));
		SubjectClass subclass = new SubjectClass();
		arr= subjectdao.selectName(id);
		System.out.println(id);
		subclass.setSub_name1(arr.get(0));
		subclass.setSub_name2(arr.get(1));
		subclass.setSub_name3(arr.get(2));
		temp = teacherdao.selectName(id);
		
		subclass.setTut_name1(temp.get(0));
		subclass.setTut_name2(temp.get(1));
		subclass.setTut_name3(temp.get(2));
		stu=studentdao.selectName(id);
		System.out.println(stu);
		request.setAttribute("stu", stu);
		request.setAttribute("subclass", subclass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("report.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		List<Subject> s_list = subjectdao.selectSubject(id);
		request.setAttribute("s_list", s_list);
		System.out.println(s_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectClassForm.jsp");
		dispatcher.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		classdao.delete(Integer.parseInt(request.getParameter("id")));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classServlet?action=selectClass");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		Classes classes = new Classes();
		classes.setClassid(Integer.parseInt(request.getParameter("classid")));
		classes.setClassname(request.getParameter("classname"));
		classdao.insert(classes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classServlet?action=selectClass");
		dispatcher.forward(request, response);
		
	}

	private void insertClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("class_insert.jsp");
		dispatcher.forward(request, response);
	}

	private void selectClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Classes> c_list = classdao.selectAllClass();
		request.setAttribute("c_list", c_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class_list.jsp");
		dispatcher.forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
