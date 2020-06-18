package com.revature.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.inventory.model.Product;
import com.revature.inventory.service.ProductService;
import com.revature.inventory.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	@Override
	public Product createProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public List<Product> findAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product findProductById(Long id) {
		return productDao.findById(id).get();
	}

	@Override
	public Product updateProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public void deleteProductById(Long id) {
		productDao.deleteById(id);
		
	}

}
