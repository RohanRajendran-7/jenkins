package com.springboot.web.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Admin;
import com.ecommerce.entity.User;

@Repository
public interface TodoDao extends JpaRepository<User, Long>  {

	@Query(value = "SELECT * FROM USERS WHERE ID = ?1 ", nativeQuery = true)
	  public User findID(long userId);
	
	@Modifying
	@Query(value = "UPDATE USERS SET FNAME=?1, LNAME=?2, ADDRESS=?3,AGE=?4,PWD=?5 WHERE ID = ?6 ", nativeQuery = true)
	public void update(String fname, String lname, String address, int age, String pwd, long id);

	@Query(value="SELECT * FROM USERS WHERE FNAME = ?1 AND LNAME = ?2", nativeQuery = true)
	public List<User> getUser(String fname, String lname);

	@Query(value = "SELECT * FROM USERS WHERE EMAILID = ?1 AND PWD = ?2", nativeQuery = true)
	  	public List<User> authenticate(String emailId, String pwd);
	

	
	
	
	

}
