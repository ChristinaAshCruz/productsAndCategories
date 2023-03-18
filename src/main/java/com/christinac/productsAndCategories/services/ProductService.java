package com.christinac.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christinac.productsAndCategories.models.Product;
import com.christinac.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	// find all
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	// find by Id
	public Product findById(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {			
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	// create
	public Product create(Product p) {
		return productRepo.save(p);
	}
	// update
	public Product update(Product p) {
		return productRepo.save(p);
	}
	
	// delete
	public void delete(Product p) {
		productRepo.delete(p);
	}
	
	
}
