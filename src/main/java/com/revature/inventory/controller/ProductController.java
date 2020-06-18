package com.revature.inventory.controller;

import com.revature.inventory.dao.ProductDao;
import com.revature.inventory.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProductController {
	
	private final ProductDao productDao;

	@Autowired
	public ProductController(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@GetMapping("/product/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) {
		return productDao.findById(id);
	}

	@GetMapping("/product")
	public List<Product> getAllProduct() {
		return productDao.findAll();
	}

	@PostMapping("/product")
	public Product createProductById(@RequestBody Product product) {
		return productDao.save(product);
	}

	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return productDao.save(product);
	}

	@DeleteMapping("/product/{id}")
	public void deleteProductById(@PathVariable Long id) {
		productDao.deleteById(id);
	}

}
