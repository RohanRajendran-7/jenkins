package com.springboot.web.model;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.User;




@Repository
public class UserDAO {
	
//	@Autowired
//	private EntityManager entityManager;
//	
//	private Session getSession() {
//		// TODO Auto-generated method stub
//		 Session session = entityManager.unwrap(Session.class);
//		 return session;
//	}
	
	@Autowired
	private TodoDao userdao;
	
	public UserDAO() {};
	
	@PostConstruct
	public void init() {
		userdao.findAll();
	}

	User user;

	public User authenticate(String emailId, String pwd) {
		
		List<User> user = userdao.findAll();
		return user.get(0);
		
		
	}


}
