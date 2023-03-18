package com.christinac.productsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.christinac.productsAndCategories.models.Category;
import com.christinac.productsAndCategories.models.Product;
import com.christinac.productsAndCategories.services.CategoryService;
import com.christinac.productsAndCategories.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productServ;
	@Autowired
	private CategoryService categoryServ;
	
	@GetMapping("/new")
	public String newProduct(@ModelAttribute("newProduct") Product newProduct) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/new")
	public String viewProduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			productServ.create(newProduct);
			return "redirect:/";
		}
		
	}
	@GetMapping("/{productId}/view")
	public String viewProduct(@PathVariable("productId") Long productId, Model model, @ModelAttribute("unaddedCategories") Category category) {
		Product product = productServ.findById(productId);
		model.addAttribute("product", product);
		List<Category> allCategories = categoryServ.findAll();
		model.addAttribute("allCategories", allCategories);
		return "viewProduct.jsp";
	}
	
	@PutMapping("/{productId}/add-categories")
	public String addCategories(@ModelAttribute("unaddedCategory") Category category, @RequestParam(name="categories") Long categoryId, @PathVariable("productId") Long productId) {
		Category thisCategory = categoryServ.findById(categoryId);
		Product product = productServ.findById(productId);
		List<Category> categoryList = product.getCategories();
		categoryList.add(thisCategory);
		product.setCategories(categoryList);
		productServ.update(product);
		return "redirect:/product/" + productId + "/view";
	}
	
	
	
	
	
	
	
}
