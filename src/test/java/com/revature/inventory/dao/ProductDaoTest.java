package com.revature.inventory.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.inventory.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ProductDaoTest {

	@Autowired
	ProductDao productDao;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		
	}

	@BeforeEach
	void setUp() throws Exception {
		productDao.deleteAll();
	}	
	
	

	@Test
	void testCreateProduct() {
		Product product = new Product();
		product.setCategory("Electronics");
		product.setBrand("Sony");
		product.setName("Headset");
		product.setDescription("Wired Headset noise cancelling");
		product.setModel("BX200");
		product.setImage("www.sony.headset.image.com");
		product.setQuantity(30);
		product.setUnitPrice(300);
		product.setColor("Black");
				
		product = productDao.save(product);

		Product productFromDb = productDao.findById(product.getId()).get();	
		assertEquals(productFromDb, product);
	}
	
	@Test
	void testFindAll() {
		Product product = new Product();
		product.setCategory("Electronics");
		product.setBrand("Sony");
		product.setName("Headset");
		product.setDescription("Wired Headset noise cancelling");
		product.setModel("BX200");
		product.setImage("www.sony.headset.image.com");
		product.setQuantity(30);
		product.setUnitPrice(300);
		product.setColor("Black");
				
		product = productDao.save(product);
		
		Product product2 = new Product();
		product2.setCategory("Electronics");
		product2.setBrand("Samsung");
		product2.setName("Watch");
		product2.setDescription("Smart Watch");
		product2.setModel("S200");
		product2.setImage("www.samsung.smartwatch.image.com");
		product2.setQuantity(20);
		product2.setUnitPrice(500);
		product2.setColor("Silver");

		productDao.save(product2);

		Product product3 = new Product();
		product3.setCategory("Clothing");
		product3.setBrand("Nike");
		product3.setName("Shirt");
		product3.setDescription("Red Shirt Printed");
		product3.setModel("RN10");
		product3.setImage("www.nike.shirt.image.com");
		product3.setQuantity(23);
		product3.setUnitPrice(100);
		product3.setColor("Red");

		productDao.save(product3);

		List<Product> productList = new ArrayList<>();
		
		productList = productDao.findAll();
		
		assertEquals(3,productList.size());	
	}


@Test
void testFindByCategory() {
	Product product = new Product();
	product.setCategory("Electronics");
	product.setBrand("Sony");
	product.setName("Headset");
	product.setDescription("Wired Headset noise cancelling");
	product.setModel("BX200");
	product.setImage("www.sony.headset.image.com");
	product.setQuantity(30);
	product.setUnitPrice(300);
	product.setColor("Black");
			
	productDao.save(product);
	
	Product product2 = new Product();
	product2.setCategory("Electronics");
	product2.setBrand("Samsung");
	product2.setName("Watch");
	product2.setDescription("Smart Watch");
	product2.setModel("S200");
	product2.setImage("www.samsung.smartwatch.image.com");
	product2.setQuantity(20);
	product2.setUnitPrice(500);
	product2.setColor("Silver");

	productDao.save(product2);

	Product product3 = new Product();
	product3.setCategory("Clothing");
	product3.setBrand("Nike");
	product3.setName("Shirt");
	product3.setDescription("Red Shirt Printed");
	product3.setModel("RN10");
	product3.setImage("www.nike.shirt.image.com");
	product3.setQuantity(23);
	product3.setUnitPrice(100);
	product3.setColor("Red");

	productDao.save(product3);

	List<Product> productList = new ArrayList<>();
	
	productList = productDao.findByCategory("Electronics");
	
	System.out.println(productList);
	
	assertEquals(2,productList.size());
	
	}
}
