package com.springboot.web.service;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Purchase;
import com.ecommerce.entity.PurchaseItem;
import com.springboot.web.model.PurchaseDao;
import com.springboot.web.model.PurchaseItemDao;

@Service
public class PurchaseItemService {
	
	@Autowired
	PurchaseItemDao purchaseitemdao;
	
	@Autowired
	PurchaseDao purchasedao;
	

	@Transactional
	public List<PurchaseItem> getAllItemsByPurchaseId(long id) {
		// TODO Auto-generated method stub
		return purchaseitemdao.getAllByID(id);
	}

	@Transactional
	public void updateItem(PurchaseItem pItem) {
		// TODO Auto-generated method stub
		purchaseitemdao.save(pItem);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public void deleteItem(long id) {
		//Pending: Purchase total in purchase table should be updated after this
		BigDecimal val = purchaseitemdao.total(id);
		purchasedao.set(val,id);
		purchaseitemdao.deleteById(id);
		
	}

	@Transactional
	public List<PurchaseItem> getCategoryById(long id) {
		// TODO Auto-generated method stub
		List<PurchaseItem> item = purchaseitemdao.getPurchaseId(id);
		return item;
	}

}
