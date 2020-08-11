package com.la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.la.model.Classes;
import com.la.model.SubjectClass;

public class classDAO {
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

	public List<Classes> selectClassId(int id) {
		// TODO Auto-generated method stub
		List<Classes> t_list = new ArrayList<Classes>();
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Select classid from class where classid=? ");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Classes classes = new Classes();
				classes.setClassid(rs.getInt("classid"));
				t_list.add(classes);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return t_list;
	}

	public List<Classes> selectAllClass() {
		// TODO Auto-generated method stub
		List<Classes> t_list = new ArrayList<Classes>();
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Select * from class ");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Classes classes = new Classes();
				classes.setClassid(rs.getInt("classid"));
				classes.setClassname((rs.getString("classname")));
				t_list.add(classes);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return t_list;
	}

	public void insert(Classes classes) throws SQLException {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement("insert into class(classid, classname)  values(?,?);");
			statement.setInt(1, classes.getClassid());
			statement.setString(2, classes.getClassname());
			statement.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		try(Connection connection = getConnection()){
			
			PreparedStatement statement = connection.prepareStatement("Delete from class where classid = ? ");
			statement.setInt(1,id);
			statement.executeUpdate();
			System.out.println("success");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void generateReport(int id) {
		// TODO Auto-generated method stub
		
	}
}
