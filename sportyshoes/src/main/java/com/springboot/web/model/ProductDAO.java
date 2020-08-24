package com.springboot.web.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Admin;
import com.ecommerce.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product,Long > {

	@Modifying
	@Query(value = "UPDATE EPRODUCT SET NAME=?1 ,PRICE = ?2, CATEGORY_ID = ?3 WHERE ID = ?4 ", nativeQuery = true)
	  public void update(String name, BigDecimal price, long category_id, long id);

	@Query(value = "SELECT * FROM EPRODUCT WHERE ID = ?1 ", nativeQuery = true)
	  public List<Product> ID(long adminId );

	@Modifying
	@Query(value = "UPDATE EPRODUCT SET CATEGORY_ID = 0 WHERE CATEGORY_ID = ?1 ", nativeQuery = true)
	  public void updateId(long idValue);
	
	@Query(value = "SELECT * FROM EPRODUCT WHERE CATEGORY_ID = ?1 ", nativeQuery = true)
	public List<Product> sort(long categoryId);
	

	
	
	

	
}
