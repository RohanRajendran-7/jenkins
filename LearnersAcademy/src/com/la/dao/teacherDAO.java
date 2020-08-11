package com.la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.la.model.Classes;
import com.la.model.Teacher;

public class teacherDAO {

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
	public List<Teacher> selectAll() throws SQLException{
		List<Teacher> t_list = new ArrayList<Teacher>();
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Select * from teacher");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setT_id(rs.getInt("t_id"));
				teacher.setT_name(rs.getString("t_name"));
				teacher.setSubjectname(rs.getString("subjectname"));
				teacher.setClassid(rs.getInt("classid"));
				teacher.setT_age(rs.getInt("t_age"));
				teacher.setT_salary(rs.getInt("t_salary"));
				teacher.setT_experience(rs.getInt("t_experience"));
				t_list.add(teacher);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return t_list;
	}
	
	public List<String> selectName(int id){
		List<String> list = new ArrayList<String>();
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Select t_name from teacher where classid=? ");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("t_name"));

			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public void insert(Teacher teacher) throws SQLException {
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("INSERT INTO teacher(t_name, t_age, t_salary, t_experience, classid, subjectname) VALUES(?,?,?,?,?,?);");
			statement.setString(1, teacher.getT_name());
			statement.setInt(2, teacher.getT_age());
			statement.setInt(3, teacher.getT_salary());
			statement.setInt(4, teacher.getT_experience());
			statement.setInt(5, teacher.getClassid());
			statement.setString(6, teacher.getSubjectname());
			statement.executeUpdate();
			System.out.println("success");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Delete from teacher where t_id = ? ");
			statement.setInt(1,id);
			statement.executeUpdate();
			System.out.println("success");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public Teacher selectTeacherId(int id) throws SQLException {
		Teacher teacher= new Teacher();
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("Select * from teacher where t_id = ?;");
			statement.setInt(1,id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				teacher.setClassid(rs.getInt("classid"));
				teacher.setSubjectname(rs.getString("subjectName"));
				teacher.setT_age(rs.getInt("t_age"));
				teacher.setT_id(rs.getInt("t_id"));
				teacher.setT_experience(rs.getInt("t_experience"));
				teacher.setT_name(rs.getString("t_name"));
				teacher.setT_salary(rs.getInt("t_salary"));
				}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return teacher;
	}
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("Update teacher set subjectname = ?,t_age=?,classid=?,t_experience=?,t_name=?,t_salary=? WHERE t_id=? ;");
			statement.setString(1, teacher.getSubjectname());
			statement.setInt(2, teacher.getT_age());
			statement.setInt(3, teacher.getClassid());
			statement.setInt(4, teacher.getT_experience());
			statement.setString(5, teacher.getT_name());
			statement.setInt(6, teacher.getT_salary());
			statement.setInt(7, teacher.getT_id());
			statement.execute();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
