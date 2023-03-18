package com.christinac.productsAndCategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.christinac.productsAndCategories.models.Category;
import com.christinac.productsAndCategories.models.Product;
import com.christinac.productsAndCategories.services.CategoryService;
import com.christinac.productsAndCategories.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productServ;
	@Autowired
	private CategoryService categoryServ;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Product> allProducts = productServ.findAll();
		model.addAttribute("allProducts", allProducts);
		List<Category> allCategories = categoryServ.findAll();
		model.addAttribute("allCategories", allCategories);
		return "index.jsp";
	}
}
