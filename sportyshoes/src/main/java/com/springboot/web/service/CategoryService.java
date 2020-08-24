package com.springboot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Category;
import com.springboot.web.model.CategoryDao;
import com.springboot.web.model.ProductDAO;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categorydao;
	
	@Autowired
	private ProductDAO productdao;
	
	public Category getCategoryById(long id) {
		Category category =  categorydao.findByEmailAddress(id);
		return category;
	}
	
	 @Transactional
	 public String getCategoriesDropDown(long id) {
		 StringBuilder sb = new StringBuilder("");
		 List<Category> list = getAllCategories();
		 for(Category cat: list) {
			 if (cat.getID() == id)
				 sb.append("<option value=" + String.valueOf(cat.getID()) + " selected>" + cat.getName() + "</option>");
			 else
				 sb.append("<option value=" + String.valueOf(cat.getID()) + ">" + cat.getName() + "</option>");
				 
		 }
		 return sb.toString();
		}
	 
	@Transactional
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		if (category.getID() == 0)
			categorydao.save(category);
		else if (category.getID() > 0) {
			categorydao.update(category.getName(), category.getID());
		}
	}

	@Transactional
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> list = categorydao.getAllCategories();
		return list;
	}

	@Transactional
	public void deleteCategory(long idValue) {
		// TODO Auto-generated method stub
		productdao.updateId(idValue);
		
		categorydao.deleteById(idValue);
	}

	@Transactional
	public long findCat(String categoryId) {
		// TODO Auto-generated method stub
		List<Category> list = categorydao.findId(categoryId);
		return list.get(0).getID();
	}
		
}
