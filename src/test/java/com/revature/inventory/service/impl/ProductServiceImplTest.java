package com.revature.inventory.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.inventory.dao.ProductDao;
import com.revature.inventory.model.Product;

@RunWith(MockitoJUnitRunner.class)
class ProductServiceImplTest {

	@Mock
	ProductDao productDao;

	@InjectMocks
	ProductServiceImpl	productService;
	
	@BeforeEach
	void setUp() throws Exception {
	    MockitoAnnotations.initMocks(this); //without this you will get NullPointerException

		Product product = new Product();
		product.setId(1101L);
		product.setCategory("Electronics");
		product.setBrand("Sony");
		product.setName("Headset");
		product.setDescription("Wired Headset - over the ear");
		product.setModel("BX300");
		product.setImage("www.sony.headset.image,com");
		product.setQuantity(25);
		product.setUnitPrice(10);
		product.setColor("Black");
		
		Product product2 = new Product();
		product2.setCategory("Electronics");
		product2.setBrand("Sony");
		product2.setName("Headset");
		product2.setDescription("Wired Headset - over the ear");
		product2.setModel("BX300");
		product2.setImage("www.sony.headset.image,com");
		product2.setQuantity(25);
		product2.setUnitPrice(10);
		product2.setColor("Black");
		
		List<Product> pList = new ArrayList<>();
		pList.add(product);
		
		Mockito.when(productDao.save(product2)).thenReturn(product);
		Mockito.when(productDao.findById(1101L)).thenReturn(Optional.of(product));
		Mockito.when(productDao.findAll()).thenReturn(pList);
		
//		doReturn(product).when(productDao).save(product2);
//		doReturn(product).when(productDao).findById(1001L);
//		doReturn(pList).when(productDao).findAll();

	}

	@Test
	void testCreateFindFindAllProduct() {
		Product product2 = new Product();
		product2.setCategory("Electronics");
		product2.setBrand("Sony");
		product2.setName("Headset");
		product2.setDescription("Wired Headset - over the ear");
		product2.setModel("BX300");
		product2.setImage("www.sony.headset.image,com");
		product2.setQuantity(25);
		product2.setUnitPrice(10);
		product2.setColor("Black");
		
		product2 = productService.createProduct(product2);
		
		Product fromService = productService.findProductById(product2.getId());
		
		List<Product> fromServiceList = productService.findAllProducts();
		
		assertEquals(product2, fromService);
		assertEquals(1, fromServiceList.size());

	}

//	@Test
//	void testFindAllProducts() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testFindProductById() {
//		fail("Not yet implemented");
//	}

	@Test
	void testUpdateProduct() {
		// Instantiate a Product
		Product product = new Product();

		// Since we are not actually working with a db, we do not need to
        // insert a new row.
		product.setId(1101L);  // <-- artificial Product ID number;

		// plus other product fields
        product.setCategory("Electronics");
		product.setBrand("Sony");
		product.setName("Headset");
		product.setDescription("Wired Headset - over the ear");
		product.setModel("BX300");
		product.setImage("www.sony.headset.image,com");
		product.setQuantity(25);
		product.setUnitPrice(10);
		product.setColor("Black");
		
		// Declare an argument captor
        ArgumentCaptor<Product>  productCaptor = ArgumentCaptor.forClass(Product.class);
        
        doReturn(product).when(productDao).save(productCaptor.capture());

        // Act phase. execution.
        productService.updateProduct(product);
		
        // A phase. 
        // Verify in Mockito simply means that you want to check if a certain method of 
        // a mock object has been called by specific number of times.
        verify(productDao, times(1)).save(productCaptor.getValue());

        Product productCaptured = productCaptor.getValue();

        assertEquals(1101L, productCaptured.getId());
        assertEquals(product.getName(), productCaptured.getName());
        assertEquals(product.getBrand(), productCaptured.getBrand());

	}

	@Test
	void testDeleteProductById() {
        // When we remove a product, we capture an Long value.
        ArgumentCaptor<Long> longCaptor = ArgumentCaptor.forClass(Long.class);
        doNothing().when(productDao).deleteById(longCaptor.capture());

        // Act
        productService.deleteProductById(10L);

        verify(productDao, atLeastOnce()).deleteById(longCaptor.getValue());

        //assertEquals(10L, longCaptor.getValue().intValue());
        assertEquals(10L, longCaptor.getValue().longValue());

	}

}
