package com.la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.la.model.Classes;
import com.la.model.Subject;

public class subjectDAO {
	
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
	public List<String> selectName(int id){
		List<String> list = new ArrayList<String>();
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Select subjectname from subject where classid=? ");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("subjectname"));

			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public List<Subject> selectSubject(int id) {
		// TODO Auto-generated method stub
		List<Subject> t_list = new ArrayList<Subject>();
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Select * from subject where classid=? ");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Subject classes = new Subject();
				classes.setSubjectid(rs.getInt("subjectid"));
				classes.setSubjectname(rs.getString("subjectname"));
				classes.setClassid(rs.getInt("classid"));
				t_list.add(classes);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return t_list;
	}

	public List<Subject> selectall() {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			
			List<Subject> sub_list = new ArrayList<Subject>();
			PreparedStatement statement = connection.prepareStatement("Select * from subject ");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Subject subject = new Subject();
				subject.setSubjectname(rs.getString("subjectname"));
				subject.setSubjectid(rs.getInt("subjectid"));
				subject.setClassid(rs.getInt("classid"));
				sub_list.add(subject);
				System.out.println(sub_list);
			}
			return sub_list;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void insert(Subject subject) {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("insert into subject(subjectid, subjectname, classid)  values(?,?,?);");
			statement.setInt(3, subject.getClassid());
			statement.setInt(1, subject.getSubjectid());
			statement.setString(2, subject.getSubjectname());
			statement.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Delete from subject where subjectid = ? ");
			statement.setInt(1,id);
			statement.executeUpdate();
			System.out.println("success");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
