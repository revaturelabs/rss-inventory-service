package com.revature.inventory.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProductTest {

	Product product = new Product(1L, "category", "brand", "name", "description", "model", "image", 6, 100, "white");

	@Before
	public void before() {
		System.out.println("before tests");
	}

	@After
	public void after() {
		System.out.println("after tests");
	}

	@Test
	public void ProductAssertEquals() {
		assertEquals("category", product.getCategory());
		assertEquals("brand", product.getBrand());
		assertEquals("name", product.getName());
		assertEquals("description", product.getDescription());
		assertEquals("model", product.getModel());
		assertEquals("image", product.getImage());
	}

	@Test
	public void ProductAssertNotEquals() {
		assertNotEquals("klajskldjaskld", product.getName());
	}
}
