package com.revature.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.inventory.dao.CategoryDao;
import com.revature.inventory.model.Category;

@CrossOrigin
@RestController
public class CategoryController {
	
	private final CategoryDao categoryDao;
	
	
	@Autowired
	public CategoryController(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}


	@GetMapping("/category/{id}")
	public java.util.Optional<Category> getCategoryById(@PathVariable Long id) {
		return categoryDao.findById(id);
	}

	@GetMapping("/category")
	public List<Category> getAllCategory() {
		return categoryDao.findAll();
	}

	@PostMapping("/category")
	public Category createCategoryById(@RequestBody Category category) {
		return categoryDao.save(category);
	}


	@PutMapping("/category")
	public Category updateCategory(@RequestBody Category category) {
		return categoryDao.save(category);
	}

	@DeleteMapping("/category/{id}")
	public void deleteCategoryById(@PathVariable Long id) {
		categoryDao.deleteById(id);
	}
}
