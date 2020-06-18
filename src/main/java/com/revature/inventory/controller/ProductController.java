package com.revature.inventory.controller;

import com.revature.inventory.dao.ProductDao;
import com.revature.inventory.model.Product;
import com.revature.inventory.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;


	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}

	@GetMapping("/product")
	public List<Product> getAllProduct() {
		return productService.findAllProducts();
	}

	@PostMapping("/product")
	public Product createProductById(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("/product/{id}")
	public void deleteProductById(@PathVariable Long id) {
		productService.deleteProductById(id);
	}

}
