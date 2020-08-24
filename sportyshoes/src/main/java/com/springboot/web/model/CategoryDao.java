package com.springboot.web.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {
	@Query(value = "SELECT * FROM CATEGORY WHERE ID = ?1", nativeQuery = true)
	  Category findByEmailAddress(long id);
	
	@Query(value = "SELECT * FROM CATEGORY", nativeQuery = true)
	List<Category> getAllCategories();
	
	@Modifying
	@Query(value = "UPDATE CATEGORY SET Name=?1 WHERE ID = ?2 ", nativeQuery = true)
	  public void update( String name, long id);

	@Query(value = "SELECT * FROM CATEGORY WHERE NAME =?1", nativeQuery = true)
	List<Category> findId(String categoryId);

	

	
}
