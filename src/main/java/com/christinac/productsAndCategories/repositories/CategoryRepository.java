package com.christinac.productsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.christinac.productsAndCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	@Override
	public List<Category> findAll();
}
