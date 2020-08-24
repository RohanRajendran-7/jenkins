package com.springboot.web.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Purchase;

@Repository
public interface PurchaseDao extends JpaRepository<Purchase, Long> {

	@Query(value = "SELECT * FROM PURCHASES WHERE ID = ?1 ", nativeQuery = true)
	  public List<Purchase> findAllById(long id);
	@Query(value = "SELECT * FROM PURCHASES ", nativeQuery = true)
	public List<Purchase> find();
	
	@Modifying
	@Query(value = "UPDATE PURCHASES SET USER_ID=?1,GROSS_TOTAL=?2 WHERE ID = ?3 ", nativeQuery = true)
	public void update(long userId, BigDecimal total, long id);

	@Modifying
	@Query(value = "UPDATE PURCHASES SET GROSS_TOTAL= GROSS_TOTAL-?1 WHERE ID = ?2 ", nativeQuery = true)
	public void set(BigDecimal val, long id);
	
	@Query(value = "SELECT * FROM PURCHASES WHERE DATE >= ?1 ", nativeQuery = true)
	public List<Purchase> getDate(Date date);
	
	

	
	
	
	
	
	

	
	
	
}
