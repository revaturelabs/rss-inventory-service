package com.revature.inventory.service;

import com.revature.inventory.model.Product;

import java.util.List;

public interface ProductService {
	//POST
	public Product createProduct(Product product);

	//GET ALL
	public List<Product> findAllProducts();

	//GET BY ID
	public Product findProductById(Long id);

	//UPDATE
	public Product updateProduct(Product product);

	//DELETE
	public void deleteProductById(Long id);

}
