package com.la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.la.model.Student;

public class studentDAO {

	Connection connection = null;
	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnersacademy", "root",
					"Premsiddharth_06");
		} catch (Exception ex) {
			System.out.println("Exception Raised...");
			System.out.println(ex.getMessage());
		}
		return connection;

	}
	
	public List<Student> selectall() {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			
			List<Student> sub_list = new ArrayList<Student>();
			PreparedStatement statement = connection.prepareStatement("Select * from student ");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setClassname((rs.getString("classname")));
				student.setStudentid(rs.getInt("studentid"));
				student.setStudentname(rs.getString("studentname"));
				student.setClassid(rs.getInt("classid"));
				sub_list.add(student);
				System.out.println(sub_list);
			}
			return sub_list;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void insert(Student student) {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("insert into student(studentid, studentname, classname,classid)  values(?,?,?,?);");
			statement.setInt(1, student.getStudentid());
			statement.setString(2, student.getStudentname());
			statement.setString(3, student.getClassname());
			statement.setInt(4, student.getClassid());
			statement.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public List<Student> selectName(int id){
		List<Student> list = new ArrayList<Student>();
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Select studentname from student where classid=? ");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setStudentname(rs.getString("studentname"));
				
				list.add(student);

			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public Student selectStudentId(int id) {
		// TODO Auto-generated method stub
		Student student= new Student();
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("Select * from student where studentid = ?;");
			statement.setInt(1,id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				student.setClassname(rs.getString("classname"));
				student.setStudentname(rs.getString("studentname"));
				student.setStudentid(rs.getInt("studentid"));
				student.setClassid(rs.getInt("classid"));
				}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return student;
	}
	public void update(Student student) {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("Update student set studentname=?, classname=?,classid=? where studentid=?; ");
			statement.setString(1, student.getStudentname());
			statement.setInt(4, student.getStudentid());
			statement.setInt(3, student.getClassid());
			statement.setString(2, student.getClassname());
			statement.execute();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Delete from student where studentid = ? ");
			statement.setInt(1,id);
			statement.executeUpdate();
			System.out.println("success");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
