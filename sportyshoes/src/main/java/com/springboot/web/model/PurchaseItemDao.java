package com.springboot.web.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Purchase;
import com.ecommerce.entity.PurchaseItem;

@Repository
public interface PurchaseItemDao extends JpaRepository<PurchaseItem, Long> {
	
	@Query(value = "SELECT * FROM PURCHASE_ITEMS WHERE ID = ?1 ", nativeQuery = true)
	  public List<PurchaseItem> getAllByID(long id);
	
	@Query(value = "SELECT PRICE FROM PURCHASE_ITEMS WHERE ID = ?1 ", nativeQuery = true)
	  public BigDecimal total(long id);
	
	@Query(value = "SELECT * FROM PURCHASE_ITEMS WHERE PRODUCT_ID = ?1 ", nativeQuery = true)
	public List<PurchaseItem> getPurchaseId(long id);


	

	

}
