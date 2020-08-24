package com.springboot.web.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Product;
import com.springboot.web.model.ProductDAO;

@Service
public class ProductService {

	@Autowired
	ProductDAO productdao;

	@Transactional
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productdao.findAll();
	}

	@Transactional
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		if(product.getID() == 0)
			productdao.save(product);
		else if(product.getID()>0) {
			String name = product.getName();
			BigDecimal price = product.getPrice();
			long category_id = product.getCategoryId();
			long id = product.getID();
			productdao.update(name,price,category_id,id);
		}
	}

	@Transactional
	public Product getProductById(long idValue) {
		// TODO Auto-generated method stub
		List<Product> products = productdao.ID(idValue);
		return products.get(0);
	}

	@Transactional
	public void deleteProduct(long idValue) {
		// TODO Auto-generated method stub
		productdao.deleteById(idValue);
	}
	
	@Transactional
	public List<Product> sort(long num) {
		// TODO Auto-generated method stub
		return productdao.sort(num);
	}


}
