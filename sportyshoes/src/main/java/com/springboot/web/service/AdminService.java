package com.springboot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Admin;
import com.springboot.web.model.AdminDao;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao admindao;
	
	public Admin authenticate(String adminId , String pwd) {
		List<Admin> ad= admindao.authenticate(adminId, pwd);
		Admin admin = ad.get(0);
		return admin;
	}
	@Transactional
	public Admin getAdminById(Long attribute) {
		// TODO Auto-generated method stub
		List<Admin> admins = admindao.ID(attribute);
		return admins.get(0);
	}
	@Transactional
	public void updatePwd(Admin admin) {
		// TODO Auto-generated method stub
		String pwd = admin.getAdminPwd();
		long id = admin.getID();
		admindao.update(pwd,id);
	}

}
