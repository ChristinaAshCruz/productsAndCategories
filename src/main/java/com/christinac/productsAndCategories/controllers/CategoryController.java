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
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryServ;
	@Autowired
	private ProductService productServ;
	
	@GetMapping("/new")
	public String newCategory(@ModelAttribute("newCategory") Category newCategory) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/new")
	public String createCategory(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			categoryServ.create(newCategory);
			return "redirect:/";
		}
	}
	
	@GetMapping("/{categoryId}/view")
	public String viewCategory(@PathVariable("categoryId") Long categoryId, Model model, @ModelAttribute("unaddedProduct") Product product) {
		Category category = categoryServ.findById(categoryId);
		model.addAttribute("category", category);
		List<Product> allProducts = productServ.findAll();
		model.addAttribute("allProducts", allProducts);
		return "viewCategory.jsp";
	}
	
	@PutMapping("/{categoryId}/add-products")
	public String addProducts(@ModelAttribute("unaddedProduct") Product product, @RequestParam(name="products") Long productId, @PathVariable("categoryId") Long categoryId) {
		Product thisProduct = productServ.findById(productId);
		Category category = categoryServ.findById(categoryId);
		List<Product> productList = category.getProducts();
		productList.add(thisProduct);
		category.setProducts(productList);
		categoryServ.update(category);
		return "redirect:/category/" + categoryId + "/view";
	}
	
}
