package com.springboot.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.springboot.web.service.CategoryService;
import com.springboot.web.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryservice;
	@Autowired
	ProductService productService;
	  @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	    public String home(ModelMap map,  javax.servlet.http.HttpServletRequest request) 
	    {
		    HttpSession session = request.getSession();
			List<Product> list = productService.getAllProducts();
			
			// use MAP to map the category names to product rows
			 HashMap<Long, String> mapCats = new HashMap<Long, String>();
			  for(Product product: list) {
				  Category category = categoryservice.getCategoryById(product.getCategoryId());
				  if (category != null)
					  mapCats.put(product.getID(), category.getName());
			  }
			  
			map.addAttribute("list", list);
			map.addAttribute("mapCats", mapCats);
		    map.addAttribute("pageTitle", "SPORTY SHOES - HOMEPAGE"); 
	        return "index"; 
	    }	
	
}
