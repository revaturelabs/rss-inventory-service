package com.revature.inventory.dao;

import com.revature.inventory.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
	
	List<Product> findByCategory(String category);

}
