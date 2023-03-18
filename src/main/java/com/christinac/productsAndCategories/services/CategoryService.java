package com.christinac.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christinac.productsAndCategories.models.Category;
import com.christinac.productsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	// find all
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
	// find by Id
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {			
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	// create
	public Category create(Category p) {
		return categoryRepo.save(p);
	}
	// update
	public Category update(Category p) {
		return categoryRepo.save(p);
	}
	
	// delete
	public void delete(Category p) {
		categoryRepo.delete(p);
	}
	
	
}
