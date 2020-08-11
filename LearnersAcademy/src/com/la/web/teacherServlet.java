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
import javax.servlet.http.HttpSession;

import com.la.dao.classDAO;
import com.la.dao.subjectDAO;
import com.la.dao.teacherDAO;
import com.la.model.Classes;
import com.la.model.Subject;
import com.la.model.Teacher;


public class teacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	teacherDAO teacherdao;
	classDAO classdao;
	subjectDAO subjectdao;
    public teacherServlet() {
        super();
        // TODO Auto-generated constructor stub
        teacherdao = new teacherDAO();
        classdao = new classDAO();
        subjectdao = new subjectDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
		
		case "insertTeacher":
			insertTeachers(request,response);
			break;
		case "insert":
			try {
				insert(request,response);
			} catch (Exception e1) {
				// TODO Auto-generate
				System.out.println(e1.getMessage());
			}
			break;
		case "updateTeacher":
			try {
				updateTeacher(request,response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
				break;
		case "update":
			update(request,response);
			break;
		case "delete":
			delete(request,response);
		case "logout":
			logout(request,response);
			break;
		default:
			try {

				selectTeachers(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		}
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		int id = Integer.parseInt(request.getParameter("id"));
		teacher = teacherdao.selectTeacherId(id);
		request.setAttribute("teacher", teacher);
		
		List<Classes> c_list = classdao.selectAllClass();
		request.setAttribute("c_list", c_list);
		
		
		List<Subject> s_list = subjectdao.selectall();
		request.setAttribute("s_list", s_list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherUpdate.jsp");
		dispatcher.forward(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		teacherdao.delete(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacherServlet?action=selectTeachers");
		dispatcher.forward(request, response);
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);

		if (session != null)
			session.invalidate();
		response.sendRedirect("login.jsp");
	}
	private void selectTeachers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		teacherDAO teacherdao = new teacherDAO();
		List<Teacher> teacher_list = teacherdao.selectAll();
		request.setAttribute("t_list", teacher_list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherList.jsp");
		dispatcher.forward(request, response);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.setClassid(Integer.parseInt(request.getParameter("t_id")));
		teacher.setSubjectname(request.getParameter("subjectname"));
		teacher.setT_name((request.getParameter("t_name")));
		teacher.setT_age(Integer.parseInt(request.getParameter("t_age")));
		teacher.setT_id(Integer.parseInt(request.getParameter("t_id")));
		teacher.setT_salary(Integer.parseInt(request.getParameter("t_salary")));
		teacher.setT_experience(Integer.parseInt(request.getParameter("t_experience")));
		request.setAttribute("teacher", teacher);
		teacherdao.update(teacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacherServlet?action=selectTeachers");
		dispatcher.forward(request, response);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.setT_id(Integer.parseInt(request.getParameter("t_id")));
		teacher.setT_name(request.getParameter("t_name"));
		teacher.setT_age(Integer.parseInt(request.getParameter("t_age")));
		teacher.setT_experience(Integer.parseInt(request.getParameter("t_experience")));
		teacher.setT_salary(Integer.parseInt(request.getParameter("t_salary")));
		teacher.setClassid(Integer.parseInt(request.getParameter("classid")));

		teacher.setSubjectname(request.getParameter("subjectname"));

		teacherdao.insert(teacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacherServlet?action=selectTeachers");
		dispatcher.forward(request, response);		
	}
	private void insertTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Classes> c_list = classdao.selectAllClass();
		request.setAttribute("c_list", c_list);
		List<Subject> s_list = subjectdao.selectall();
		request.setAttribute("s_list", s_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
