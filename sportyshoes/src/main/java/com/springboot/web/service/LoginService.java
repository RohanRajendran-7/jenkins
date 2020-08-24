package com.springboot.web.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Admin;
import com.ecommerce.entity.User;
import com.springboot.web.model.TodoDao;
import com.springboot.web.model.UserDAO;

@Service
public class LoginService {

	@Autowired
	private TodoDao userdao;
	
	UserDAO temp;
	public LoginService() {}
	
	@PostConstruct
	public void init() {
		userdao.findAll();
	}
	
	private UserDAO user;
	
	@Transactional
	public User authenticate(String emailId, String pwd) {
		// TODO Auto-generated method stub
		List<User> ad= userdao.authenticate(emailId, pwd);
		User user = ad.get(0);
		return user;
	}
	@Transactional
	public String updateUser(User user2) {
		// TODO Auto-generated method stub
		 userdao.save(user2);
		 return "success";
	}
	

}
