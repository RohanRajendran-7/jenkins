package com.springboot.web.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.User;
import com.springboot.web.model.TodoDao;

@Service
public class UserService {
	
	@Autowired
	TodoDao userdao;

	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users =  userdao.findAll();
		return users;
	}

	@Transactional
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		User user = userdao.findID(userId);
		return user;
	}

	@Transactional
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		if(user.getID()==0) {
			user.setDateAdded(Calendar.getInstance().getTime());
			userdao.save(user);
		}else if (user.getID() > 0) {
			userdao.update(user.getFname(),user.getLname(), user.getAddress(),user.getAge(),user.getPwd(),user.getID());
		}
	}

	@Transactional
	public List<User> getUsers(String fname,String lname) {
		// TODO Auto-generated method stub
		return userdao.getUser(fname, lname);
	}


	
	

}
