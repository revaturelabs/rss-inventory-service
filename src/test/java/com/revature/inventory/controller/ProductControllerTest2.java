package com.revature.inventory.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.inventory.model.Product;
import com.revature.inventory.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest2 {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ProductService service;

    private ObjectMapper mapper = new ObjectMapper();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetProductById() throws Exception{
		
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
		
        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(product);

        // Set mock (old sample below)
		//Mockito.when(productDao.save(product2)).thenReturn(product);
        Mockito.when(service.findProductById(1101L)).thenReturn(product);
        
        this.mockMvc.perform(get("/product/1101"))
        .andDo(print())
        .andExpect(status().isOk())
        //use the objectmapper output with the json method
        .andExpect(content().json(outputJson));

	}

	@Test
	void testGetAllProduct()  throws Exception {
		
		List<Product> pList = new ArrayList<>();
		
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
		
		pList.add(product);

		product.setId(1102L);
		product.setCategory("Electronics");
		product.setBrand("Apple");
		product.setName("Apple Watch 5");
		product.setDescription("Apple Watch Nike Series 40mm Gray");
		product.setModel("MX3T2LL/A");
		product.setImage("www.apple.watch5.image,com");
		product.setQuantity(50);
		product.setUnitPrice(299);
		product.setColor("Gray");

		pList.add(product);
		
        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(pList);
        
        // set mock
        Mockito.when(service.findAllProducts()).thenReturn(pList);
        
        // Run Test
        this.mockMvc.perform(get("/product"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(outputJson));
		
	}

	@Test
	void testCreateProductById() throws Exception {
		// create Request Body (no id)
		Product product = new Product();
		product.setCategory("Electronics");
		product.setBrand("Sony");
		product.setName("Headset");
		product.setDescription("Wired Headset - over the ear");
		product.setModel("BX300");
		product.setImage("www.sony.headset.image,com");
		product.setQuantity(25);
		product.setUnitPrice(10);
		product.setColor("Black");

		//Object to JSON in String
		String inputJson = mapper.writeValueAsString(product);
		
		// create Response Body (with id)
		Product product2 = new Product();
		product2.setId(1101L);
		product2.setCategory("Electronics");
		product2.setBrand("Sony");
		product2.setName("Headset");
		product2.setDescription("Wired Headset - over the ear");
		product2.setModel("BX300");
		product2.setImage("www.sony.headset.image,com");
		product2.setQuantity(25);
		product2.setUnitPrice(10);
		product2.setColor("Black");

		//Object to JSON in String
        String outputJson = mapper.writeValueAsString(product2);

        Mockito.when(service.createProduct(product)).thenReturn(product2);

        this.mockMvc.perform(post("/product")
        .contentType(MediaType.APPLICATION_JSON)
        .content(inputJson))
        //.accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(outputJson));
        
	}

	@Test
	void testUpdateProduct() throws Exception {
		// create Request/Response Body (with id)
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

		//Object to JSON in String
        String inputOutputJson = mapper.writeValueAsString(product);
		
        Mockito.when(service.updateProduct(product)).thenReturn(product);
        
        this.mockMvc.perform(put("/product")
        .contentType(MediaType.APPLICATION_JSON)
        .content(inputOutputJson))
        //.accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(inputOutputJson));
		
	}

	@Test
	void testDeleteProductById() throws Exception {
				
		Mockito.doNothing().when(service).deleteProductById(12345L);
		
	    this.mockMvc.perform(delete("/product/12345")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNoContent());
	
	}
	
//	@Test
//	public void should_Return404_When_ProductNotFound() throws Exception {
//	  /* setup mock */		
//	  Mockito.when(service.findProductById(12345L)).thenReturn(null);
//	  
//	  mockMvc.perform(get("/product/12345") 
//	          .accept(MediaType.APPLICATION_JSON))
//	          .andExpect(status().isNoContent());
//
//	}

}
