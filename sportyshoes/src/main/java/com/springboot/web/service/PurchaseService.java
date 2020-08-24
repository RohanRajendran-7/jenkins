package com.springboot.web.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Purchase;
import com.springboot.web.model.PurchaseDao;

@Service
public class PurchaseService {

	@Autowired
	PurchaseDao purchasedao;
	
	@Transactional
	public List<Purchase> getAllItemsByUserId(long userId) {
		// TODO Auto-generated method stub
		List<Purchase> list = purchasedao.findAllById(userId);

		return list;
	}

	@Transactional
	public List<Purchase> getAllItems() {
		// TODO Auto-generated method stub
		List<Purchase> ItemsList = purchasedao.find();
		return ItemsList;
	}

	@Transactional
	public long updatePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		long newId = 0;
		if (purchase.getID() == 0) {
			purchasedao.save(purchase);
			newId = purchase.getID();
		} else {
			purchasedao.update(purchase.getUserId(),purchase.getTotal(),purchase.getID());
			newId = purchase.getID();
		}
		return newId;
	}
	
	@Transactional
	public List<Purchase> findById(Long long1) {
		// TODO Auto-generated method stub
		return purchasedao.findAllById(long1);
	}

	@Transactional
	public List<Purchase> date(Date date) {
		// TODO Auto-generated method stub
		return purchasedao.getDate(date);
	}
}
